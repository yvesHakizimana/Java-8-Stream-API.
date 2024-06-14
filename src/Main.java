
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        String characters = "FollowMilindMehta";
        List<Integer> numbers = List.of(5,8,2,13,42,56,24,36);
        var charCount = countCharacters(characters);
        System.out.println(findDuplicates(characters));
        findFirstUniqueCharacter(characters);
        System.out.println(findTheSecondLargestElement(numbers));
    }

    public static Map<Character, Long> countCharacters(String str){
        return str
                .chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static Map<Character, Long> findDuplicates(String str){
        return str
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    public static Character findFirstUniqueCharacter(String str){
         return str
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

    }

    public static Integer findTheSecondLargestElement(List<Integer> numbers){
        return numbers
                .stream().
                sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);

    }




}
