package singletonDesignPattern;

import com.sun.javafx.util.Logging;

public class logging {


    //Lazy intiallization
    public static logging instance;


    //Constructor is always private
    private logging(){

    }
///////HOW TO MAKE LOGGING THREAD SAFE!!!!

    //1. USE synchronized method in lazy intiallization to make it THREAD SAFE


//    public synchronized static logging getInstance(){//which can be prevented from multi threading
//        if(instance==null){//2 Thread at the same time!!!!
//            instance=new logging();
//        }
//        return instance;
//    }

    //3. Make a BLOCK Synchronized.
    public static logging getInstance(){//which can be prevented from multi threading
        if(instance==null){
            //2 Thread at the same time!!!!
            synchronized (Logging.class) {
                if(instance==null) { //Double check
                    System.out.println("MY instance is null");
                    instance = new logging();
                }
            }
        }
        return instance;
    }

    public void printmsg(String msg){
        System.out.println("msg is " +msg);
    }

    public static void main(String[] args) {
        logging Logging=logging.getInstance();
        Logging.printmsg("my msg");
    }



    //Early intiallization

    // 2. Early Intiallization is used to make THREAD SAFE!!

//    public static logging instance =new logging();
//
//
//    private logging(){
//
//    }
//
//
//    public void printmsg(String msg){
//        System.out.println("msg is " +msg);
//    }
//
//    public static void main(String[] args) {
//        logging Logging=logging.instance;
//        Logging.printmsg("my msg");
//    }
}
