package Structural.Adapter;

interface SmartDevice {
void turnOn();
void tunrOff();
}

class AirConditioner{
    public void connectViaBluetooth(){
        System.out.println("Air Conditioner...Bluetooth");
    }
    public void startCooling(){
        System.out.println("Air conditioner is cooling");
    }
    public void stopCooling(){
        System.out.println("Air Conditioner stopped Cooliing");
    }
    public void disconnectBluetooth(){
        System.out.println("Air Conditioner disconnected from bluetooth");
    }
}

class SmartLight{
    public void connectToWifi(){
        System.out.println("Smart Light....wifi");
    }
    public void switchOn(){
        System.out.println("smart light....switch on");
    }
    public void switchOff(){
        System.out.println("smart light...switch off");
    }
    public void disconnectWifi(){
        System.out.println("smart light...disconnected from wifi");
    }
}

class CoffeMachine{
    public void initializeZigbee(){
        System.out.println("coffee Machine...zigbee");
    }
    public void startBrewing(){
        System.out.println("coffe machine..start Brewing");
    }
    public void stopBrewing(){
        System.out.println("coffee machine...stop Brewing");
    }

    public void terminalZigbee(){
        System.out.println("coffe machine...termination from zigbee");
    }    
}

class AirConditionerAdapter implements SmartDevice{
    private AirConditioner airConditioner;
    public AirConditionerAdapter(AirConditioner airConditioner){
        this.airConditioner=airConditioner;
    }
    @Override
    public void turnOn() {
        airConditioner.connectViaBluetooth();
        airConditioner.startCooling();
    }

    @Override
    public void tunrOff() {
        airConditioner.startCooling();
        airConditioner.disconnectBluetooth();
    }
}

class SmarLightAdapter implements SmartDevice{
    private SmartLight smartLight;
    public SmarLightAdapter(SmartLight smartLight){
        this.smartLight=smartLight;
    }


    @Override
    public void turnOn() {
        smartLight.connectToWifi();
        smartLight.switchOn();
    }

    @Override
    public void tunrOff() {
        smartLight.switchOff();
        smartLight.disconnectWifi();
    }
}

class CoffeeMachineAdapter implements SmartDevice{
    private CoffeMachine coffeMachine;
    public CoffeeMachineAdapter(CoffeMachine coffeMachine){
        this.coffeMachine=coffeMachine;
    }
    @Override
    public void turnOn() {
        coffeMachine.initializeZigbee();
        coffeMachine.startBrewing();
    }
    @Override
    public void tunrOff() {
        coffeMachine.startBrewing();
        coffeMachine.terminalZigbee();
    }
    
}

class Main {
    public static void main(String[] args) {
        SmartDevice airConditioner=new AirConditionerAdapter(new AirConditioner());
        SmartDevice smartLight=new SmarLightAdapter(new SmartLight());
        SmartDevice coffeeMachine=new CoffeeMachineAdapter(new CoffeMachine());

        airConditioner.turnOn();
        smartLight.turnOn();
        coffeeMachine.turnOn();

        airConditioner.tunrOff();
        smartLight.tunrOff();
        coffeeMachine.tunrOff();
    }
    
}
