package Recursion;

import java.util.Stack;

public class PrintBalancedParanthesis {

    public static void printParanthesis(int n,int open,int close,String str){

        if( open == n && close == n){
            System.out.println(str);
            return;
        }
        if(open < n){
            printParanthesis(n,open+1,close,str + "{");
        }
        if(close < open){
            printParanthesis(n,open,close+1,str + "}");
        }
    }

    public static void main(String args[]){
        printParanthesis(4,0,0,"");
    }
}
