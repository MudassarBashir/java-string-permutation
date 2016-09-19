import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        permutateString("ABC");
    }

    private static void permutateString(String str) {

        List<String> results = permutations(new StringBuilder(str), new ArrayList<>());
        System.out.println("Number of permutations: " + results.size()
                            + "\n" + "Permutations: \n" + results);
    }

    private static List<String> permutations(StringBuilder input, List<String> permutationsList) {

        if (input.length() == 0 || input.length() == 1) {
            permutationsList.add(input.toString());
        }
        else {
            char prefix;
            StringBuilder substring;

            for (int i=0; i<input.length(); i++) {
                prefix = input.charAt(i);
                substring = new StringBuilder(input).deleteCharAt(i);
                for (String str : permutations(substring, new ArrayList<>())) {
                    permutationsList.add(String.valueOf(prefix) + str);
                }
            }
        }
        return permutationsList;
    }
}
