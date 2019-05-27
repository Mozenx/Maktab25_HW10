import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class OrginizeWordsByNoLetter {

    public static void main(String[] args) {

        List<String > names = List.of("Amir", "Hatef", "Mehran", "Mojtaba", "Mohammad", "Ali", "Davood", "Reza", "Mohsen");


        //classification word by number of letters
        Map<Integer,List<String>> result = names.stream()
                .collect(groupingBy(String::length));

        //classification word by number of letters and counting quantity word in each list
        Map<Integer,Long> result1 = names.stream()
                .collect(groupingBy(String::length,counting()));


        System.out.println("Classification word by number of letters:");
        System.out.println(result);
        System.out.println("\nClassification word by number of letters and counting quantity word in each list:");
        System.out.println(result1);

    }
}
