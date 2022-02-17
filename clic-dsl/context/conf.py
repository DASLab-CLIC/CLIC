class ClicConf(object):

    def __init__(self, cluster_ip: str, cluster_port: int):
        """
        :param cluster_ip:
        :param cluster_port: with ip to connect to cluster. for submit task
        """
        self._cluster_ip = cluster_ip
        self._cluster_port = cluster_port

    def get_cluster_ip(self):
        return self._cluster_ip

    def get_cluster_port(self):
        return self._cluster_port
