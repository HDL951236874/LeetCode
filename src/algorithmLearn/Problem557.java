package algorithmLearn;

public class Problem557 {
    public String reverseWords(String s) {
        String res = "";
        String[] newStr = s.split("\\s+");
        for (int i = 0; i < newStr.length; i++) {
            res+= reverse(newStr[i]);
            if(i != newStr.length-1){
                res += " ";
            }
        }
        return res;
    }

    public String reverse(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[]  str = s.toCharArray();
        while (l < r) {
            char temp = str[l];
            str[l] = str[r];
            str[r] = temp;
            l++;
            r--;
        }
        String res = String.copyValueOf(str);
        return res;
    }

}
