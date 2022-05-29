package String;

public class Problem6 {
    // this problem is typical and i think there is a easier way
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int[] line_number = get_number_each_line(s, numRows);
        String res = "";
        for (int i = 0; i < line_number.length; i++) {
            for (int j = 0; j < line_number[i]; j++) {
                if (i == 0) {
                    // this is the 1st line
                    res += s.charAt((numRows - 1) * 2 * j);
                } else if (i == line_number.length - 1) {
                    res += s.charAt((numRows - 1) * 2 * j + (numRows - 1));
                } else {
                    if (j % 2 == 0) {
                        res += s.charAt((numRows-1)*2*(j/2)+i);
                    } else {
                        res += s.charAt((numRows-1)*2*(j/2)+(numRows-1)*2-i);
                    }
                }
            }
        }
        return res;
    }

    public int[] get_number_each_line(String s, int numRows) {
        int number_Z = s.length() / ((numRows - 1) * 2);
        int number_left = s.length() % ((numRows - 1) * 2);
        int[] line_number = new int[numRows];
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                line_number[0] = number_left >= 1 ? number_Z + 1 : number_Z;
            } else if (i == numRows - 1) {
                line_number[numRows - 1] = number_left >= numRows ? number_Z + 1 : number_Z;
            } else {
                if (number_left < i + 1) {
                    line_number[i] = number_Z * 2;
                } else if (number_left >= i + 1 && number_left < ((numRows - 1) * 2) + 1 - i) {
                    line_number[i] = number_Z * 2 + 1;
                } else {
                    line_number[i] = number_Z * 2 + 2;
                }
            }
        }
        return line_number;
    }

    public static void main(String[] args) {
        System.out.println(1/2);
        Problem6 p = new Problem6();
        p.convert("A", 1);
    }
}
