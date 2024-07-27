package Old.ArrayList;

public class Problem66 {
    public int[] plusOne(int[] digits) {
        // this part is used to find the first digit which is not 9
        int nine_index = -1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                nine_index = i;
                break;
            }
        }
        if (nine_index != -1) {
            digits[nine_index]++;
            for (int i = nine_index + 1; i < digits.length; i++) {
                digits[i] = 0;
            }
            return digits;

        } else {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res[i] = 0;
            }
            return res;
        }
    }
}
