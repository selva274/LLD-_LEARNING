from typing import Dict

class Flyweight:
    def __init__(self, shared_state: str):
        self.shared_state = shared_state

    def operation(self, unique_state: str):
        print(f"Flyweight: Displaying shared ({self.shared_state}) and unique ({unique_state}) state.")

class FlyweightFactory:
    def __init__(self):
        self._flyweights: Dict[str, Flyweight] = {}

    def get_flyweight(self, shared_state: str) -> Flyweight:
        if shared_state not in self._flyweights:
            print(f"FlyweightFactory: Creating new flyweight for shared state '{shared_state}'.")
            self._flyweights[shared_state] = Flyweight(shared_state)
        else:
            print(f"FlyweightFactory: Reusing existing flyweight for shared state '{shared_state}'.")
        return self._flyweights[shared_state]

    def list_flyweights(self):
        print(f"FlyweightFactory: Current flyweights: {list(self._flyweights.keys())}")

# Example usage
if __name__ == "__main__":
    factory = FlyweightFactory()

    flyweight1 = factory.get_flyweight("StateA")
    flyweight1.operation("Unique1")

    flyweight2 = factory.get_flyweight("StateB")
    flyweight2.operation("Unique2")

    flyweight3 = factory.get_flyweight("StateA")
    flyweight3.operation("Unique3")

    factory.list_flyweights()