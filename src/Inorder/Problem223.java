package Inorder;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class Problem223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int[] a1 = new int[]{ax1, ay1};
        int[] a2 = new int[]{ax2, ay2};
        int[] a3 = new int[]{ax1, ay2};
        int[] a4 = new int[]{ax2, ay1};
        int[] b1 = new int[]{bx1, by1};
        int[] b2 = new int[]{bx2, by2};
        int[] b3 = new int[]{bx1, by2};
        int[] b4 = new int[]{bx2, by1};
        List<int[]> a_list = new ArrayList<>();
        a_list.add(a1);
        a_list.add(a2);
        a_list.add(a3);
        a_list.add(a4);
        List<int[]> b_list = new ArrayList<>();
        b_list.add(b1);
        b_list.add(b2);
        b_list.add(b3);
        b_list.add(b4);
        return 1;
    }

}
