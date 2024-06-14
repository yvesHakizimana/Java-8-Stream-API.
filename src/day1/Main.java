package day1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args){
        String[] words= {"apple", "banana", "apple", "orange", "banana", "apple"};
        List<String> list = Arrays.asList("apple", "banana", "orange", "kiwi", "strawberry");

        countOccurrence(words);
        returnLongestWord(list);
        returnLongestWordSecondWay(list);
        removeDuplicates();
        summarize();
        mergeTwoLists();
        concatenateStrings();
        firstNonRepeatingChar();
        removeStringsWithSpecificChar();
        partitionList();
        getKthLargestElement();
        cubeElements();
        countStringsWithSpecificCriteria();
        longestPalindromeString();
        nonNegativeIntegers();
    }

    public static void countOccurrence(String[] words){
        var output = stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(output);
    }
    public static void returnLongestWord(List<String> words){
         words
                .stream()
                .reduce((str1, str2) -> str1.length() > str2.length() ? str1 : str2)
                 .ifPresent(System.out::println);
    }
    //Alternative way
    public static void returnLongestWordSecondWay(List<String> words){
        words
                .stream()
                .max(Comparator.comparing(String::length))
                .ifPresent(System.out::println);
    }
    public static void removeDuplicates(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 1);
        numbers
                .stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
    public static void summarize(){
        List<Double> doubles = Arrays.asList(1.2, 3.5, 2.8, 4.1, 5.7);
        OptionalDouble avaerage = doubles
                .stream()
                        .mapToDouble(Double::doubleValue)
                                .average();
        System.out.println(avaerage);

    }
    public static void mergeTwoLists(){
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4, 5);

        List<Integer> integerList  = Stream.concat(list1.stream(), list2.stream()).distinct().toList();
        System.out.println(integerList);
    }
    public static void concatenateStrings(){
        List<String> list = Arrays.asList("Hello", " ", "world", "!");
        String str = list.stream().collect(Collectors.joining());
        System.out.println(str);
    }
    public static void firstNonRepeatingChar(){
        String str = "abacdbef";
        str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(c -> c.getValue() == 1)
                .findFirst()
                .ifPresent(System.out::println);

    }
    public static void removeStringsWithSpecificChar(){
        List<String> list = Arrays.asList("apple", "banana", "orange", "kiwi");
        char specificChar = 'a';
        list
                .stream()
                .filter(s -> !s.contains(String.valueOf(specificChar)))
                .forEach(System.out::println);
    }
    public static void partitionList(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> output = numbers
                .stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(output);
    }
    public static void getKthLargestElement(){
        List<Integer> list = Arrays.asList(1, 12, 44, 32, 52, 81, 59, 84, 72, 37);
        int k = 4;
        list
                .stream()
                .sorted(Comparator.reverseOrder())
                .skip(k-1)
                .findFirst()
                .ifPresent(System.out::println);
    }
    public static void cubeElements(){
        List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);
        integerList
                .stream()
                .map(nbr -> Math.pow(nbr, 3))
                .filter(n -> n > 50)
                .forEach(System.out::println);
    }
    public static void countStringsWithSpecificCriteria(){
        List<String> list = Arrays.asList("apple", "banana", "orange", "kiwi", "strawberry");
        long count = list
                .stream()
                .filter(str -> "aieouAIEOU".contains(String.valueOf(str.charAt(0)))).count();
        System.out.println(count);
    }
    public static void longestPalindromeString(){
        List<String> list = List.of("level", "hello", "radar", "world", "madam", "java", "Malayalam");
        list
                .stream()
                .filter(str -> new StringBuilder(str).reverse().toString().equalsIgnoreCase(str))
                .max(Comparator.comparing(String::length))
                .ifPresent(System.out::println);
    }
    public static void nonNegativeIntegers(){
        List<Integer> integerList = Arrays.asList(4, 5, -6, 7, -1, 2, -3);
        integerList
                .stream()
                .filter(n -> n > 0)
                .forEach(System.out::println);
    }
}
