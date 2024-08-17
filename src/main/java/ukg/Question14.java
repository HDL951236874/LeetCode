package ukg;

public class Question14 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int current = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            current += gas[i] - cost[i];
            if(current<0){
                current = 0;
                res = i+1;
            }
        }
        return total<0 ? -1 : res;
    }

    public static void main(String[] args) {
        Question14 q = new Question14();
        System.out.println(q.canCompleteCircuit(new int[]{0,0,0,0,0},new int[]{0,0,0,0,0}));
    }
}
