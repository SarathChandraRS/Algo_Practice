package streams;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static List<Person> getFemale(List<Person> people){
        List<Person> female = people.stream().filter(p -> p.getSex().equals("Female")).collect(Collectors.toList());
        female.forEach(p -> System.out.println(p.getName()));
        return female;
    }

    public static void sortByAge(List<Person> people){
        List<Person> female = people.stream().sorted().collect(Collectors.toList());
        female.forEach(p -> System.out.println(p.getName()));
    }

    public static void getAllWithName(List<Person> people, String s){
        people.stream().allMatch(p -> p.getName().startsWith(s));
    }

    public static void getMaxSalary(List<Person> people){
        people.stream().max(Comparator.comparing(Person::getSalary)).ifPresent( p -> System.out.println(p.getName()));
    }

    public static void main(String args[]){
        Person p1 = new Person();
        p1.setAge(23);
        p1.setName("sarath");
        Person p2 = new Person();
        p2.setAge(28);
        p2.setName("Ramu");

        Person p3 = new Person();
        p3.setAge(32);
        p3.setName("lakshman");
        List<Person> list = new ArrayList<Person>();
        list.add(p2);list.add(p3);
        list.add(p1);
        System.out.println(list);
        StreamTest.sortByAge(list);

    }

}


