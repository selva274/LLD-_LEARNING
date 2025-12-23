from abc import ABC,abstractmethod

class flyBehaviour(ABC):
    @abstractmethod
    def fly(self):
        pass
class quackBehavoiur(ABC):
    @abstractmethod
    def quack(self):
        pass
class flywithwings(flyBehaviour):
    def fly(self):
        print("I can fly with wings..")
class flyno(flyBehaviour):
    def fly(self):
        print("I can't fly")
class soundquack(quackBehavoiur):
    def quack(self):
        print("Quack...Quack..")
class soundno(quackBehavoiur):
    def quack(self):
        print("No Sound")
class Duck(ABC):
    def __init__(self):
        self.fb:flyBehaviour=None
        self.qb:quackBehavoiur=None
    def fly(self):
        self.fb.fly()
    def quack(self):
        self.qb.quack()
    def set_quack_behaviour(self,qb:quackBehavoiur):
        self.qb=qb
    def set_fly_behaviour(self,fb:flyBehaviour):
        self.fb=fb
    @abstractmethod
    def display(self):
        pass
class Mallard(Duck):
    def __init__(self):
        super().__init__();
        self.fb=flywithwings()
        self.qb=soundquack()
    def display(self):
        print("I am Mallard")
class Rubber(Duck):
    def __init__(self):
        super().__init__();
        self.fb=flyno()
        self.qb=soundno()
    def display(self):
        print("I am Rubber")
if __name__=='__main__':
    mallard=Mallard()
    mallard.display()
    mallard.fly()
    mallard.quack()
    rubber=Rubber()
    rubber.display()
    rubber.fly()
    rubber.quack()
    print("****************************************")
    rubber.set_fly_behaviour(flywithwings())
    rubber.set_quack_behaviour(soundquack())
    rubber.display()
    rubber.fly()
    rubber.quack()