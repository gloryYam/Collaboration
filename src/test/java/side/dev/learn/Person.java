package side.dev.learn;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        Person person = new Person("김영광", 27);
        printName(person);
    }

    public static void printName(Person person) {
        String name = person != null && person.name != null ? person.name : "person에 값이 없음";
        System.out.println(name);
    }
}
