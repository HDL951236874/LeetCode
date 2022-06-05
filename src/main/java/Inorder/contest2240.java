package Inorder;

public class contest2240 {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (cost1 > cost2) {
            int temp = cost1;
            cost1 = cost2;
            cost2 = temp;
        }
        int max = total / cost2;
        long res = 0;
        for (int i = 0; i <= max; i++) {
            res += (total- cost2*i)/cost1+1 ;
        }
        return res;
    }
}
