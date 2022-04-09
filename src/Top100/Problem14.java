package Top100;

public class Problem14 {
    public String longestCommonPrefix(String[] strs) {
        //divide and conquer is another good way to do the work
        int min_len = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min_len) {
                min_len = strs[i].length();
            }
        }
        if(min_len == 0) return "";
        String res = "";

        for (int i = 0; i < min_len; i++) {
            char temp = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != temp) {
                    return res;
                }
            }
            res += temp;
        }
        return res;
    }
}
