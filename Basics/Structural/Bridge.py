class Shape:
    def __init__(self,renderer):
        self.renderer=renderer
    def draw(self):
        pass
class Circle(Shape):
    def __init__(self,renderer,radius):
        super().__init__(renderer)
        self.radius=radius
    def draw(self):
        self.renderer.render_circle(self.radius)
class Renderer:
    def render_circle(self,radius):
        pass
class StrRenderer(Renderer):
    def render_circle(self, radius):
        print(f"STR {radius}...")
class LineRenderer(Renderer):
    def render_circle(self, radius):
        print(f"LINE {radius}...")
str=StrRenderer()
li=LineRenderer()
c1=Circle(str,4)
c2=Circle(li,5)
c1.draw()
c2.draw()

