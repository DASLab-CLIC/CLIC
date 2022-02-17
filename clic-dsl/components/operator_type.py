from enum import Enum


class Operator(Enum):
    """
    operators supported by clic
    """
    SourceOperator = 1

    MapOperator = 2
    FilterOperator = 3
    SinkOperator = 4

    TokenizedOperator = 5
    GetVocabOperator = 6
    PreprocessImdbOperator = 7
    DataLoadOperator = 8
    W2VOperator = 9
    GetWordDictOperator = 10
    NetProcessOperator = 11
    TrainOperator = 12
    ForkOperator = 13
    JoinOperator = 14

    @staticmethod
    def _operators2str_map() -> dict:
        """
        :return: {Enum Operator -> operator string name} dict
        :rtype: dict
        """
        maps = {
            Operator.SourceOperator: "SourceOperator",
            Operator.MapOperator: "MapOperator",
            Operator.FilterOperator: "FilterOperator",
            Operator.SinkOperator: "SinkOperator",

            Operator.TokenizedOperator: "TokenizedOperator",
            Operator.GetVocabOperator: "GetVocabOperator",
            Operator.PreprocessImdbOperator: "PreprocessImdbOperator",
            Operator.DataLoadOperator: "DataLoadOperator",
            Operator.W2VOperator: "W2VOperator",
            Operator.GetWordDictOperator: "GetWordDictOperator",
            Operator.NetProcessOperator: "NetProcessOperator",
            Operator.TrainOperator: "TrainOperator"
        }
        return maps

    @staticmethod
    def operator_string_name(op) -> str:
        """
        transfer Enum type of operator to ***standard string***
        :param op: Enum Operator to be transferred into string name
        :type op: Enum Operator type
        :return: operator standard string name
        :rtype: str
        """
        maps = Operator._operators2str_map()
        return maps[op]

    @staticmethod
    def is_legal_operator_name(operator: str):
        """
        given string name of operator, return true if platform is supported, otherwise false
        :param operator: string name of operator
        :type operator: str
        :return: return true if operator is supported, otherwise false
        :rtype: bool
        """
        maps = Operator._operators2str_map()
        op_set = {maps[k] for k in maps}
        return operator in op_set
