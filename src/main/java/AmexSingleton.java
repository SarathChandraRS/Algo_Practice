public class AmexSingleton {

    private static AmexSingleton singletonInstance = new AmexSingleton();
    private AmexSingleton(){

    }

    public static AmexSingleton getInstance(){
        return singletonInstance;
    }

}
