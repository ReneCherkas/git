package Mess;

public class Message {
    public static void info(Object message){
        System.out.println(message);
    }

    public static void error(Object message){
        System.err.println(message);
    }
}
