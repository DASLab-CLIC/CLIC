package api;

import basic.Operators.*;
import basic.Visitors.ExecuteVisitor;
import basic.Visitors.ExecutionGenerationVisitor;
import basic.Visitors.PrintVisitor;
import basic.traversal.AbstractTraversal;
import basic.traversal.BfsTraversal;
import basic.traversal.DfsTraversal;
import basic.traversal.TopTraversal;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

public class PlanBuilder {
    private LinkedList<Operator> pipeline;
    private DataQuanta headDataQuanta = null; // 其实可以有多个head

    // 现在最简单粗暴的方法是将图存储在PlanBuilder中
    private List<DataQuanta> dataQuantaList = new ArrayList<>();
    private DataQuanta presentDataQuanta = null; // head永远是present的上一个节点

    private String context;

    /**
     *
     * @param context 临时充当 OperatorMapping文件的路径
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public PlanBuilder(String context ) throws IOException, SAXException, ParserConfigurationException {
        pipeline = new LinkedList<>();
        // executionPlan = new LinkedList<>();

        this.context = context;
        OperatorFactory.initMapping(context);

    }

    public PlanBuilder() throws ParserConfigurationException, SAXException, IOException {
        // TODO: 改一下默认文件路径的传输方式（用命令行传入）
        //this(System.getProperty("user.dir")+"/resources/OperatorTemplates/OperatorMapping.xml");
        this("resources/OperatorTemplates/OperatorMapping.xml");
    }

    public DataQuanta readDataFrom(Map<String, String> params) throws Exception {
        DataQuanta dataQuanta = DataQuanta.createInstance("source", params);
        this.headDataQuanta = dataQuanta;
        return this.headDataQuanta; // 不需要connectTo
    }

    public DataQuanta getHeadDataQuanta() {
        return headDataQuanta;
    }

    /**
     * 把 headOperator 交给各类Visitor
     * 1: Optimize the pipeline structure
     * 2: Mapping operator to Executable, Platform depended Operator
     * 3. Run
     */
    public void execute() throws InterruptedException {
        this.logging("===========【Stage 1】Get User Defined Plan ===========");
        this.printPlan();
        this.logging("   ");

        this.logging("===========【Stage 2】Choose best Operator implementation ===========");
        this.optimizePlan();
        this.printPlan();
        this.logging("   ");

        this.logging("===========【Stage 3】execute plan ==========");
        this.executePlan();

    }

    public void printPlan(){
        this.logging("Current Plan:");
        AbstractTraversal planTraversal = new TopTraversal(this.getHeadDataQuanta().getOperator());
        PrintVisitor printVisitor = new PrintVisitor(planTraversal);
        printVisitor.startVisit();
//        for (Visitable v : plan){
//            v.acceptVisitor(printVisitor);
//        }
    }

    public void optimizePlan(){
        AbstractTraversal planTraversal = new BfsTraversal(this.getHeadDataQuanta().getOperator());
        ExecutionGenerationVisitor executionGenerationVisitor = new ExecutionGenerationVisitor(planTraversal);
        executionGenerationVisitor.startVisit();
        // this.getHeadDataQuanta().getOperator().acceptVisitor(executionGenerationVisitor);
//        for (Operator operator : this.pipeline){
//            operator.acceptVisitor(executionGenerationVisitor);
//        }
    }


    private void executePlan(){
        AbstractTraversal planTraversal = new BfsTraversal(this.getHeadDataQuanta().getOperator());
        ExecuteVisitor executeVisitor = new ExecuteVisitor(planTraversal);
        executeVisitor.startVisit();
//        for (Operator opt : this.pipeline){
//            opt.acceptVisitor(executeVisitor);
//        }
    }

    // TODO: 这switch就得改了 DAG里不知道1，2是哪个opt
    private LinkedList<Operator> optimizePipeline(){
        this.switchOperator(1, 2);
        return this.pipeline;
    }

    /**
     * 交换pipeline中任意两opt的位置，用于算子重组
     * @param idx1 第一个opt的idx
     * @param idx2 第二个opt的idx
     */
    private void switchOperator(int idx1, int idx2){
        this.logging(String.format("->    Switching Opt %s @%d with %s @%d",
                this.pipeline.get(idx1).getID(), idx1,
                this.pipeline.get(idx2).getID(), idx2
        ));
        assert idx1 < this.pipeline.size() : "idx1是无效的索引";
        assert idx2 < this.pipeline.size() : "idx2是无效的索引";
        Operator opt1 = this.pipeline.get(idx1);
        Operator opt2 = this.pipeline.get(idx2);

        this.pipeline.add(idx1, opt2);
        this.pipeline.remove(idx1 + 1); // 删除原来的opt1

        this.pipeline.add(idx2, opt1);
        this.pipeline.remove(idx2 + 1);
    }

    private void logging(String s){
        System.out.println(s);
    }
}
