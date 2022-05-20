package Inorder;

public class Problem331 {
    public boolean isValidSerialization(String preorder) {
        if (preorder.charAt(0) == '#') {
            if(preorder.length() == 1) return true;
            else return false;
        }
        int slot = 1;
        String[] list = preorder.split(",");
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals("#")) slot--;
            else slot++;
            if (slot < 0) return false;
            if(slot == 0&& i!=list.length-1) return false;
        }

        return slot == 0;
    }

    public static void main(String[] args) {
        Problem331 problem331 = new Problem331();
        System.out.println(problem331.isValidSerialization("7,2,#,2,#,#,#,6,#"));
    }
}
