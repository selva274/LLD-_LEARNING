package Creational.Prototype;

class Character implements Cloneable{
    public String name;
    public int age;
    public int level;
    public Character(String name,int age,int level){
        this.name=name;
        this.age=age;
        this.level=level;
    }
    public void info(){
        System.out.println("Name : "+name+" age : "+age+" Level : "+level);
    }
    public Character clone() throws CloneNotSupportedException{
        return (Character) super.clone();
    }
}

class CharacterFactory{
    private Character pCharacter;
    public CharacterFactory(){
        pCharacter=new Character("default_name", 0, 0);
    }
    public Character byName(String name) throws CloneNotSupportedException{
        Character cCharacter=pCharacter.clone();
        cCharacter=new Character(name, cCharacter.age, cCharacter.level);
        return cCharacter;
    }
    public Character byAge(int age) throws CloneNotSupportedException {
        Character cCharacter=pCharacter.clone();
        cCharacter=new Character(cCharacter.name, age, cCharacter.level);
        return cCharacter;
    }
}


public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Character selva=new Character("selva",21, 10);
        selva.info();
        CharacterFactory factory= new CharacterFactory();
        Character raj=factory.byName("raj");
        Character mohan=factory.byAge(30);
        raj.info();
        mohan.info();

    }
}
