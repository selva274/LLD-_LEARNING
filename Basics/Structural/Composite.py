from abc import ABC,abstractmethod

class Shape(ABC):
    @abstractmethod
    def draw(self):
        pass
class Circle(Shape):
    def draw(self):
        return "Drawing Cirlce.."
class Line(Shape):
    def draw(self):
        return "Drawing Line..."
class GroupDraw(Shape):
    def __init__(self):
        self.shapes=[]
    def addshape(self,shape):
         self.shapes.append(shape)
    def draw(self):
        p=["Drawing Shapes..."]
        for s in self.shapes:
            p.append(s.draw())
        return "\n".join(p)
cir=Circle()
li=Line()
group=GroupDraw()
group.addshape(cir)
group.addshape(li)
print(group.draw())