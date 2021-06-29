package Test;

public class T2 {
    public static void main(String[] args) {
        String s = "abcd";
        String s2 = s.substring(4);
        String s3 = new String(s2);
        String s4 = new String(s2.toCharArray());
    }
}
