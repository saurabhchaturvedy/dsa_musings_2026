package Atlassian.Karat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BadgeAccess {




    public static void badgeAccess(List<String[]> badgeRecords)
    {

        Set<String> inside = new HashSet<>();
        Set<String> enterWithoutExit = new HashSet<>();
        Set<String> exitWithoutEnter = new HashSet<>();

        for(String[] badgeRecord : badgeRecords)
        {

            String name = badgeRecord[0];
            String action = badgeRecord[1];

            if(action.equals("enter"))
            {

                if(inside.contains(name))
                {

                    enterWithoutExit.add(name);
                }

                inside.add(name);
            }
            else {

                if(!inside.contains(name))
                {

                    exitWithoutEnter.add(name);
                }
                else {

                    inside.remove(name);
                }
            }
        }

        enterWithoutExit.addAll(inside);

        System.out.println(" enter without exit :"+enterWithoutExit);
        System.out.println(" exit without enter :"+exitWithoutEnter);

    }


    public static void main(String[] args) {




        List<String[]> badgeRecords = Arrays.asList(
                new String[]{"Martha", "exit"},
                new String[]{"Paul", "enter"},
                new String[]{"Martha", "enter"},
                new String[]{"Martha", "exit"},
                new String[]{"Jennifer", "enter"},
                new String[]{"Paul", "enter"},
                new String[]{"Curtis", "enter"},
                new String[]{"Paul", "exit"},
                new String[]{"Martha", "enter"},
                new String[]{"Martha", "exit"},
                new String[]{"Jennifer", "exit"}
        );

        badgeAccess(badgeRecords);

    }
}
