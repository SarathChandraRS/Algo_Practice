public class PrintCharTimes {

    public static void printString(String input){
        String tempString = "";
        char[] chars = input.toCharArray();
        int numberStart = -1;
        int numberEnd = -1;
        int count =0;
        for(int i=0;i<chars.length;i++){
            if(isChar(chars[i])){
                if (numberStart >-1){
                    count = Integer.parseInt(input.substring(numberStart,numberEnd+1));
                    for(int j=0;j<count;j++){
                        System.out.print(tempString);
                    }
                }
                tempString = String.valueOf(chars[i]);
            }
            else{
                if (isChar(input.charAt(i - 1))) {
                    numberStart = i;
                }
                numberEnd = i;
            }
        }
        count = Integer.parseInt(input.substring(numberStart,numberEnd+1));
        for(int j=0;j<count;j++){
            System.out.print(tempString);
        }
    }

    public static boolean isChar(Character c){
        if((c >='a' && c <= 'z') ||
                (c >='A' && c <= 'Z')){
            return true;
        }
        return false;
    }


    public static void main(String args[]){
        printString("b1c2d3e41h2f12");
    }
}