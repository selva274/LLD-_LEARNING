class Singleton{
    private static volatile  Singleton instance;
    private Singleton(){ } 
    public static Singleton getInstance(){
        Singleton localinstace=instance;
        if(localinstace==null){
            synchronized (Singleton.class) {
                if(localinstace==null){
                    localinstace=new Singleton();
                }
                localinstace =new Singleton();
            }
        }
        return localinstace;
    }
}
class Main{
    public static void main(String[] args) {
        Runnable task=()->{
            Singleton singleton = Singleton.getInstance();
            System.out.println(singleton.hashCode());
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
    }
}