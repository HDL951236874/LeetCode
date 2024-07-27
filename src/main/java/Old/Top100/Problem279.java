package Top100;

public class Problem279 {
    public int numSquares(int n) {
        return backtrack(n, Integer.MAX_VALUE)-1;
    }

    public int backtrack(int n, int min) {
        int max_index = (int) Math.floor(Math.sqrt(n));
        for (int i = max_index; i >= 1; i--) {
            if ((int) (n - Math.pow(i, 2)) == 0) return 1;
            if (min > 0) {
                int step = backtrack((int) (n - Math.pow(i, 2)), min - 1);
                min = Math.min(step, min);
            }
        }
        return min+1;
    }

    public static void main(String[] args) {
        Problem279 p = new Problem279();
        System.out.println(p.numSquares(12));
    }
}
