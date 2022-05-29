package Inorder;

import java.util.HashMap;
import java.util.Map;

public class Problme292 {
    Map<Integer, Boolean> map = new HashMap<>();

    public boolean canWinNim(int n) {
        if (n == 1 || n == 2 || n == 3) return true;
        if (map.containsKey(n)) map.get(n);
        Boolean b = !canWinNim(n - 1) || !canWinNim(n - 2) || !canWinNim(n - 3);
        map.put(n, b);
        return b;
    }
}
