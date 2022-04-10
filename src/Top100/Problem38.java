package Top100;

public class Problem38 {
    public String countAndSay(int n) {
        //reccrrsion is a good way to fix it
        if( n == 1) return "1";
        String s = countAndSay(n-1);
        int num = 1;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if(i == s.length()-1 || s.charAt(i+1) != s.charAt(i)){
                res += Integer.toString(num) + s.charAt(i);
                num = 1;
            }else {
                num++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem38 p = new Problem38();
        p.countAndSay(4);
    }
}
