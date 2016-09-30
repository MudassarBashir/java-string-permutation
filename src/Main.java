import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        printPermutationsOf("ABC");
    }

    private static void printPermutationsOf(String str) {

        List<String> results = permutations(str);
        System.out.println("Number of permutations: " + results.size()
                            + "\n" + "Permutations: \n" + results);
    }

    private static List<String> permutations(String input) {
        if (input.length() == 0 || input.length() == 1) {
            return Collections.singletonList(input);
        }
        List<String> permutationsList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            String prefix = String.valueOf(input.charAt(i));
            String substring = new StringBuilder(input).deleteCharAt(i).toString();
            for (String str : permutations(substring)) {
                permutationsList.add(prefix + str);
            }
        }
        return permutationsList;
    }
}
