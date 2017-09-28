import java.awt.*;
import java.awt.image.*;
import java.awt.Color ;
import java.applet.* ;

// abstract 
class Robot extends WComponent {

   int rheight = Features.SIZE ;
   int rwidth = Features.SIZE ;
   public final int moveSize = 3 ;
   public int type ;
   Dimension dimension = new Dimension(rheight,rwidth) ;
   protected int speed ;
   private boolean alive = true ;
   boolean imageLoaded = false ;
   protected WComponent goal ;

   //      protected int xDir = 1  ;
   //      protected int yDir = -1 ;
   protected int direction = 270 ;
    // in degrees (clockwise) where 
    //    0 = East (right), 90 = South (down), 180 = West, 270 = North

   protected Point startPoint ;
   Image image ;
   Thread t ;
   boolean stuck = false ;

   public Robot(WComponent goal,int type, int x,int y) {
      System.out.println("Creating " + Features.props[type].name + " Robot " + 
                        " at " + x + "," + y) ;
      setLocation(x,y) ;
      image = Features.props[type].image ;
      startPoint = getLocation() ;
      setSize(getPreferredSize()) ;
      this.goal=goal ; this.type=type ;
      setSpeed(5) ;
      printOrientation() ;
   }

   public void paint(Graphics g) {
      if (image==null) {
         g.setColor(Features.props[type].color) ;
         g.fillRect(0,0,rwidth,rheight) ; 
      } 
      else {
         g.drawImage(image,0,0,Features.world) ;
      }
   } 

   public void setSpeed(int s) {
      speed = (int) s*50/moveSize+1 ;
      System.out.println("Speed of " + Features.props[type].name + " now " + speed) ;
   }

   private void pauseIfDead() {
      if (!alive) {
         try {Thread.sleep(1000);}
         catch (InterruptedException e) {
         }
      }
   }
   // returns null if can move to newloc without running into a component (obstacle)
   // otherwise returns the component
   public WComponent attemptMoveTo(Point newloc) {
      pauseIfDead() ;
      Rectangle bounds = this.getBounds() ;
      bounds.setLocation(newloc) ;
      for (int i = 0 ; i < Features.world.getComponentCount(); i++) {
         WComponent nextc = (WComponent) Features.world.getComponent(i) ;
         if (nextc!=this && nextc.isVisible) {
            if (bounds.intersects(nextc.getBounds())) {
              // if (!nextc.isVisible) continue ;
               if (Features.collisionSound!=null) {
                  Features.collisionSound.play() ;
               }
               return nextc ;
            } // else if (!nextc.isVisible) nextc.isVisible=true ;
         } 
      }
      setLocation(newloc) ;
      return null ;
   }

   boolean blocked() {
      pauseIfDead() ;
      Point newloc = newLocation() ;
      Rectangle bounds = this.getBounds() ;
      bounds.setLocation(newloc) ;
      for (int i = 0 ; i < Features.world.getComponentCount(); i++) {
         WComponent nextc = (WComponent) Features.world.getComponent(i) ;
         if (nextc!=this && nextc.isVisible) {
            if (bounds.intersects(nextc.getBounds())) {
               if (Features.collisionSound!=null) {
                  Features.collisionSound.play() ;
               
               
               }
               return true ;
            } 
         } 
      }
      return false ;
   }

   boolean notBlocked() {
      return !blocked() ;
   }

   void rotate90Right() {
      rotateRight(90) ;
   }


   void rotate45Right() {
      rotateRight(45) ;
   }

   void rotate90Left() {
      rotateLeft(90) ;
   }

   void rotate45Left() {
      rotateLeft(45) ;
   }

   private void rotateRight(int deg) {
      pauseIfDead() ;
      direction = (direction + deg) % 360 ;
      System.out.println("Rotating right " + deg + " degrees") ;
      System.out.println("New Direction = " + direction) ;
      System.out.flush() ;
   }

   private void rotateLeft(int deg) {  
      pauseIfDead() ;
      direction = (direction - deg + 360) % 360 ;
      System.out.println("Rotating left " + deg + " degrees") ;
      System.out.println("New Direction = " + direction) ;
      System.out.flush() ;
   }

   double degreesToRadians(int deg) {
      return deg/180.0 * Math.PI ;
   }

   Point newLocation() {
      Point oldLocation = getLocation() ;
      return 
         new Point(oldLocation.x + (int) (moveSize * Math.cos(degreesToRadians(direction))),
                  oldLocation.y + (int) (moveSize * Math.sin(degreesToRadians(direction)))) ;
   }

   public int collisionSurfaceOrientation(WComponent c) {
      Rectangle robR = getBounds() ;
      Rectangle intR = robR.intersection(c.getBounds()) ;
      if (intR.width>intR.height)
         return 0 ;
      else
         return 90 ;
   }

   public boolean finished() {
      if (goal!=null) {
         Rectangle robR = getBounds() ;
         robR.grow(moveSize,moveSize) ;
         return robR.intersects(goal.getBounds()) ;
      } 
      else 
         return false ;
   }

   public void dropSquare() { 
      if (alive) {
         Point loc = getLocation() ;
         WComponent square = new Obstacle(loc.x+rwidth/2,loc.y+rheight/2,moveSize,moveSize,Color.blue) ;
         square.isVisible=false ;
         Features.world.add(square);
      //       Features.world.repaint() ;
      }
   }

   boolean moveOneStep() {
      if (alive) {
         if (finished()){
            alive=false ; Features.world.remove(this) ; 
            return true ;
         } 
         else {
            boolean canMove = move() ;
            if (!canMove) {
            //                  System.out.println("Ouch!") ;
            //                  System.out.println((char)7) ;
               try {Thread.sleep(5000);}
               catch (InterruptedException e) {
               }
            }
            return canMove ;
         }
      } 
      
      else {
         try {Thread.sleep(1000);}
         catch (InterruptedException e) {
         }
         return true ;
      
      }
   
   }

//      abstract public void move() ;

   public Dimension getPreferredSize() {
      return dimension ;
   }

   public void eraseRobot() {
      setSize(0,0) ;
      repaint() ;
      Features.world.remove(this) ; 
   }


   private void changeDirection(int ang) {
   
   }

   public void printOrientation() {
      System.out.println("Direction  is " + direction + " degrees") ; 
   }


   public boolean move() {
   
      WComponent obstruction=attemptMoveTo(newLocation()) ;
      if (obstruction!=null) {
         return false ;
      //  changeDirection(collisionSurfaceOrientation(obstruction)) ;
        // move() ;
      } 
      else {
         Features.world.repaint() ;
         if (finished()) {
            System.out.println("Goal found!") ;
            if (Features.goalSound!=null) Features.goalSound.play() ;
            eraseRobot() ;
            // try {
            // Thread.sleep(1000);
            // }
                 
            return false;   
            // catch (InterruptedException e) {
            //         
            // }
         }  
         try {Thread.sleep(speed);}
         catch (InterruptedException e) {
         }
         return true ;
      }
   }

   //public void run() {
      //WComponent c ;
      //while (!finished()) {
        // try {Thread.sleep(speed);}
            //catch (InterruptedException e) {
          //  }
      //}
   //}
}  // end class Robot


