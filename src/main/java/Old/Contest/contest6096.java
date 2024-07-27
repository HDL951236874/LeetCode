package Old.Contest;

import java.util.Arrays;

public class contest6096 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            long least = success % spells[i] == 0 ? success / spells[i] : success / spells[i] + 1;
            res[i] = potions.length - find(potions,least);
        }
        return res;
    }

    public int find(int[] potions, long aim) {
        if(potions[0]>= aim) return 0;
        if(potions[potions.length-1]<aim) return potions.length;
        int l = 0;
        int r = potions.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (potions[mid] >= aim && potions[mid -1] < aim) {
                return mid;
            } else if (potions[mid] < aim) {
                l = mid + 1;
            } else if (potions[mid]>=aim && potions[mid-1]>=aim) {
                r = mid - 1;
            }
        }
        return -1;
    }
}
