package Old.Contest;

public class contest2255 {
    public int countPrefixes(String[] words, String s) {
        int c = 0;
        for (int i = 0; i < words.length; i++) {
            if(words[i].length()<=s.length()&&s.substring(0,words[i].length()).equals(words[i])){
                c++;
            }
        }
        return c;
    }

}
