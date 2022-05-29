package Inorder;

public class Problem67 {
    public String addBinary(String a, String b) {
        int long_length = Math.max(a.length(), b.length());
        int sum = 0;
        int count = 0;
        String res = "";
        for (int i = 0; i < long_length; i++) {
            int index_a = a.length() - 1 - i;
            int index_b = b.length() - 1 - i;
            sum = count;
            if (index_a >= 0 && a.charAt(index_a) == '1') {
                sum++;
            }
            if (index_b >= 0 && b.charAt(index_b) == '1') {
                sum++;
            }
            if (sum == 0) {
                res = "0" + res;
                count = 0;
            }
            if (sum == 1) {
                res = "1" + res;
                count = 0;
            }
            if (sum == 2) {
                res = "0" + res;
                count = 1;
            }
            if (sum == 3) {
                res = "1" + res;
                count = 1;
            }
        }
        return count==1?"1"+res:res;
    }

    public static void main(String[] args) {
        Problem67 p = new Problem67();
        System.out.println(p.addBinary("11", "1"));
    }
}
