package Inorder;

public class Problem71 {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder(path);
        if(sb.charAt(0)!='/'){
            sb.insert(0,'/');
        }
        if(sb.charAt(sb.length()-1)=='/'){
            sb.delete(sb.length()-1,sb.length());
        }
        return "";
    }
}
