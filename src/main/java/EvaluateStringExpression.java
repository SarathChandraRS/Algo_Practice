import java.util.Stack;

public class EvaluateStringExpression{

    public static void evaluateExpression(String input){
        Stack<Character> stack = new Stack<Character>();
        String temp ="";
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) == ']'){
                temp = "";
                while(stack.size() > 0 && stack.get(stack.size()-1) != '['){
                    temp = stack.get(stack.size()-1) + temp;
                    stack.remove(stack.size()-1);
                }
                stack.remove(stack.size()-1);
                String num = "";
                while(stack.size() > 0 && isDigit(stack.get(stack.size()-1))){
                    num = stack.get(stack.size()-1) + num;
                    stack.remove(stack.size()-1);
                }
                Integer count = Integer.parseInt(num);
                String res = "";
                for(int j=0;j<count;j++){
                    res = res + temp;
                }
                for(int k=0;k<res.length();k++){
                    stack.add(res.charAt(k));
                }

            }
            else{
                stack.add(input.charAt(i));
            }
        }

        for(Character c:stack){
            System.out.print(c);
        }
    }

    public static boolean isDigit(Character ch){
        if((ch >= 'a' && ch <= 'z') ||
        (ch >= 'A' && ch <= 'Z') ||
        (ch == ']' || ch == ']')){
            return false;
        }

        return true;
    }

    public static void main(String args[]){
        evaluateExpression("3[b2[ca]]");
    }
}