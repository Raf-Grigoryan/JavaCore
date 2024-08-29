package book.chapter8.test3;

public class AnimalDemo {
    public static void main(String[] args) {
        Dog dog = new Dog("Bob",12,"Samuel");
        GuardDog dog2= new GuardDog("Graf",2,"Jerry");
        dog.makeSound();
        dog2.makeSound(12);
    }
}
