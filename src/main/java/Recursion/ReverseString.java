package Recursion;

public class ReverseString {

    public String reverseString(String input){

        if (input.equals("")){
            return "";
        }
        return reverseString(input.substring(1)) + input.charAt(0);
    }

    public static void main(String[] a){
        ReverseString rs = new ReverseString();
        System.out.println(rs.reverseString("Sarath"));
    }
}
