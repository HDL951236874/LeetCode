package Contest;

public class contest6074 {
    public int percentageLetter(String s, char letter) {
        int sum  = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == letter) sum++;
        }
        return Math.round(100*sum/s.length());
    }

    public static void main(String[] args) {
        contest6074 contest6074 = new contest6074();
        System.out.println(contest6074.percentageLetter("111222333",'1'));
    }
}
