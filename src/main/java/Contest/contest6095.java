package Contest;

public class contest6095 {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length()<8) return false;
        boolean lower = false;
        boolean  upper = false;
        boolean digit = false;
        boolean special = false;
        for (int i = 0; i < password.length(); i++) {
            if(Character.isDigit(password.charAt(i))) digit = true;
            if(Character.isLowerCase(password.charAt(i))) lower = true;
            if(Character.isUpperCase(password.charAt(i))) upper = true;
            if("!@#$%^&*()-+".contains(String.valueOf(password.charAt(i)))) special = true;
            if(i>=1 && password.charAt(i)== password.charAt(i-1)) return false;
        }
        return lower&&upper&&digit&special;
    }
}
