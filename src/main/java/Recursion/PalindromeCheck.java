package Recursion;

public class PalindromeCheck {

    public static void main(String args[]){
        PalindromeCheck pc = new PalindromeCheck();
        System.out.println(pc.isPalindrome("santoor"));
    }

    public boolean isPalindrome(String input){
        if(input == "" || input.length() == 1){
            return true;
        }
        if(input.charAt(0) == input.charAt(input.length()-1)){
            return isPalindrome(input.substring(1,input.length()-1));
        }

        return false;
    }
}
