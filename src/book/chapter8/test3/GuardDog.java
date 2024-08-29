package book.chapter8.test3;

public final class GuardDog extends Dog {
    public GuardDog(String name, int age, String owner) {
        super(name, age, owner);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void makeSound(int count) {
        if (count < 0) {
            count = 1;
        }
        for (int i = 0; i <= count; i++) {
            System.out.println("Hav-Hav");
        }
    }
}
