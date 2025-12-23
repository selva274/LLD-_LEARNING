from abc import ABC
from Vehicle_type import VehicleType
class Vehicle(ABC):
    def __init__(self,license_plate,vehicle_type:VehicleType):
        self.license_plate=license_plate
        self.type=vehicle_type
    def get_type(self)->VehicleType:
        return self.type