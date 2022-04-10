package Top100;

public class Problem28 {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == needle.length()){
            boolean flag = true;
            for (int i = 0; i < needle.length(); i++) {
                if(needle.charAt(i) != haystack.charAt(i)){
                    flag = false;
                }
            }
            if(flag) return 0;

        }
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < needle.length(); j++) {
                if(needle.charAt(j) != haystack.charAt(i+j)){
                    flag = false;
                }
            }
            if(flag) return i;
        }
        return -1;
    }
}
