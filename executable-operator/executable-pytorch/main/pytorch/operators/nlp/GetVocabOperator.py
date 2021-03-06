
from executable.basic.model.OperatorBase import OperatorBase
import collections
import torchtext.vocab as Vocab


"""
Time       : 2021/8/6 2:59 下午
Author     : zjchen
Description:
"""


class GetVocabOperator(OperatorBase):
    def __init__(self, ID, inputKeys, outputKeys, Params):
        super().__init__("GetVocabOperator", ID, inputKeys, outputKeys, Params)

    def execute(self):
        self.setOutputData("result", self.get_vocab_imdb(self.getInputData("data")))

    def get_vocab_imdb(self, tokenized_data):
        counter = collections.Counter([tk for st in tokenized_data for tk in st])
        #     counter = dict(filter(lambda x: x[1] >= 5, counter.items()))
        #     idx_to_token = [tk for tk, _ in counter.items()]
        #     token_to_idx = {tk: idx for idx, tk in enumerate(idx_to_token)}
        return Vocab.Vocab(counter, min_freq=eval(self.params["min_freq"]))

