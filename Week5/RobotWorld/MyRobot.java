class MyRobot extends Robot {

   MyRobot(int x, int y) {
      super(Features.goal,0,x,y) ;
      Features.world.add(this) ; 
   }
}