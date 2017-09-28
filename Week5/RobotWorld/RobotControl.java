abstract class RobotControl implements Runnable {
   Thread t ;
//   RobotControl TheRobot = this ;

   RobotControl() {
      t = new Thread(this) ;
      t.start() ;
      System.out.println("Control started") ;
   }

   abstract void go() ;  

   public void run() {
      go() ;
   }
}
