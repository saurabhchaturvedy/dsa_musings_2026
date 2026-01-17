package Atlassian.Karat;

import java.util.*;

public class ReflowJustifySimple {

    public static List<String> reflowAndJustify(List<String> lines, int width) {
        List<String> words = getWords(lines);
        List<List<String>> wrappedLines = wrap(words, width);

        List<String> result = new ArrayList<>();
        for (List<String> line : wrappedLines) {
            result.add(justify(line, width));
        }
        return result;
    }

    // Step 1: Extract all words
    private static List<String> getWords(List<String> lines) {
        List<String> words = new ArrayList<>();
        for (String line : lines) {
            for (String word : line.split(" ")) {
                words.add(word);
            }
        }
        return words;
    }

    // Step 2: Wrap words greedily
    private static List<List<String>> wrap(List<String> words, int width) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        int length = 0;

        for (String word : words) {
            int newLength = length + word.length() + (current.isEmpty() ? 0 : 1);

            if (newLength <= width) {
                current.add(word);
                length = newLength;
            } else {
                result.add(current);
                current = new ArrayList<>();
                current.add(word);
                length = word.length();
            }
        }

        if (!current.isEmpty()) result.add(current);
        return result;
    }

    // Step 3: Justify one line
    private static String justify(List<String> words, int width) {

        // Single word → no padding
        if (words.size() == 1) {
            return words.get(0);
        }

        int wordLength = 0;
        for (String w : words) wordLength += w.length();

        int dashes = width - wordLength;
        int gaps = words.size() - 1;

        int eachGap = dashes / gaps;
        int extra = dashes % gaps;

        StringBuilder line = new StringBuilder();

        for (int i = 0; i < words.size(); i++) {
            line.append(words.get(i));

            if (i < gaps) {
                int dashCount = eachGap + (i < extra ? 1 : 0);
                line.append("-".repeat(dashCount));
            }
        }

        return line.toString();
    }

    // ---------------- TEST CASES ----------------
    public static void main(String[] args) {

        List<String> lines = Arrays.asList(
                "The day began as still as the",
                "night abruptly lighted with",
                "brilliant flame"
        );

        System.out.println(reflowAndJustify(lines, 24));
        System.out.println(reflowAndJustify(lines, 25));
        System.out.println(reflowAndJustify(lines, 26));
        System.out.println(reflowAndJustify(lines, 40));
        System.out.println(reflowAndJustify(lines, 14));
        System.out.println(reflowAndJustify(lines, 15));

        List<String> lines2 = Arrays.asList("a b", "c d");
        System.out.println(reflowAndJustify(lines2, 20));
        System.out.println(reflowAndJustify(lines2, 4));
        System.out.println(reflowAndJustify(lines2, 2));
    }
}
