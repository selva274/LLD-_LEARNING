package Creational.AbstractFactory;

interface Bike {
    void start();
}
class BMW implements Bike{
   public void start()
    {
        System.out.println("BMW is starting..");
    }
}

class Honda implements Bike{
    public void start(){
        System.out.println("Honda is starting...");
    }
}

class Yamaha implements Bike{
    public void start(){
        System.out.println("Yamaha is starting..");
    }
}

interface BikeFactory {
    Bike CreateBike();
}

class BmwFactory implements BikeFactory{
    public Bike CreateBike(){
        return new BMW();
    }
}

class HondaFactory implements BikeFactory{
    public Bike CreateBike(){
        return new Honda();
    }
}

class YamahaFactory implements BikeFactory{
    public Bike CreateBike(){
        return new Yamaha();
    }
}

public class Main{
    public static void main(String[] args) {
        BikeFactory bmwFactory=new BmwFactory();
        Bike bmw=bmwFactory.CreateBike();
        bmw.start();

        BikeFactory hondafactory=new HondaFactory();
        Bike honda=hondafactory.CreateBike();
        honda.start();
    }
}