package basic.Visitors;

import basic.Operators.Operator;

import basic.traversal.AbstractTraversal;

import java.util.ArrayList;
import java.util.List;

public abstract class Visitor {
    protected AbstractTraversal planTraversal;
    public Visitor(AbstractTraversal planTraversal){
        this.planTraversal = planTraversal;
    }

    public abstract void visit(Operator opt);

    public void startVisit() {
        if (planTraversal.hasNextOpt()){
            Operator opt = planTraversal.nextOpt();
            opt.acceptVisitor(this);
        }

    }

}
