package Contest;

import java.util.ArrayList;
import java.util.List;

public class contest6079 {
    public String discountPrices(String sentence, int discount) {
        String[] split_sentence = sentence.split(" ");
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < split_sentence.length; i++) {
            if (split_sentence[i].charAt(0) == '$' && split_sentence[i].length() > 1) {
                boolean right = true;
                for (int j = 1; j < split_sentence[i].length(); j++) {
                    if (!Character.isDigit(split_sentence[i].charAt(j)) && split_sentence[i].charAt(j) != '.') {
                        right = false;
                        break;
                    }
                }
                if (right) {
                    double temp1 = Long.parseLong(split_sentence[i].substring(1, split_sentence[i].length())) / 100.0;

                    double res = temp1 * discount;
                    ;
                    String insertion = '$' + String.valueOf(res);
                    if (insertion.contains(".")) {
                        int dotIndex = insertion.indexOf('.');
                        int aimLength = dotIndex + 3;
                        while (insertion.length() != aimLength) {
                            if (insertion.length() < aimLength) {
                                insertion += "0";
                            } else {
                                insertion = insertion.substring(0, insertion.length() - 1);
                            }
                        }
                    }
                    temp.add(insertion);
                } else {
                    temp.add(split_sentence[i]);
                    continue;

                }
            } else {
                temp.add(split_sentence[i]);
            }
        }

        String res = String.join(" ", temp);
        return res;
    }

    public static void main(String[] args) {
        contest6079 contest6079 = new contest6079();
        System.out.println(contest6079.discountPrices("706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6",
                28));
//        double x = Double.parseDouble("7651913186");
//        System.out.println(1);
    }
}
