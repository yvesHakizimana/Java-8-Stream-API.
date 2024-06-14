
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        String characters = "FollowMilindMehta";
        var charCount = countCharacters(characters);
        System.out.println(charCount);
    }

    public static Map<Character, Long> countCharacters(String str){
        return str
                .chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


}
