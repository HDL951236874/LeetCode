package ArrayList;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem68 {
    //this problem is not hard but complex, you have to pay attention to all the detail you can think. so if you encounter this prob in the interview, you have to show your mind to the officer and do the unit test.
    public List<String> fullJustify(String[] words, int maxWidth) {
        int accu = 0;
        int num = 0;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            accu += words[i].length();
            num++;
            if (accu + num - 1 > maxWidth) {
                //make the string
                if (num == 2) {
                    String str = "";
                    str += words[i - 1];
                    for (int m = str.length(); m < maxWidth; m++) {
                        str += " ";
                    }
                    res.add(str);
                } else {
                    int string_len = accu - words[i].length();
                    int left_len = maxWidth - string_len;
                    int yu = left_len % (num - 2);
                    int ge = left_len / (num - 2);
                    String str = "";
                    for (int n = i - num + 1; n < i; n++) {
                        str += words[n];
                        if (n == i - 1) {
                            break;
                        }
                        if (yu > 0) {
                            for (int m = 0; m < ge + 1; m++) {
                                str += " ";
                            }
                            yu--;
                        } else {
                            for (int m = 0; m < ge; m++) {
                                str += " ";
                            }
                        }
                    }
                    res.add(str);
                }
                num = 1;
                accu = words[i].length();

            }
            if (i == words.length - 1) {
                String str = "";
                for (int m = words.length - num; m < words.length; m++) {
                    str += words[m];
                    if (m != words.length - 1) {
                        str += " ";
                    }
                }
                for (int m = str.length(); m < maxWidth; m++) {
                    str += " ";
                }
                res.add(str);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Problem68 p = new Problem68();
        String[] in = new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        List<String> res = p.fullJustify(in, 20);
        System.out.println(1);
    }
}
