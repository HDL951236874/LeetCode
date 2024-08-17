package ukg;

public class Question16 {
    public String intToRoman(int num) {
        String[] temp1 = new String[]{"I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] temp2 = new String[]{"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] temp3 = new String[]{"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] temp4 = new String[]{"M","MM","MMM"};
        String[][] temp = new String[][]{temp1,temp2,temp3,temp4};
        String str = Integer.toString(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if(now == '0') continue;
            sb.append(temp[str.length()-i-1][Character.getNumericValue(now)-1]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Question16 q = new Question16();
        System.out.println(q.intToRoman(11));
    }
}
