# Enum Singleton

class SingletonEnum(Enum):
    INSTANCE = 1
print(SingletonEnum.INSTANCE)

# # Double Checked Locking Singleton

class SingletonDoubleChecked:
    _instance = None
    _lock = threading.Lock()

    def __new__(cls, *args, **kwargs):
        if not cls._instance:
            with cls._lock:
                if not cls._instance:
                    cls._instance = super(SingletonDoubleChecked, cls).__new__(cls, *args, **kwargs)
        return cls._instance

# # Bill Pugh Singleton
class SingletonBillPugh:
    class _SingletonHelper:
        _instance = SingletonBillPugh()

    @staticmethod
    def get_instance():
        return SingletonBillPugh._SingletonHelper._instance

# # Simple Synchronized Singleton
class SingletonSynchronized:
    _instance = None
    _lock = threading.Lock()

    def __new__(cls, *args, **kwargs):
        with cls._lock:
            if not cls._instance:
                cls._instance = super(SingletonSynchronized, cls).__new__(cls, *args, **kwargs)
        return cls._instance