package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class collections {
    public void test(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        Collections.sort(list,Collections.reverseOrder());
    }
}
