package Jianzhi;

public class jianzhi3 {
    public String replaceSpace(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                stringBuffer.append("%20");
            }else {
                stringBuffer.append(s.charAt(i));
            }
        }
        return stringBuffer.toString();
    }
}
