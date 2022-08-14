import java.util.*;
import java.util.stream.Collectors;

class Solution {

   class Transaction{
        int transactionCount = 0;
        int transactionAmount = 0;
        Transaction(int transactionCount, int transactionAmount){
            this.transactionCount = transactionCount;
            this.transactionAmount = transactionAmount;
        }
    }

    public int solution(int[] A,String[] D){
        int result = 0;
        int totalMonths = 12;
        String currentMonth = "0";

        Map<String,Transaction> transacDetails = new HashMap<String,Transaction>();
        for(int i=0;i<A.length;i++){
            result = result + A[i];
            String[] month = D[i].split("-");
            if(A[i]<0){
                if(transacDetails.containsKey(month[1])){
                   Transaction transaction = transacDetails.get(month[1]);
                   transaction.transactionCount++;
                   transaction.transactionAmount = transaction.transactionAmount + A[i];
                }else{
                    transacDetails.put(month[1],new Transaction(1,A[i]));
                }
            }
        }
        for(Map.Entry<String,Transaction> entry:transacDetails.entrySet()){
            Transaction transaction = entry.getValue();
            if(transaction.transactionCount >= 3 && transaction.transactionAmount <= -100){
                totalMonths--;
            }
        }

        return result - totalMonths * 5;
    }


    public static void main(String args[]) {

        int A[] = {180, -50, -25, -25};
        String D[] = {"2020-01-01", "2020-01-01", "2020-01-01", "2020-01-31"};
        Solution solution = new Solution();
        System.out.println(solution.solution(A, D));
    }
}
