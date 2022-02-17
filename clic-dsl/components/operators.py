import operator

from clic.components.operator_output_wrapper import OperatorOutputBolt
from clic.components.superoperator import *
from clic.components.operator_type import *

# SOURCE // 表示0个输入，1个输出
# SINK // 表示1个输入，0个输出
# MAP // 表示1个输入，1个输出
# JOIN // 表示有多个输入，一个输出
# FORK // 表示一个输入，多个输出，结构不常见
# OTHERS // 多个输入多个输出
# // 可能还需要添加其他的，向后添加


class SourceOperator(SuperOperator):

    def __init__(self,
                 operator_name: Operator,
                 platform_name:Platforms,
                 **kwargs):

        super().__init__(None)

        _operator_params = kwargs

        super().build(input_keys=[],
                      operator_name=Operator.operator_string_name(operator_name),
                      platform_name=Platforms.platform_string_name(platform_name),
                      operator_params=_operator_params)

    def parse(self, json_str: str):
        """
        parse a json string SourceOperator
        :param json_str:
        :type json_str:
        :return:
        :rtype:
        """
        # call super class's method
        super().parse(json_str)
        # parse other fields
        op_dic = json.loads(json_str)
        param = op_dic["Params"]

    def build_from_json(self, json_str: str):
        """
        use json to overwrite parameter of operators
        :param json_str: string type; json format operator
        """
        self.parse(json_str)


# for multiple output operator, say U, Sigma, V of SVD
# we define wrapper class of these output: SVD2uOperator, SVD2SigmaOperator, SVD2vOperator.
# all of such Operator encapsulate SVD operator, and keep a output name of SVD
# build _xx_op function return (SVD2uOperator, SVD2SigmaOperator, SVD2vOperator)

def build_src_op(operator_name:Operator,
                 platform_name: Platforms = Platforms.Spark,
                 **kwargs) -> OperatorOutputBolt :
    """
    **local function** for building SourceOperator
    :param input_path: string type; data input path of current operator
    :param separator: string type; separator of input data. e.g. "," for CSV, "\t" for TSV
    :param platform_name: Enum Platforms type; which platform to run this operator
    :return: OperatorOutputBolt
    """
    # inputKeys: list = [] . this will be set in SourceOperator class
    op = SourceOperator(operator_name,platform_name,**kwargs)
    return OperatorOutputBolt(op, {"result":"result"})


def build_src_op_from_url(json_obj: dict):
    """
    **remote closure function** for build_src_op_from_json
    :param json_obj: dictionary type; which encapsulates operator's parameter
    :return: function type; returned function is used to generator OperatorOutputBolt of SourceOperator
    """

    def build_src_op_from_json() -> OperatorOutputBolt:
        """
        function used to build SourceOperator with remote json object
        :return: OperatorOutputBolt
        """
        # use default parameters to initialize src operator
        src_op = SourceOperator("", ",", Platforms.Spark)
        src_op.build_from_json(json_obj)
        return OperatorOutputBolt(src_op, "result")

    return build_src_op_from_json

class SinkOperator(SuperOperator):
    def __init__(self,
                 dependencies: dict ,
                 operator_name: Operator ,
                 platform_name: Platforms ,
                 **kwargs):
        """
        SinkOperator class constructor
        :param dependencies: List of SuperOperator type; predecessors of current operator
        :param separator: string type; separator of input data. e.g. "," for CSV, "\t" for TSV
        :param output_path: string type; output data path of current operator
        :param platform_name: which platform to use.
        """
        # default initialization
        super().__init__(None)

        _operator_params = kwargs

        # set parameters
        _input_key = []
        if dependencies != None:
            op2id = SuperOperator.get_op_id_mapping()
            deps = [d for d in dependencies.keys() if d.op in op2id] #依赖关系的算子 deps都是bolt

            for dep in deps:
                dic = {}
                dic['name'] = dependencies[dep][1]
                dic['from'] = dep.op._nodeId
                dic['key'] = dep.op_output_field[dependencies[dep][0]]

                _input_key.append(dic)


        super().build(input_keys=_input_key,
                      operator_name=Operator.operator_string_name(operator_name),
                      platform_name=Platforms.platform_string_name(platform_name),
                      operator_params=_operator_params)


    def later_dependencies(self,dependencies:dict):
        op2id = SuperOperator.get_op_id_mapping()
        deps = [d for d in dependencies.keys() if d.op in op2id]
        _input_key = []
        for dep in deps:
            dic = {}
            dic['name'] = dependencies[dep][1]
            dic['from'] = dep.op._nodeId
            dic['key'] = dep.op_output_field[dependencies[dep][0]]

            _input_key.append(dic)

        super().set_input_keys(_input_key)


    def build_from_json(self, json_str: str):
        """
        use json to overwrite parameter of operators
        :param json_str: string type; json format of operator
        """
        self.parse(json_str)


def build_sink_op(dependencies: dict =None,
                  operator_name: Operator = Operator.SinkOperator,
                  platform_name: Platforms = Platforms.Spark,
                  **kwargs) -> OperatorOutputBolt:
    """
    **local function** for build SinkOperator
    :param dependencies: List of SuperOperator type; predecessor operators
    :param separator: string type; separator of input data. e.g. "," for CSV, "\t" for TSV
    :param output_path: string type; output data path of current operator
    :param platform_name:
    :return: SinkOperator
    """
    op = SinkOperator(dependencies, operator_name, platform_name,**kwargs)
    return OperatorOutputBolt(op,{"result":"result"})

def build_sink_op_from_url(json_obj: dict):
    """
    **remote closure function** for build_sink_op_from_json
    :param json_obj: dictionary type; which encapsulates operator's parameter
    :return: function type; returned function is used to generator SinkOperator
    """

    def build_sink_op_from_json(dependencies: list) -> SinkOperator:
        """
        function used to build SinkOperator with remote json object
        :return: SinkOperator
        """
        # use default parameters to initialize sink operator
        sink_op = SinkOperator(dependencies, ",", "", Platforms.Spark)
        sink_op.build_from_json(json_obj)
        return sink_op

    return build_sink_op_from_json

class MapOperator(SuperOperator):
    def __init__(self,
                 dependencies: dict ,
                 operator_name: Operator ,
                 platform_name: Platforms ,
                 **kwargs):
        """
        SinkOperator class constructor
        :param dependencies: List of SuperOperator type; predecessors of current operator
        :param separator: string type; separator of input data. e.g. "," for CSV, "\t" for TSV
        :param output_path: string type; output data path of current operator
        :param platform_name: which platform to use.
        """
        # default initialization
        super().__init__(None)

        _operator_params = kwargs

        # set parameters
        _input_key = []
        if dependencies != None:
            op2id = SuperOperator.get_op_id_mapping()
            deps = [d for d in dependencies.keys() if d.op in op2id] #依赖关系的算子 deps都是bolt

            for dep in deps:
                dic = {}
                dic['name'] = dependencies[dep][1]
                dic['from'] = dep.op._nodeId
                dic['key'] = dep.op_output_field[dependencies[dep][0]]

                _input_key.append(dic)


        super().build(input_keys=_input_key,
                      operator_name=Operator.operator_string_name(operator_name),
                      platform_name=Platforms.platform_string_name(platform_name),
                      operator_params=_operator_params)


    def later_dependencies(self,dependencies:dict):
        op2id = SuperOperator.get_op_id_mapping()
        deps = [d for d in dependencies.keys() if d.op in op2id]
        _input_key = []
        for dep in deps:
            dic = {}
            dic['name'] = dependencies[dep][1]
            dic['from'] = dep.op._nodeId
            dic['key'] = dep.op_output_field[dependencies[dep][0]]

            _input_key.append(dic)

        super().set_input_keys(_input_key)



    def build_from_json(self, json_str: str):
        """
        use json to overwrite parameter of operators
        :param json_str: string type; json format of operator
        """
        self.parse(json_str)

def build_map_op(dependencies: dict = None,
                  operator_name: Operator = Operator.SinkOperator,
                  platform_name: Platforms = Platforms.Spark,
                  **kwargs) -> OperatorOutputBolt:

    op = MapOperator(dependencies, operator_name, platform_name,**kwargs)
    return OperatorOutputBolt(op,{"result":"result"})


class ForkOperator(SuperOperator):
    def __init__(self,dependencies: dict,
                 operator_name: Operator ,
                 platform_name: Platforms ,
                 **kwargs):
        """
        SinkOperator class constructor
        :param dependencies: List of SuperOperator type; predecessors of current operator
        :param separator: string type; separator of input data. e.g. "," for CSV, "\t" for TSV
        :param output_path: string type; output data path of current operator
        :param platform_name: which platform to use.
        """
        # default initialization
        super().__init__(None)

        _operator_params = kwargs

        # set parameters
        _input_key = []
        if dependencies != None:
            op2id = SuperOperator.get_op_id_mapping()
            deps = [d for d in dependencies.keys() if d.op in op2id] #依赖关系的算子 deps都是bolt

            for dep in deps:
                dic = {}
                dic['name'] = dependencies[dep][1]
                dic['from'] = dep.op._nodeId
                dic['key'] = dep.op_output_field[dependencies[dep][0]]

                _input_key.append(dic)


        super().build(input_keys=_input_key,
                      operator_name=Operator.operator_string_name(operator_name),
                      platform_name=Platforms.platform_string_name(platform_name),
                      operator_params=_operator_params)


    def later_dependencies(self,dependencies:dict):
        op2id = SuperOperator.get_op_id_mapping()
        deps = [d for d in dependencies.keys() if d.op in op2id]
        _input_key = []
        for dep in deps:
            dic = {}
            dic['name'] = dependencies[dep][1]
            dic['from'] = dep.op._nodeId
            dic['key'] = dep.op_output_field[dependencies[dep][0]]

            _input_key.append(dic)

        super().set_input_keys(_input_key)


    def build_from_json(self, json_str: str):
        """
        use json to overwrite parameter of operators
        :param json_str: string type; json format of operator
        """
        self.parse(json_str)


def build_fork_op(dependencies: dict = None,
                 operator_name: Operator = Operator.SinkOperator,
                 platform_name: Platforms = Platforms.Spark,
                 **kwargs) -> OperatorOutputBolt:
    op = ForkOperator(dependencies, operator_name, platform_name, **kwargs)
    return OperatorOutputBolt(op, {"result":"result"} )


class JoinOperator(SuperOperator):
    def __init__(self,
                 dependencies: dict ,
                 operator_name: Operator,
                 platform_name: Platforms ,
                 **kwargs):
        """
        SinkOperator class constructor
        :param dependencies: List of SuperOperator type; predecessors of current operator
        :param separator: string type; separator of input data. e.g. "," for CSV, "\t" for TSV
        :param output_path: string type; output data path of current operator
        :param platform_name: which platform to use.
        """
        # default initialization
        super().__init__(None)

        _operator_params = kwargs

        # set parameters
        _input_key = []
        if dependencies != None:
            op2id = SuperOperator.get_op_id_mapping()
            deps = [d for d in dependencies.keys() if d.op in op2id] #依赖关系的算子 deps都是bolt

            for dep in deps:
                dic = {}
                dic['name'] = dependencies[dep][1]
                dic['from'] = dep.op._nodeId
                dic['key'] = dep.op_output_field[dependencies[dep][0]]

                _input_key.append(dic)


        super().build(input_keys=_input_key,
                      operator_name=Operator.operator_string_name(operator_name),
                      platform_name=Platforms.platform_string_name(platform_name),
                      operator_params=_operator_params)

    def later_dependencies(self,dependencies:dict):
        op2id = SuperOperator.get_op_id_mapping()
        deps = [d for d in dependencies.keys() if d.op in op2id]
        _input_key = []
        for dep in deps:
            dic = {}
            dic['name'] = dependencies[dep][1]
            dic['from'] = dep.op._nodeId
            dic['key'] = dep.op_output_field[dependencies[dep][0]]

            _input_key.append(dic)

        super().set_input_keys(_input_key)


    def build_from_json(self, json_str: str):
        """
        use json to overwrite parameter of operators
        :param json_str: string type; json format of operator
        """
        self.parse(json_str)


def build_join_op(dependencies: dict =None,
                 operator_name: Operator = Operator.SinkOperator,
                 platform_name: Platforms = Platforms.Spark,
                 **kwargs) -> OperatorOutputBolt:
    op = JoinOperator(dependencies, operator_name, platform_name, **kwargs)
    return OperatorOutputBolt(op, {"result":"result"})
