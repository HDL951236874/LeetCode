package Contest;

public class contest5299 {
    public int divisorSubstrings(int num, int k) {
        String nums = String.valueOf(num);
        int res = 0;
        for (int i = 0; i <= nums.length() - k; i++) {
            int sub_num = Integer.parseInt(nums.substring(i, i + k));
            if(sub_num == 0) continue;
            if(num%sub_num == 0) res+=1;
        }
        return res;
    }

    public static void main(String[] args) {
        contest5299 contest5299 = new contest5299();
        System.out.println(contest5299.divisorSubstrings(240,2));
    }
}
