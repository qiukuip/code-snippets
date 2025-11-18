public class Solution14 {
    public static String longestCommonPrefix(String[] strs) {
        String commonPrefix = "";
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() == 0) {
                return "";
            }
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }

        while (true) {
            boolean allPassFlag = true;
            for (String str : strs) {
                if (!str.startsWith(commonPrefix)) {
                    allPassFlag = false;
                    break;
                }
            }

            if (!allPassFlag) {
                return commonPrefix.substring(0, commonPrefix.length() - 1);
            } else {
                int length = commonPrefix.length();
                if (length >= minLength) {
                    return commonPrefix;
                }

                commonPrefix = commonPrefix + strs[0].charAt(length);
            }
        }
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"", "", ""};
        // String[] strs = new String[]{""};
        System.out.println(longestCommonPrefix(strs));
    }
}
