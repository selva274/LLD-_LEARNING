class cel:
    def __init__(self,value):
        self.value=value
    def getValue(self):
        return self.value
class far:
    def __init__(self,cell):
        self.cell=cell
    def calculate(self): 
        return (self.cell.getValue()*9/5)+32
cellobj=cel(25)
farobj=far(cellobj)
print(farobj.calculate())