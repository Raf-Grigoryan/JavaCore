package book.chapter8.test3;

import java.util.Objects;

public class Dog extends Animal {
    private String ownerName;

    public Dog(String name, int age, String ownerName) {
        super(name, age);
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public void makeSound() {
        System.out.println("Hav-Hav");
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(ownerName, dog.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ownerName);
    }

    @Override
    public String toString() {
        return super.toString() +  "Dog{" +
                "ownerName='" + ownerName + '\'' +
                '}';
    }
}
