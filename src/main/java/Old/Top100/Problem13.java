package Top100;

public class Problem13 {
    public int romanToInt(String s) {
        // deep analysis the principle of the math
        //
        int res = 0;
        int[] temp = new int[]{1, 5, 10, 50, 100, 500, 1000};

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'I') {
                res += temp[0];
            } else if (s.charAt(i) == 'V') {
                res += temp[1];
                temp = new int[]{-1, 5, 10, 50, 100, 500, 1000};
            } else if (s.charAt(i) == 'X') {
                res += temp[2];
                temp = new int[]{-1, -5, 10, 50, 100, 500, 1000};
            } else if (s.charAt(i) == 'L') {
                res += temp[3];
                temp = new int[]{-1, -5, -10, 50, 100, 500, 1000};

            } else if (s.charAt(i) == 'C') {
                res += temp[4];
                temp = new int[]{-1, -5, -10, -50, 100, 500, 1000};

            } else if (s.charAt(i) == 'D') {
                res += temp[5];
                temp = new int[]{-1, -5, -10, -50, -100, 500, 1000};

            } else if (s.charAt(i) == 'M') {
                res += temp[6];
                temp = new int[]{-1, -5, -10, -50, -100, -500, 1000};

            }
        }
        return res;
    }
}
