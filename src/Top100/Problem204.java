package Top100;

public class Problem204 {
    public int countPrimes(int n) {
        if(n == 0||n == 1||n==2) return 0;
        if(n == 3) return 1;
        if(n == 4||n==5) return 2;
        if(n == 6) return 3;
        int c = 3;
        for (int i = 6; i < n; i++) {
            if(helper(i)) c++;
        }
        return c;
    }
    public boolean helper(int n){
        for (int i = 2; i <Math.ceil(Math.sqrt(n)); i++) {
            if(n%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem204 p = new Problem204();
        System.out.println(p.countPrimes(10));
    }
}
