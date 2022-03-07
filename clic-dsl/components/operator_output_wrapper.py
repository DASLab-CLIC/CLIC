from clic.components.superoperator import SuperOperator


class OperatorOutputBolt(object):
    def __init__(self, op: SuperOperator, op_output_field: dict):
        """
         this is operator output bolt.
        :param op: operator object
        :type op: SuperOperator
        :param op_output_field: which output of given operator
        :type op_output_field: str
        """
        self.op = op
        self.op_output_field = op_output_field

    def get_output_field(self):
        return self.op_output_field

    def get_output_op(self):
        return self.op
