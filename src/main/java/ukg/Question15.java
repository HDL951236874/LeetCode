package ukg;

public class Question15 {
    public int romanToInt(String s) {
        int result = 0;
        int[] temp = new int[]{1,5,10,50,100,500,1000};
        for (int i = s.length()-1; i >=0; i--) {
            if(s.charAt(i) == 'I'){
                result += temp[0];
            }
            if(s.charAt(i) == 'V'){
                result += temp[1];
                temp = new int[]{-1,5,10,50,100,500,1000};
            }
            if(s.charAt(i) == 'X'){
                result += temp[2];
                temp = new int[]{-1,-5,10,50,100,500,1000};
            }
            if(s.charAt(i) == 'L'){
                result += temp[2];
                temp = new int[]{-1,-5,-10,50,100,500,1000};
            }
            if(s.charAt(i) == 'C'){
                result += temp[2];
                temp = new int[]{-1,-5,-10,-50,100,500,1000};
            }
            if(s.charAt(i) == 'D'){
                result += temp[2];
                temp = new int[]{-1,-5,-10,-50,-100,500,1000};
            }
            if(s.charAt(i) == 'M'){
                result += temp[2];
                temp = new int[]{-1,-5,-10,-50,-100,-500,1000};
            }
        }
        return result;
    }
}
