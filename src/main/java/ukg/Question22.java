package ukg;

public class Question22 {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z]", "");
        s = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Question22 q = new Question22();
        System.out.println(q.isPalindrome("abcd.11.."));
    }
}
