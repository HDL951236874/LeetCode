package ukg;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Question19 {
    public String reverseWords(String s) {

        String[] strs = s.split("\\s+");
        List<String> collect = Arrays.stream(strs).filter(x-> !x.isEmpty()).collect(Collectors.toList());
        Collections.reverse(collect);
        return String.join(" ", collect);
    }

    public static void main(String[] args) {
        Question19 q = new Question19();
        q.reverseWords(" Hello World ");
    }
}
