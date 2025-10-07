package ca.bytetube._12_recursion;

public class PrintSubStr {
    public static void main(String[] args) {
        printSubStr("abc");
    }

    public static void printSubStr(String s) {
        String str = "";
        printSubStr(s, 0, str);
    }

    private static void printSubStr(String s, int index, String str) {
        if (index == s.length()) {
            System.out.println(str);
            return;
        }

        printSubStr(s, index + 1, str);

        printSubStr(s, index + 1, str + s.charAt(index));
    }
}