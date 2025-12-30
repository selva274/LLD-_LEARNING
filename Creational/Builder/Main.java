package Creational.Builder;

class Car{
    private String engine;
    private String color;
    private String name;
    private Car(CarBuilder builder){
        this.engine=builder.engine;
        this.color=builder.color;
        this.name=builder.name;
    }
    public String getEngine(){
        return engine;
    }
    public String getColor(){
        return color;
    }
    public String getName(){
        return name;
    }
    public static class CarBuilder{
        private String engine="default engine";
        private String color="default color";
        private String name="default name";
        
        public CarBuilder setEngine(String engine){
            this.engine=engine;
            return this;
        }
        public CarBuilder setColor(String color){
            this.color=color;
            return this;
        }
        public CarBuilder setName(String name){
            this.name=name;
            return this;
        }

        public Car build(){
            return new Car(this);
        }

    }
}

public class Main {
    public static void main(String[] args) {
        Car.CarBuilder builder=new Car.CarBuilder();
        Car car1=builder.setColor("red").build();
        System.out.println(car1.getName());
    }
}
