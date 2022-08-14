public class Trie {


    static final int ALPAHBET_SIZE = 26;

    static class TrieNode{
        boolean isEndOfWord;
        TrieNode[] children = new TrieNode[ALPAHBET_SIZE];
        TrieNode(){
            isEndOfWord = false;
        }
    }
    private static  TrieNode root = new TrieNode();

    public static void insert(String key){
        int index ;
        int length = key.length();
        int level;
        TrieNode current = root;

        for(level = 0; level<length; level++){
            index = key.charAt(level) - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public static boolean search(String key){
       int index;
       int length = key.length();
       int level;
       TrieNode current = root;

       for(level = 0; level<length; level++){
           index = key.charAt(level)-'a';
           if(current.children[index] == null){
               return false;
           }
           current = current.children[index];
       }
       return current.isEndOfWord;
    }

    public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};


        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);

        // Search for different keys
        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(search("there") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);

    }
}
