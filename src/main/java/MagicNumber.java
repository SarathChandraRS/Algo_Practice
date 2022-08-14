public class MagicNumber {

    public int sumNumber(int input) {
        int k=0, l=0;
        int m = 10;
        int rema;
        rema = input;
        while (k < 10) {
            //m=10;
            k = rema % m;
            rema = rema / m;
            l = l + k;
        }
        l = l + k;
        if(l>=10){
            sumNumber(l);
        }
        return l;
    }
}
