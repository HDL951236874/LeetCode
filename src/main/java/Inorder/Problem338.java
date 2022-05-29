package Inorder;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MatchGenerator;

import java.util.ArrayList;
import java.util.List;

public class Problem338 {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        for (int i = 1, f = 0; i <= n; i++) {
            if (i == Math.pow(2, f)) f++;
            res[i] = res[i- (int) Math.pow(2,f-1)]+1;
        }
        return res;
    }
}
