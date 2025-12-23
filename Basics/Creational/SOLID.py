from abc import ABC, abstractmethod

#SOLID PRINCIPLE
# S - Single Responsibility Principle
class User:
    def Authenticate(self, username, password):
        pass
    def UpdateProfile(self,id,profile_photo):
        pass
##################################################
class UserAuthentication:
    def Authenticate(self, username, password):
        pass
class UserProfile:
    def UpdateProfile(self, id, profile_photo):
        pass
class EmailNotifier:
    def SendEmail(self, email, subject, message):
        pass
######################################################
# O - Open/Closed Principle
class Shape:
    def __init__(self,radius,length,breadth):
        self.radius=radius
        self.length=length
        self.breadth=breadth
    def CircleArea(self):
        return 3.14*self.radius*self.radius
    def RectangleArea(self):
        return self.length*self.breadth
shape=Shape(5,10,20)
print(shape.CircleArea())
print(shape.RectangleArea())    

#####################################################
from abc import ABC,abstractmethod
class Shape(ABC):
    @abstractmethod
    def Area(self):
        pass
class Circle(Shape):
    def __init__(self,radius):
        self.radius=radius
    def Area(self):
        return 3.14*self.radius*self.radius
class Rectangle(Shape):
    def __init__(self,length,breadth):
        self.length=length
        self.breadth=breadth
    def Area(self):
        return self.length*self.breadth
circle=Circle(10)
print(circle.Area())
rectangle=Rectangle(10,20)
print(rectangle.Area())
##########################################################
# L - Liskov Substitution Principle
class Bird:
    def fly(self):
        print("I can fly")
class Peng(Bird):
    pass
peng=Peng()
peng.fly()
############################################
class Bird:
    def fly(self):
        print("I can fly")
class Peng(Bird):
    def fly(self):
        raise NotImplemented
peng=Peng()
peng.fly()

#################################################
# I - Interface Segregation Principle
from abc import ABC,abstractmethod
class Printer(ABC):
    @abstractmethod
    def print_document(self, document):
        pass

class Scanner(ABC):
    @abstractmethod
    def scan_document(self, document):
        pass

class MultiFunctionPrinter(Printer, Scanner):
    def print_document(self, document):
        print(f"Printing: {document}")

    def scan_document(self, document):
        print(f"Scanning: {document}")

class SimplePrinter(Printer):
    def print_document(self, document):
        print(f"Printing: {document}")

# Example usage
mfp = MultiFunctionPrinter()
mfp.print_document("Report.pdf")
mfp.scan_document("Photo.jpg")

printer = SimplePrinter()
printer.print_document("Invoice.pdf")
#######################################################
# D - Dependency Inversion Principle

class NotificationService(ABC):
    @abstractmethod
    def send(self, message):
        pass

class EmailNotificationService(NotificationService):
    def send(self, message):
        print(f"Sending Email: {message}")

class SMSNotificationService(NotificationService):
    def send(self, message):
        print(f"Sending SMS: {message}")

class NotificationManager:
    def __init__(self, service):
        self.service = service

    def notify(self, message):
        self.service.send(message)

# Example usage
email_service = EmailNotificationService()
sms_service = SMSNotificationService()

manager = NotificationManager(email_service)
manager.notify("Hello via Email!")

manager = NotificationManager(sms_service)
manager.notify("Hello via SMS!")
