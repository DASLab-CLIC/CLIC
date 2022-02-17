from enum import Enum


class Platforms(Enum):
    """
    platforms supported by clic
    """
    Spark = 1
    JavaStream = 2
    TensorFlow = 3
    Pytorch = 4

    @staticmethod
    def _platforms2str_map() -> dict:
        """
        :return: {Enum Platform -> platform string name} dict
        :rtype: dict
        """
        maps = {
            Platforms.Spark: "spark",
            Platforms.JavaStream: "java",
            Platforms.TensorFlow: "tensorflow",
            Platforms.Pytorch: "pytorch"
        }
        return maps

    @staticmethod
    def platform_string_name(platform) -> str:
        """
        :param platform:
        :type platform: Enum Platforms
        :return: string name of Enum Platforms
        :rtype: str
        """
        maps = Platforms._platforms2str_map()
        return maps[platform]

    @staticmethod
    def is_legal_platform_name(platform: str):
        """
        given string name of platform, return true if platform is supported, otherwise false
        :param platform: string name of platform
        :type platform: str
        :return: return true if platform is supported, otherwise false
        :rtype: bool
        """
        maps = Platforms._platforms2str_map()
        platform_set = {maps[k] for k in maps}
        return platform in platform_set
