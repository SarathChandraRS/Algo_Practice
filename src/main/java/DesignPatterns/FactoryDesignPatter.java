package DesignPatterns;

public class FactoryDesignPatter {

    public static Animal getAnimal(String animalType){
        Animal animal;
        if(animalType.equals("Dog")){
            animal = new Dog();
        }else{
            animal = new Cat();
        }
        return animal;
    }
}


interface Animal{
    public abstract void makeSound();
}

class Dog implements Animal{

    @Override
    public void makeSound() {
        System.out.println("barks");
    }
}

class Cat implements Animal{

    @Override
    public void makeSound() {
        System.out.println("Meows");
    }
}