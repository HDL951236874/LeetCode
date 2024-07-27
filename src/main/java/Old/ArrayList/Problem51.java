package Old.ArrayList;

import java.util.*;

public class Problem51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<List<Integer>>> res = new ArrayList<>();
        List<List<Integer>> temp = new ArrayList<>();
        Set<Integer> col = new HashSet<>();
        Set<Integer> dia = new HashSet<>();
        Set<Integer> off = new HashSet<>();
        backtrack(res, temp, 0, col, dia, off, 1, n);
        List<List<String>> finalRes = new ArrayList<>();
        for (int num = 0; num < res.size(); num++) {
            List<String> stringTemp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str= "";
                for (int j = 0; j < n; j++) {
                    if(res.get(num).get(i).get(1) == j){
                        str += "Q";
                    }else {
                        str += ".";
                    }
                }
                stringTemp.add(str);
            }
            finalRes.add(stringTemp);
        }
        return finalRes;
    }

    public void backtrack(List<List<List<Integer>>> res, List<List<Integer>> temp, int row, Set<Integer> col, Set<Integer> dia, Set<Integer> off, int count, int n) {
        if (temp.size() == n) {
            res.add(temp);
        } else {
            for (int j = 0; j < n; j++) {
                Set<Integer> colNew = new HashSet<>(col);
                Set<Integer> diaNew = new HashSet<>(dia);
                Set<Integer> offNew = new HashSet<>(off);
                if (!(colNew.contains(j) || diaNew.contains(row - j) || offNew.contains(row + j))) {
                    colNew.add(j);
                    diaNew.add(row - j);
                    offNew.add(row + j);
                    List<List<Integer>> tempNew = new ArrayList<>(temp);
                    tempNew.add(Arrays.asList(row, j));
                    backtrack(res, tempNew, row + 1, colNew, diaNew, offNew, count + 1, n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Problem51 p = new Problem51();
        p.solveNQueens(1);
        System.out.println(1);
    }
}
