package Top100;

import java.util.Arrays;

public class Problem150 {
    public int evalRPN(String[] tokens) {
        int now = 0;
        String[] token = new String[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            token[i] = tokens[i];
        }
        while (now < token.length) {

            if (token[now].equals("+")) {
                String[] sub_l = Arrays.copyOfRange(token,0,now-2);
                String[] sub_r = Arrays.copyOfRange(token,now+1,token.length);
                String mid = String.valueOf(Integer.valueOf(token[now-2])+Integer.valueOf(token[now-1]));
                token = concat(sub_l,sub_r,mid);
                now = now -2;
            }
            if (token[now].equals("-")) {
                String[] sub_l = Arrays.copyOfRange(token,0,now-2);
                String[] sub_r = Arrays.copyOfRange(token,now+1,token.length);
                String mid = String.valueOf(Integer.valueOf(token[now-2])-Integer.valueOf(token[now-1]));
                token = concat(sub_l,sub_r,mid);
                now = now -2;

            }
            if (token[now].equals("*")) {
                String[] sub_l = Arrays.copyOfRange(token,0,now-2);
                String[] sub_r = Arrays.copyOfRange(token,now+1,token.length);
                String mid = String.valueOf(Integer.valueOf(token[now-2])*Integer.valueOf(token[now-1]));
                token = concat(sub_l,sub_r,mid);
                now = now -2;

            }
            if (token[now].equals("/")) {
                String[] sub_l = Arrays.copyOfRange(token,0,now-2);
                String[] sub_r = Arrays.copyOfRange(token,now+1,token.length);
                String mid = String.valueOf(Integer.valueOf(token[now-2])/Integer.valueOf(token[now-1]));
                token = concat(sub_l,sub_r,mid);
                now = now -2;
            }

            now++;
        }
        return Integer.valueOf(token[0]);
    }
    public String[] concat(String[] a,String[] b,String c){
        String[] res = new String[a.length+b.length+1];
        System.arraycopy(a,0,res,0,a.length);
        res[a.length] = c;
        System.arraycopy(b,0,res,a.length+1,b.length);
        return res;
    }

    public static void main(String[] args) {
        Problem150 p = new Problem150();
        System.out.println(p.evalRPN(new String[]{"2","1","+","3","*"}));
    }
}
