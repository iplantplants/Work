   import java.awt.*;
   import java.awt.image.*;
   import java.awt.Color ;
   import java.applet.* ;

   class Obstacle extends WComponent {
      private int height,width ;
      private Color color ;
   
      public Obstacle(int x, int y, 
                      int width, int height, Color color) {
         this.color=color ;
         this.height = height ;
         this.width = width ;
         setLocation(x,y) ;
         setSize(getPreferredSize()) ;
      }
   
      public void paint(Graphics g) {
         g.setColor(color) ;
         g.fillRect(0,0,width,height) ;
      }
   
      public Dimension getPreferredSize() {
         return new Dimension(width,height) ;
      }
   }

