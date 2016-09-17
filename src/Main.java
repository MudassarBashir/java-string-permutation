import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        permutateString("ABC");
    }

    private static void permutateString(String str) {

        List<String> results = permutations(str, new ArrayList<String>());
        System.out.println("Number of permutations: " + results.size()
                            + "\n" + "Permutations: \n" + results);
    }

    private static List<String> permutations(String input, List<String> permutationsList) {

        if (input.equals("") || input.length() == 1) {
            permutationsList.add(input);
        }
        else {
            char prefix;
            StringBuffer substring;

            for (int i=0; i<input.length(); i++) {
                prefix = input.charAt(i);
                substring = new StringBuffer(input).deleteCharAt(i);
                for (String str : permutations(substring.toString(), new ArrayList<String>())) {
                    permutationsList.add(String.valueOf(prefix) + str);
                }
            }
        }
        return permutationsList;
    }
}
