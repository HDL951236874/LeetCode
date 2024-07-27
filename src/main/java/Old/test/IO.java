package test;

import java.io.*;

public class IO {
    public void test() throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));
        bufferedWriter.write("bfoabf\n");
        bufferedWriter.write("nbofqn\n");
        bufferedWriter.close();
        BufferedReader  bufferedReader = new BufferedReader(new FileReader("test.txt"));
        String s;
        while ((s=bufferedReader.readLine())!=null){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        IO io = new IO();
        try {
            io.test();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
