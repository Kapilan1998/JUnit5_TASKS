
public class MyUtils {


    public static int add(int n1, int n2) {
        return n1+n2;
    }


    public static boolean isPalindrome(String inputText) {
        return new StringBuffer(inputText).reverse().toString().equals(inputText);
    }


    public static Integer multiply(int n1, int n2) {
        return n1*n2;
    }
}