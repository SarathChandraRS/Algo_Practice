package streams;

import java.text.CollationElementIterator;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SimpleStream {

    public static void main(String args[]){
        /*List<Integer> input = new LinkedList<>();
        for(int i=0;i<10;i++){
            input.add(i);
        }
        List<Integer> integerList = findEven(input);
        integerList.forEach(System.out::println);*/
        compareTwoLists();

    }

    public static List<Integer> findEven(List<Integer> list){
       List<Integer> integerList =  list.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
       return integerList;
    }

    public static void startWithK(){
        List<Integer> input = Arrays.asList(10,12,2,3,12,14,13,11);
        String k = "1";
        Set<Integer> resultSet = input.stream().map(s -> s + "").filter(i -> i.startsWith(k)).map(s -> Integer.valueOf(s)).collect(Collectors.toSet());
        resultSet.forEach(System.out::println);
    }

    public static void findDuplicate(){
        List<Integer> input = Arrays.asList(10,12,2,3,12,14,13,11,3,4);
        Set<Integer> set = new HashSet<>();
        //Using below HashSet only for trying a new way. No particular reason
        Set<Integer> resultSet = input.stream().filter(i -> set.add(i)).collect(Collectors.toCollection(HashSet::new));
        resultSet.forEach(System.out::println);
    }

    public static void findTotalElements(){
        int[] input = {10,12,2,3,12,14,17,23,11,3,4};
        System.out.println(Arrays.stream(input).count());

    }
    public static void findMax(){
        List<Integer> input = Arrays.asList(10,12,2,3,12,14,13,11,23,4);
        System.out.println(input.stream().max(Integer::compare).get());
        int[] inputArr = {10,12,2,3,12,14,17,23,11,3,4};
        Arrays.stream(inputArr).sorted().mapToObj(i->i).collect(Collectors.toList());

        Optional<Integer> val = input.stream().filter(i ->i%2==0).distinct().reduce(((x, i) -> x+i));
        if(val.isPresent()){
            System.out.println(val.get());
        }

    }

    public static void findFirstRepeatedCharacter(){
        String input = "Hello my name is sarath chandra";
        Optional<Character>result = input.chars().mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i))).
                collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new ,Collectors.counting())).
                        entrySet().stream().filter(i -> i.getValue() > 1).map(e -> e.getKey()).findFirst();

        if(result.isPresent()){
            System.out.println(result.get());
        }
    }

    public static void sortArray(){
        List<Integer> input = Arrays.asList(5,6,7,2,3,1,4,7);
        input.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    //compare two lists
    public static void compareTwoLists(){
        List<Integer> listOne = Arrays.asList(1,3,5,7,9);
        List<Integer> listTwo = Arrays.asList(2,4,6,8,9,7,5);
        System.out.println(listTwo.stream().filter(i -> listOne.contains(i)).reduce((x,i) -> x*i).get());
    }

    //consumer --> takes input no outpur -- forEach() takes consumer
    //Predicate --> takes input and returns boolean --> used in filter() method of streams
    //Function --> takes input and returns the same type input --> used in map function
    //Supplier --> takes no input but returns the output. You can call get method on Supplier object it will execute the function(lambda) and returns value
                // Supplier is used for lazy loading where you define function but won't execute until you need it with get function


}
