package Inorder;

import java.util.ArrayList;
import java.util.List;

public class Problem293 {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < currentState.length()-1; i++) {
            if(currentState.charAt(i) == '+'&&currentState.charAt(i+1) == '+'){
                StringBuffer buffer = new StringBuffer(currentState);
                buffer.setCharAt(i,'-');
                buffer.setCharAt(i+1,'-');
                res.add(buffer.toString());
            }
        }
        return res;
    }
}
