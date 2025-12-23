from functools import wraps

# Base Component
class Component:
    def operation(self):
        return "Component"

# Base Decorator
class Decorator(Component):
    def __init__(self, component):
        self._component = component

    def operation(self):
        return self._component.operation()

# Concrete Decorators
class ConcreteDecoratorA(Decorator):
    def operation(self):
        return f"ConcreteDecoratorA({self._component.operation()})"

class ConcreteDecoratorB(Decorator):
    def operation(self):
        return f"ConcreteDecoratorB({self._component.operation()})"

# Client Code
if __name__ == "__main__":
    simple = Component()
    print("Simple Component:", simple.operation())

    decorator1 = ConcreteDecoratorA(simple)
    print("After applying ConcreteDecoratorA:", decorator1.operation())

    decorator2 = ConcreteDecoratorB(decorator1)
    print("After applying ConcreteDecoratorB:", decorator2.operation())