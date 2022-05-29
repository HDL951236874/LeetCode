package Top100;

public class Problem134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] minus = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            minus[i] = gas[i]- cost[i];
        }
        boolean flag = true;
        for (int i = 0; i < minus.length; i++) {
            if(minus[i]>=0 && flag == true){
                if(check(minus,i)){
                    return i;
                }else {
                    flag = false;
                }
            }
            if(minus[i]<0) {
                flag = true;
            }
        }
        return -1;
    }
    public boolean check(int[] minus, int index){
        int sum = 0;
        for (int i = 0; i < minus.length; i++) {
            if(index+i<minus.length){
                sum += minus[index+i];
            }else {
                sum += minus[index+i-minus.length];
            }
            if(sum<0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem134 p = new Problem134();
        System.out.println(p.canCompleteCircuit(new int[]{2}, new int[]{2}));
    }
}
