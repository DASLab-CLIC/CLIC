class ImmutableDict(dict):
    """
    immutable wrapper for dict object
    """
    def __setitem__(self, key, value):
        raise TypeError("immutable dict can not be modified value")
