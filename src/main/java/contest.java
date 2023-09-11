
import java.util.HashMap;
import java.util.Map;

public class contest {
    public String largestGoodInteger(String num) {
        int max = -1;
        for (int i = 0; i < num.length() -2; i++) {
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i+1) == num.charAt(i+2)){
                if(Integer.valueOf(String.valueOf(num.charAt(i)))>max){
                    max = Integer.valueOf(String.valueOf(num.charAt(i)));
                }
            }
        }
        String res = "";
        for (int i = 0; i < 3; i++) {
            res += String.valueOf(max);
        }
        return max == -1?"":res;
    }

    public static void main(String[] args) {
        contest contest = new contest();
        System.out.println(contest.largestGoodInteger("2300019"));
    }
}
