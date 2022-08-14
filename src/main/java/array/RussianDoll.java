package array;

/*
LeetCode -- HARD
You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

 */

public class RussianDoll {

    private int maxEnvelopeCount = 0;

    public int maxEnvelopes(int[][] envelopes) {
        return maxEnvelopeCount;
    }

    private void sortEnvelopes(int[][] envelopes,int start,int end){
        if(start > end){
            int m = (start + end)/2;
            sortEnvelopes(envelopes,start,m);
            sortEnvelopes(envelopes,m+1,end);
            merge(envelopes,start,m,end);

        }

    }

    private void merge(int[][] envelopes,int start,int m,int end){
        int ml = start + m +1;
        int mr = end + m;

        int[][] larr = new int[ml][2];
        int[][] rarr = new int[mr][2];

        int i=0,j=0,k=start;
        for(int g=0;g<ml;g++){
            larr[g] = envelopes[start+g];
        }
        for(int h=0;h<mr;h++){
            rarr[h] = envelopes[m+1+h];
        }
        


    }
}
