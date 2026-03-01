package Structural.Composite;

import java.util.ArrayList;
import java.util.List;

interface SmartComponent {
    void turnON();

    void tunrOff();
}

class AirCondiotioner implements SmartComponent {
    @Override
    public void turnON() {
        System.out.println("Air Conditionner is now ON.");
    }

    @Override
    public void tunrOff() {
        System.out.println("Air Conditioner is noew off.");
    }
}

class SmartLight implements SmartComponent {

    @Override
    public void turnON() {
        System.out.println("Smart Light is now ON.");
    }

    @Override
    public void tunrOff() {
        System.out.println("SmartLight is now off");
    }

}

class CompositeSmartComponent implements SmartComponent {
    private List<SmartComponent> components = new ArrayList<>();

    public void addComponent(SmartComponent component) {
        components.add(component);
    }

    public void removeComponent(SmartComponent component) {
        components.remove(component);
    }

    @Override
    public void turnON() {
        for (SmartComponent component : components) {
            component.turnON();
        }
    }

    @Override
    public void tunrOff() {
        for (SmartComponent component : components) {
            component.tunrOff();
        }
    }

}

class Main {
    public static void main(String[] args) {
        SmartComponent airConditioner = new AirCondiotioner();
        SmartComponent smartLight = new SmartLight();

        CompositeSmartComponent room1 = new CompositeSmartComponent();
        room1.addComponent(airConditioner);
        room1.addComponent(smartLight);

        CompositeSmartComponent room2 = new CompositeSmartComponent();
        room2.addComponent(new AirCondiotioner());
        room2.addComponent(new SmartLight());

        CompositeSmartComponent floor = new CompositeSmartComponent();
        floor.addComponent(room1);
        floor.addComponent(room2);

        CompositeSmartComponent house = new CompositeSmartComponent();
        house.addComponent(floor);

        System.out.println("Turning ON all devices in the house:");
        house.turnON();
        System.out.println("nTurning OFF all devices in the house:");
        house.tunrOff();
        System.out.println("nTurning ON all devices in Room 1:");
        room1.turnON();
        System.out.println("nTurning OFF all devices in Room 1:");
        room1.tunrOff();
    }
}