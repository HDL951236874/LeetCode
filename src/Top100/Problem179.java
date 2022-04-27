package Top100;

public class Problem179 {
    public String largestNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int compare_res = compare(nums[i],nums[j]);
                if(compare_res<0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        if(nums[0] == 0){
            return "0";
        }
        String res = "";
        for (int i = 0; i < nums.length; i++) {
            res += String.valueOf(nums[i]);
        }
        int l = 0;
        return res;
    }

    public int compare(int a, int b) {
        String String_a = String.valueOf(a);
        String String_b = String.valueOf(b);
        String o1 = String_a+String_b;
        String o2 = String_b+String_a;
        return o1.compareTo(o2);
    }

    public static void main(String[] args) {
        Problem179 p = new Problem179();
        System.out.println(p.largestNumber(new int[]{31,2,1}));
    }
}
