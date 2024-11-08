package practicals;
class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sound() {
        System.out.println("The animal makes a sound.");
    }
}
class Dog extends Animal {


    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void sound() {
        System.out.println("The dog barks: Bhau!");
    }
}
class Cat extends Animal {


    public Cat(String name, int age) {
        super(name, age);
    }


    @Override
    public void sound() {
        System.out.println("The cat sounds: Meow!");
    }
}
public class AnimalTest {
    public static void main(String[] args) {
        // Creating Dog and Cat objects
        Animal dog = new Dog("simba", 3);
        Animal cat = new Cat("bella", 2);


        dog.sound();
        cat.sound();
    }
}

