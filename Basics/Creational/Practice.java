package Creational;
interface flyBehaviour{
    void fly();
}
interface quackBehavior{
    void quack();
}
class flyWithWings implements flyBehaviour{
    public void fly(){
        System.out.println("I fly with wings");
    }
}
class flyNo implements flyBehaviour{
    public void fly(){
        System.out.println("I can't fly");
    }
}
class SoundQuack implements quackBehavior{
    public void quack(){
        System.out.println("Quack...Quack");
    }
}
class SoundNo implements quackBehavior{
    public void quack(){
        System.out.println("No Sound");
    }
}
abstract class Duck{
   flyBehaviour fb;
   quackBehavior qb;
   public void fly(){
    fb.fly();
   }
   public void quack(){
    qb.quack();
   }
   public void setFlyBehavior(flyBehaviour fb){
    this.fb=fb;
   }
   public void setQuackBehavior(quackBehavior qb){
    this.qb=qb;
   }
   abstract public void display();
}
class Mallard extends Duck{
    public Mallard(){
        fb=new flyWithWings();
        qb=new SoundQuack();
    }
    public void display(){
        System.out.println("I am mallard");
    }
}
class Rubber extends  Duck{
    public Rubber(){
        fb=new flyNo();
        qb=new SoundNo();
    }
    public void display(){
        System.out.println("I am Rubber");
    }
}
public class Practice {
    public static void main(String[] args) {
        Duck mallard=new Mallard();
        mallard.fly();
        mallard.quack();
    }
}
