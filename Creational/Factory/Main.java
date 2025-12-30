package Creational.Factory;

interface Vehicle {
  public void start();
  public void run();    
}

class Bike implements Vehicle{
    public void start(){
        System.out.println("Bike is starting..");
    }
    public void run(){
        System.out.println("Bike is Runnning...");
    }
}
class Car implements Vehicle{
    public void start(){
        System.out.println("Car is starting");
    }
    public void run(){
        System.out.println("Car is runnning..");
    }
}
class VehicleFactory{
    public  static Vehicle getVehicleType(String vehicleType){
    Vehicle vehicle;
   if(vehicleType=="car"){
      vehicle=new Car();
   }else if(vehicleType=="bike"){
    vehicle=new Bike();
   }else{
    throw new IllegalArgumentException("Unknown Type");
   }
   return vehicle;
    }
}
class Main {
public static void main(String[] args) {
   Vehicle bike=VehicleFactory.getVehicleType("bike");
   bike.start();
   bike.run();
}
}
