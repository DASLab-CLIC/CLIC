from graphviz import Digraph
from clic.components.superoperator import SuperOperator


class DAG(object):

    _gz = Digraph("clic DAG", 'comment: DAG viz', None, None, 'png', None, "UTF-8",
                 {'rankdir': 'TB'},
                 {'color': 'black', 'fontcolor': 'black', 'fontname': 'Times-Roman',
                  'fontsize': '12', 'style': 'rounded', 'shape': 'box'},
                 {'color': '#999999', 'fontcolor': '#888888', 'fontsize': '10',
                  'fontname': 'Times-Roman'},
                 None, False)

    finished_state = {'color': 'green', 'fontcolor': 'green'}

    def __init__(self):
        pass

    def add_node(self, op: SuperOperator):
        self._gz.node(str(op.get_my_id()), op.get_my_op_name())

    def connect(self, src_op_id: int, src_out_field: str,
                dest_op_id: int, dest_out_field: str):
        mapping = src_out_field+":"+dest_out_field
        self._gz.edge(str(src_op_id), str(dest_op_id), mapping)
