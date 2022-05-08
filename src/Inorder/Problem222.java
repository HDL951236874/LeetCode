package Inorder;

public class Problem222 {
    public int countNodes(TreeNode root) {
        int[] res = new int[]{0};
        int[] deep = new int[]{Integer.MIN_VALUE};
        int c = 1;
        Boolean f = false;
        helper(root, res, deep,c,f);
        return (int) Math.pow(2,deep[0])-1-res[0];
    }

    public void helper(TreeNode root, int[] res, int[] deep, int c,Boolean f) {
        if (c >= deep[0] && root == null) {
            res[0] += 1;
            deep[0] = c;
            return;
        }
        if(c == deep[0] &&root!=null){
            f = true;
            return;
        }
        helper(root.right, res, deep, c + 1,f);
        if(f) return;
        helper(root.left, res, deep, c + 1,f);
    }

    public static void main(String[] args) {
        Problem222 problem222 = new Problem222();
        TreeNode l = new TreeNode(1);
        l.left = new TreeNode(2);
        l.right = new TreeNode(3);
        l.left.left = new TreeNode(4);
        l.left.right = new TreeNode(5);
        l.right.left = new TreeNode(6);
        System.out.println(problem222.countNodes(l));
    }
}
