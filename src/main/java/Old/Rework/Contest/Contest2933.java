package Rework.Contest;

import java.util.*;

public class Contest2933 {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String,List<Integer>> map = new HashMap<>();
        int size = access_times.size();
        for (int i = 0; i < size; i++) {
            String name = access_times.get(i).get(0);
            int time = Integer.parseInt(access_times.get(i).get(1));
            List<Integer> individual_list = map.getOrDefault(name, new LinkedList<>());
            individual_list.add(time);
            map.put(name,individual_list);
        }
        List<String> res = new ArrayList<>();
        for(String k: map.keySet()){
            List<Integer> list = map.get(k);
            if(list.size()<3){
                continue;
            }
            Collections.sort(list);
            int left_pointer = 0;
            int right_pointer = 1;
            int access_count = 1;

            while(right_pointer < list.size()){
                if(list.get(right_pointer)-list.get(left_pointer)<100){
                    right_pointer ++;
                    if(right_pointer < list.size()){
                        continue;
                    }
                }
                access_count = right_pointer - left_pointer;
                if(access_count >= 3){
                    res.add(k);
                    break;
                }
                while(right_pointer< list.size() && list.get(right_pointer)-list.get(left_pointer)>=100){
                    left_pointer++;
                    if(left_pointer == right_pointer){
                        right_pointer++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Contest2933 c = new Contest2933();
        List<List<String>> list = new ArrayList<>();
        List<String> temp1 = new ArrayList<>();
        temp1.add("a");
        temp1.add("0549");
        List<String> temp2 = new ArrayList<>();
        temp2.add("b");
        temp2.add("0457");
        List<String> temp3 = new ArrayList<>();
        temp3.add("a");
        temp3.add("0532");
        List<String> temp4 = new ArrayList<>();
        temp4.add("a");
        temp4.add("0621");
        List<String> temp5 = new ArrayList<>();
        temp5.add("b");
        temp5.add("0540");
        list.add(temp1);
        list.add(temp2);
        list.add(temp3);
        list.add(temp4);
        list.add(temp5);
        System.out.println(c.findHighAccessEmployees(list));
    }
}
