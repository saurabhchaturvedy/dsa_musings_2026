package Atlassian.Karat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WrapLines1 {




    public static List<String> wrapLines1(List<String> words, int maxLineLength)
    {

        List<String> result = new ArrayList<>();

        if(words.isEmpty()) return result;

        StringBuilder currentLine = new StringBuilder();

        for(String word : words)
        {

            if(currentLine.isEmpty())
            {

                currentLine.append(word);
            }
            else if(currentLine.length()+1+word.length()<=maxLineLength)
            {

                currentLine.append("-").append(word);
            }
            else {

                result.add(currentLine.toString());
                currentLine.setLength(0);
                currentLine.append(word);
            }
        }

        if(!currentLine.isEmpty())
        {

            result.add(currentLine.toString());
        }

        return result;
    }


    public static void main(String[] args) {



        List<String> words1 = Arrays.asList(
                "The", "day", "began", "as", "still", "as", "the",
                "night", "abruptly", "lighted", "with", "brilliant", "flame"
        );

        System.out.println("wrapLines(words1, 13) =>");
        System.out.println(wrapLines1(words1, 13));



    }
}
