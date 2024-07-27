package Top100;

public class Problem91 {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        int l = 1;
        int r = 0;
        int num1 = Character.getNumericValue(s.charAt(0));
        int num2 = Character.getNumericValue(s.charAt(1));
        if (num2 == 0) {
            if (num1 == 1 || num1 == 2) r = 1;
            else return 0;
        } else {
            if (num1 == 1 || (num1 == 2 && num2 <= 6)) r = 2;
            else r = 1;
        }
        for (int i = 2; i < s.length(); i++) {
            int num = Integer.valueOf(s.substring(i - 1, i + 1)).intValue();
            if (num <= 9 || num >= 27) {
                if (s.charAt(i) == '0') return 0;
                else {
                    l = r;
                }
            } else {
                if (s.charAt(i) == '0') {
                    int temp = r;
                    r = l;
                    l = temp;
                } else {
                    int temp = r;
                    r = l + r;
                    l = temp;
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Problem91 p = new Problem91();
        System.out.println(p.numDecodings("10011"));
    }
}
