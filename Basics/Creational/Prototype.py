import copy
class Prototype:
    def clone(self):
        return copy.deepcopy(self)
class ConcretePrototype(Prototype):
    def __init__(self,value):
        self.value=value
original=ConcretePrototype(27)
clone=original.clone()
print(original.value)
print(clone.value)      