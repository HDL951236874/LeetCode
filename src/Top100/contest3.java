package Top100;

import java.util.ArrayList;
import java.util.List;

public class contest3 {
    public int countTexts(String pressedKeys) {
        int l = 0;
        int r = 0;
        int ans = 1;
        while (r < pressedKeys.length()) {
            if (pressedKeys.charAt(r) != pressedKeys.charAt(l)||r==pressedKeys.length()-1) {
                ans *= backtrack(r - l);
                l = r-1;
            }
            r++;
        }
        return ans;
    }

    public int backtrack(int n) {
        if (n == 0) return 1;
        int res = 0;
        for (int i = 1; i <= Math.min(n, 4); i++) {
            res += backtrack(n - i);
        }
        return res;
    }

    public static void main(String[] args) {
        contest3 contest3 = new contest3();

        System.out.println(contest3.countTexts("22233"));
    }

}
