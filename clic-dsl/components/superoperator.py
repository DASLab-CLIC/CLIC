import json
from clic.platform import Platforms
from clic.components.operator_type import Operator
from clic.components.utilities import *


class SuperOperator(object):
    """ Super class of all kinds of Operator class. e.g. SourceOperator
    :arg
        _node_id: class static variable. used to assign to each operator object
        _op2id: class static variable. mapping operator object to node_id
        _immutable: immutable wrapper of _op2id
    """
    _node_id = 1
    _op2id = dict()
    _immutable_op2id = None

    def __init__(self, json_str: str):
        """
        constructor from json string
        :param json_str: formatted json string
        :type json_str: string
        """
        # 默认构造
        self._nodeId = SuperOperator._get_node_id()
        self._platform = \
            Platforms.platform_string_name(Platforms.Spark)  # default platform
        self._operatorName = ""  # illegal
        self._operatorParams = []  # [dict(), dict()]
        self._input_keys = []
        self._output_keys = ["result"] #暂时写死，还没有将Bolt适配进来 也没有它的应用场景

        # 重新设置参数; 不会覆盖类的 _nodeId
        if json_str is not None:
            self.parse(json_str)
        # 添加 operator 到 nodeId的映射
        SuperOperator._op2id[self] = self._nodeId


        SuperOperator._immutable_op2id = ImmutableDict(SuperOperator._op2id)

    # do not expose to user
    def build(self,
              input_keys: list,
              operator_name: str,
              platform_name: str = Platforms.platform_string_name(Platforms.Spark),
              operator_params=None):
        """
        set parameters
        :param input_keys: List of int type; predecessor operators
        :param operator_name: String type, returned by Operator.string_name; which operator to use
        :param platform_name: String type, returned by Platform.string_name; which platform to run this op
        :param operator_params: dict type, set given operator parameters
        :return:
        """
        # operator_params: transfer each kv to a dict
        if operator_params is None:
            operator_params = {}
        self._input_keys = input_keys
        self._operatorName = operator_name
        self._platform = platform_name
        self._operatorParams = \
            [{"name": k, "value": str(v)} for k, v in operator_params.items()]

    def parse(self, json_str: str):
        """
        should be overwrite.parse json string to operator.
        in this father class, only "Platform" "Params" and "Name" fields will be checked.
        :param json_str:
        :type json_str:
        :return: partially checked and assign related value to this class's fields
        :rtype: dict
        """

        op_dic = json.loads(json_str)
        if type(op_dic) is not dict:
            raise Exception("operator json string is illegal")

        if "Platform" not in op_dic or not Platforms.is_legal_platform_name(op_dic["Platform"]):
            raise Exception("unsupported platform!")

        if "Name" not in op_dic or not Operator.is_legal_operator_name(op_dic["Name"]):
            raise Exception("unsupported operator")

        if "Params" not in op_dic:
            raise Exception("no parameter error")

        self._operatorName = op_dic["Name"]
        self._platform = op_dic["Platform"]
        self._operatorParams = op_dic["Params"]

    def check(self):
        """
        如果operator name 没有指定，这个operator尚未完全初始化
        :return:
        """
        return self._operatorName != ""

    def op2dict(self):
        """
        serialize this operator to json
        :return:
        """
        if self.check():
            return {
                "Id": self._nodeId,
                "Platform": self._platform,
                "Name": self._operatorName,
                "Params": self._operatorParams,
                "inputKeys": self._input_keys,
                "outputKeys": self._output_keys
            }
        else:
            raise Exception("unnamed operator!")

    def get_my_id(self):
        return self._nodeId

    def get_my_op_name(self):
        return self._operatorName

    @staticmethod
    def _get_node_id():
        """
        return newly assigned node_id
        :return: newly assigned node_id
        """
        cur = SuperOperator._node_id
        SuperOperator._node_id = SuperOperator._node_id + 1
        return cur

    @staticmethod
    def get_op_id_mapping() -> ImmutableDict:
        """
        return immutable _op2id static variable
        :return: immutable _op2id static variable
        """
        return SuperOperator._immutable_op2id

    def set_input_keys(self,input_keys):
        self._input_keys = input_keys

"""
样例
"nodeId": 1,     //可定制
            "dependencies": [],      //可定制
            "platformName": "spark",   //可定制，枚举类型
            "operatorInfo": {
                "operatorName": "SourceOperator",   //枚举类型
                "operatorParams": [     //如何统一
                    {
                        "name": "inputPath",
                        "value": "/data/user/simplecase/test.csv"
                    },
                    {
                        "name": "separator",
                        "value": ","
                    }
                ],
                "inputKeys": [
                    "data"
                ],
                "outputKeys": [
                    "result"
                ]
            }
"""
