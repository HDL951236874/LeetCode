import java.util.*;
import java.util.stream.Collectors;

public class Test implements testing {
    testing test;

    @Override
    public void test() {
        System.out.println("this is a test");
    }

    public void stream_test() {
        Map<Integer,Integer> map = new HashMap<>();
        //根据值排序
    }

    public static void main(String[] args) {
        String[] str = new String[]{"1", "2", "3"};
        Integer[] num = new Integer[]{1, 2, 3};
        List x = Arrays.asList(str);
        List y = Arrays.asList(num);
        List<String> res = new ArrayList<String>(Arrays.asList(str));
        List<Integer> integers = new ArrayList<Integer>(y);
        System.out.println(1);

        Integer[] num2 = new Integer[]{1, 234, 1};
        List<Integer> res2 = new ArrayList<>(num2.length);
        int[] num3 = new int[]{1, 2, 3};
        List<Integer> res3 = Arrays.stream(num3).boxed().collect(Collectors.toList());
        Collections.addAll(res2, num2);
    }
}
