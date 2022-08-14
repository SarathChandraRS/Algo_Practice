package array;

public class StockProfit {

    public static void main(String[] args)
    {

        // stock prices on consecutive days
        int price[] = { 100, 180, 260, 310, 40, 535, 90 };
        int n = price.length;

        // function call
        System.out.println(stockProfit(price));
    }

    public static double stockProfit(int[] input){
        double profit =0;
        double totalProfit = 0;
        int min =0;
        for(int i=1;i<input.length;i++){
            if(input[i]-input[min] > profit){
                profit = input[i]-input[min];
            }
            else{
                min = i;
                totalProfit = totalProfit + profit;
                profit=0;
            }
        }

        return totalProfit + profit;
    }
}
