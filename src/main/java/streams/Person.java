package streams;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable {

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private int age;
    private String name;
    private double salary;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String sex;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Double.compare(person.salary, salary) == 0 && Objects.equals(name, person.name) && Objects.equals(sex, person.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, salary, sex);
    }

    @Override
    public int compareTo(Object o1) {
        Person p = (Person) o1;

        if(p.getAge() == getAge()){
            return 0;
        }else if (p.getAge() > getAge()) {
            return 1;
        }else{
            return -1;
        }
    }
}
