package basic;

public class Lecturer extends AbstractPerson {

    public Lecturer(String name, String job, int age) {
        super(name, job, age);
    }

    @Override
    public void speak() {
        System.out.println(String.format("My name is %s, and I am a Lecturer.", getName()));
    }
}
