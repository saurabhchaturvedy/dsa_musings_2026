package Atlassian.Karat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisit {


    public static List<String> subdomainCount(String[] cpDomains) {

        Map<String, Integer> map = new HashMap<>();

        for (String dom : cpDomains) {


            String[] cpdomain = dom.split(" ");
            int visitCount = Integer.parseInt(cpdomain[0]);
            String domain = cpdomain[1];
            int length = domain.length();

            if (map.containsKey(domain)) {


                map.put(domain, map.get(domain) + visitCount);
            } else {

                map.put(domain, visitCount);
            }


            for (int i = 0; i < length; i++) {

                if (domain.charAt(i) == '.') {

                    String temp = domain.substring(i + 1, length);

                    if (map.containsKey(temp)) {

                        map.put(temp, map.get(temp) + visitCount);
                    } else {

                        map.put(temp, visitCount);
                    }
                }
            }
        }


        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            String name = entry.getKey();
            Integer count = entry.getValue();
            result.add(name + " " + count);

        }

        return result;
    }


    public static void main(String[] args) {


        String[] input = {"9001 discuss.leetcode.com"};
        System.out.println(subdomainCount(input));
    }
}
