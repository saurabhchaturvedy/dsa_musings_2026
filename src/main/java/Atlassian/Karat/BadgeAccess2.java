package Atlassian.Karat;

import java.util.*;

public class BadgeAccess2 {


    public static void badgeAccess(List<Object[]> records) {

        Map<String, List<Integer>> empBadgeTimesMap = new HashMap<>();

        for (Object[] record : records) {

            String name = String.valueOf(record[0]);
            int time = (int)(record[1]);

            empBadgeTimesMap.computeIfAbsent(name, k -> new ArrayList<>()).add(toMinutes(time));

        }


        for (String name : empBadgeTimesMap.keySet()) {

            List<Integer> times = empBadgeTimesMap.get(name);
            Collections.sort(times);

            for (int i = 0; i + 2 < times.size(); i++) {

                if (times.get(i + 2) - times.get(i) <= 60) {

                    System.out.print(" name : " + name);

                    for (int j = i; j < times.size() && times.get(j) - times.get(i) <= 60; j++) {

                        System.out.print(fromMinutes(times.get(j)) + " ");
                    }
                    System.out.println();
                    break;
                }
            }

        }
    }


    public static int toMinutes(int time) {

        int hour = time / 100;
        int min = time % 100;

        return hour * 60 + min;
    }

    public static int fromMinutes(int minutes) {

        int hour = minutes / 60;
        int min = minutes % 60;

        return hour * 100 + min;

    }


    public static void main(String[] args) {




        List<Object[]> badgeRecords = Arrays.asList(
                new Object[]{"Paul", 1355},
                new Object[]{"Jennifer", 1910},
                new Object[]{"John", 830},
                new Object[]{"Paul", 1315},
                new Object[]{"John", 835},
                new Object[]{"Paul", 1405},
                new Object[]{"Paul", 1630},
                new Object[]{"John", 855},
                new Object[]{"John", 915},
                new Object[]{"John", 930},
                new Object[]{"Jennifer", 1335},
                new Object[]{"Jennifer", 730},
                new Object[]{"John", 1630}
        );

        badgeAccess(badgeRecords);

    }
}
