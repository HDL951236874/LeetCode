package Old.Contest;

public class contest2222 {
    public long numberOfWays(String s) {
        long number_01 = 0;
        long number_10 = 0;
        long number_0 = 0;
        long number_1 = 0;
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                number_1++;
                number_01 += number_0;
                res += number_10;
            }
            if (s.charAt(i) == '0') {
                number_0++;
                number_10 += number_1;
                res += number_01;
            }
        }
        return res;
    }
}
