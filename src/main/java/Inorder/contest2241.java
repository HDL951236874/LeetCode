package Inorder;

public class contest2241 {
    class ATM {
        int[] depo = new int[]{0, 0, 0, 0, 0};
        int[] depo_ = new int[]{20, 50, 100, 200, 500};

        public ATM() {

        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < banknotesCount.length; i++) {
                this.depo[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int[] res = new int[5];
            for (int i = 4; i >= 0; i--) {
                if (amount % this.depo_[i] == 0 && this.depo[i] >= amount / this.depo_[i]) {
                    res[i] = amount / this.depo_[i];
                    for (int j = 0; j < res.length; j++) {
                        this.depo[j] -= res[j];
                    }
                    return res;
                } else {
                    int num = Math.min(this.depo[i], amount / this.depo_[i]);
                    res [i] = num;
                    amount = amount - num * this.depo_[i];
                }
            }
            return new int[]{-1};
        }
    }

    public static void main(String[] args) {
        contest2241.ATM atm = new contest2241().new ATM();
        //[0,0,1,2,1]],[600],[[0,1,0,1,1]],[600],[550]]
        atm.deposit(new int[]{0,0,1,2,1});
        atm.withdraw(600);
        atm.deposit(new int[]{0,1,0,1,1});
        atm.withdraw(600);
        atm.withdraw(550);
    }
}
