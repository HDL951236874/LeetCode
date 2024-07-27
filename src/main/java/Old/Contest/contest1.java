package Old.Contest;

public class contest1 {
    public String removeDigit(String number, char digit) {
        int index = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                index = i;
                if(i == number.length()-1) {
                    break;
                }
                if ((int) number.charAt(i + 1) > (int) number.charAt(i)) {
                    return subString(number,i);
                }

            }
        }
        return subString(number,index);
    }
    public String subString(String str, int i){
        String sub_string1 = str.substring(0, i);
        String sub_string2 = str.substring(i + 1, str.length());
        return sub_string1 + sub_string2;
    }

    public static void main(String[] args) {
        contest1 c = new contest1();
        System.out.println(c.removeDigit("2464",'6'));
    }
}
