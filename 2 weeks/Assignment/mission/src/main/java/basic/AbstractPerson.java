package basic;

public abstract class AbstractPerson implements Person{
    private String name;
    private String job;
    private int age;

    public AbstractPerson(String name, String job, int age) {
        this.name = name;
        this.job = job;
        this.age = age;
    }

    @Override
    public void speak() {
        System.out.println(String.format("Hi, my name is %s", this.name));
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AbstractPerson{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", age=" + age +
                '}';
    }
}
