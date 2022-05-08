package Inorder;

public class Problen190 {
    public int reverseBits(int n) {
        StringBuffer binary_string = new StringBuffer(Integer.toBinaryString(n));
        while (binary_string.length()<32){
            binary_string.insert(0,"0");
        }
        int res = 0;
        for (int i = 0; i < binary_string.length(); i++) {
            if (binary_string.charAt(i) == '1') res += Math.pow(2, i);
        }
        return res;
    }
}
