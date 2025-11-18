public class Solution6 {
    public static String convert2Arr(String s, int rowNum) {
        if (s.length() == 1 || rowNum == 1) {
            return s;
        }

        int length = s.length();
        char[] charArray = s.toCharArray();

        int countPerRound = 2 * rowNum - 2;
        int colPerRound = rowNum - 1;
        int round = (int) Math.ceil((double) length / countPerRound);

        int arrLength = round * colPerRound;

        char[][] arr = new char[rowNum][arrLength];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < arrLength; j++) {
                arr[i][j] = '0';
            }
        }
        int ps = 0;
        for (int r = 1; r <= round; r++) {
            int p1 = (r - 1) * colPerRound;
            int p2 = 0;
            while (p2 < rowNum && ps < length) {
                arr[p2][p1] = charArray[ps];
                p2++;
                ps++;
            }

            int m = rowNum - 2;
            int n = p1 + 1;
            while (m > 0 && ps < length) {
                arr[m][n] = charArray[ps];
                m--;
                n++;
                ps++;
            }
        }

        return print(arr);
    }

    private static String print(char[][] arr) {
        int length1 = arr.length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length1; i++) {
            int length2 = arr[i].length;
            for (int j = 0; j < length2; j++) {
                if (arr[i][j] != '0') {
                    stringBuilder.append(arr[i][j]);
                }
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "ABC";
        int rowNum = 2;
        System.out.println(convert2Arr(s, rowNum));
    }
}