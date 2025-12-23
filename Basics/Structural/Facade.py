class SubsystemA:
    def operation_a(self):
        return "SubsystemA: Ready!\n"

    def operation_b(self):
        return "SubsystemA: Go!\n"


class SubsystemB:
    def operation_c(self):
        return "SubsystemB: Get ready!\n"

    def operation_d(self):
        return "SubsystemB: Fire!\n"


class Facade:
    def __init__(self, subsystem_a: SubsystemA, subsystem_b: SubsystemB):
        self._subsystem_a = subsystem_a
        self._subsystem_b = subsystem_b

    def operation(self):
        results = []
        results.append(self._subsystem_a.operation_a())
        results.append(self._subsystem_b.operation_c())
        results.append(self._subsystem_a.operation_b())
        results.append(self._subsystem_b.operation_d())
        return "".join(results)


# Client code
if __name__ == "__main__":
    subsystem_a = SubsystemA()
    subsystem_b = SubsystemB()
    facade = Facade(subsystem_a, subsystem_b)
    print(facade.operation())