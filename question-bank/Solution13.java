import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution13 {
    public static int romanToInt(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int sum = 0;
        Map<String, Integer> map1 = map1();
        Map<String, Integer> map2 = map2();
        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                String prefix = new String(charArray, i, 2);
                if (map2.containsKey(prefix)) {
                    sum += map2.get(prefix);
                    i += 1;
                } else {
                    prefix = new String(charArray, i, 1);
                    sum += map1.get(prefix);
                }
            } else {
                String prefix = new String(charArray, i, 1);
                sum += map1.get(prefix);
            }
        }

        return sum;
    }

    private static Map<String, Integer> map1() {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        return map;
    }

    private static Map<String, Integer> map2() {
        Map<String, Integer> map = new HashMap<>();
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        return map;
    }

    public static void main(String[] args) {
        List<String> list = List.of("III", "IV", "IX", "LVIII", "MCMXCIV");
        for (String s : list) {
            System.out.println(romanToInt(s));
        }
    }
}
