import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class OrginizeWordsByNoLetter {

    public static void main(String[] args) {

        List<String > names = List.of("Amir", "Hatef", "Mehran", "Mojtaba", "Mohammad", "Ali", "Davood", "Reza", "Mohsen");


        //classification by number letter of word
        Map<Integer,List<String>> result = names.stream()
                .collect(groupingBy(String::length));

        //classification word by number of letters and count quantity in each list
        Map<Integer,Long> result2 = names.stream()
                .collect(groupingBy(String::length,counting()));

        System.out.println(result);
        System.out.println(result2);

    }
}
