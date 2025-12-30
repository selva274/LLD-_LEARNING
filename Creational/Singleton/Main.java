package Creational.Singleton;

class Logger{
    private static Logger logger=null;
    private Logger(){}
    public static Logger getLogger(){
        if(logger==null){
            synchronized(Logger.class
            ){
                if(logger==null){
                    return new Logger();
                }
            }
        }
        return logger;
    }
    public void log(String log){
        System.out.println("Log : "+log);
    }
}

class UserService{
    public void log(String log){
        System.out.println("User Log : "+log);
    }
}

public class Main {
    public static void main(String[] args) {
        Logger logger=Logger.getLogger();
        logger.log("Server runnnig...");
        
    }
}
