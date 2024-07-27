package test;

import java.util.ArrayList;
import java.util.List;

interface printable{
    void print();
}

class printTest{

    public void printiing( printable printable) {
        printable.print();
    }
}

public class lambda {
    public void test(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<Integer> list1 = new ArrayList<>();
        list.stream().filter(x->x>0).forEach(System.out::println);
    }

    public static void main(String[] args) {
//        lambda lambda = new lambda();
//        lambda.test();
        printTest printTest = new printTest();
        printTest.printiing(()-> System.out.println("1"));
    }
}
