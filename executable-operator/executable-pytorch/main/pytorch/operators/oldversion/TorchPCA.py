import torch
from executable.basic.model.OperatorBase import OperatorBase

"""
@ProjectName: CLIC
@Time       : 2020/11/25 下午12:09
@Author     : zjchen
@Description: 对tensor进行PCA处理
"""


class TorchPCA(OperatorBase):
    def __init__(self, ID, inputKeys, outputKeys, Params):
        super().__init__("TorchPCA", ID, inputKeys, outputKeys, Params)

    def execute(self):
        self.setOutputData("result", torch.pca_lowrank(self.getInputData("data"),
                                                       int(self.params["k"]),
                                                       (self.params["center"].lower() == 'true')
                                                       )[2].t())


    # def PCA_svd(self, X, k, center=True):
    #     print(type(X))
    #     n = X.size()[0]
    #     ones = torch.ones(n).view([n, 1])
    #     h = ((1/n) * torch.mm(ones, ones.t())) if center else torch.zeros(n*n).view([n, n])
    #     H = torch.eye(n) - h
    #     # print(h)
    #     # print(H)
    #     # H = H.cuda()
    #     X_center = torch.mm(H.double(), X.double())
    #     u, s, v = torch.svd(X_center)
    #     components = v[:k].t()
    #     # explained_variance = torch.mul(s[:k], s[:k])/(n-1)
    #     return components
