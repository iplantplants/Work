// This program is losely based on the "Robot Search" program described in
// Chapter 11 of "Java, Software Solutions" by John Lewis and William Loftus
// Addison-Wesley, 1998.

// Author: Graham Roberts, July 1998

import java.awt.*;
import java.awt.image.*;
import java.awt.Color ;
import java.applet.* ;
import java.awt.event.* ;
import java.awt.MediaTracker;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class RobotWorld extends JPanel {
   private int doorWidth = 30 ;
   private int width ;
   private int height  ;
   private int xOffset = 10 ;
   private int yOffset = 10 ;
   private int messageHeight = 45 ;
   private Color obstacleColor = new Color(0,98,0) ;
   private Color goalColor = new Color(190,0,0) ;
   private Image img = null;

   private int bordersize = 5 ;
   private int cpHeight = 0 ;
   MediaTracker tracker;

   private WComponent goal = null ;

   public void init() {
      // Features.props[Features.XDIAGONAL].image=
         // getImage(getDocumentBase(),"Diagonal.gif") ;
      // tracker = new MediaTracker(this);
      // tracker.addImage(Features.props[Features.XDIAGONAL].image,0);
      // if (getParameter("SOUND").equals("yes")) {
         // Features.goalSound = getAudioClip(getDocumentBase(),"Audio/whoopy.au") ;
         // Features.collisionSound = getAudioClip(getDocumentBase(),"Audio/that.hurts.au") ;
      // }
   
      Toolkit k = getToolkit();
      String imagePath = "/images/";
      String audioPath = "/Audio/";
      try {
         Features.props[Features.XDIAGONAL].image
                    = ImageIO.read(getClass().getResource(imagePath + "Diagonal.gif"));
         Features.props[Features.XLEFT].image
                    = ImageIO.read(getClass().getResource(imagePath + "cyanLeft.gif"));
         Features.props[Features.XRIGHT].image
                    = ImageIO.read(getClass().getResource(imagePath + "cyanRight.gif"));
         Features.props[Features.XUP].image
                    = ImageIO.read(getClass().getResource(imagePath + "cyanUp.gif"));
         Features.props[Features.XDOWN].image
                    = ImageIO.read(getClass().getResource(imagePath + "cyanDown.gif"));
         Features.props[Features.XTR].image
                    = ImageIO.read(getClass().getResource(imagePath + "cyanTR.gif"));
         Features.props[Features.XTL].image
                    = ImageIO.read(getClass().getResource(imagePath + "cyanTL.gif"));
         Features.props[Features.XBR].image
                    = ImageIO.read(getClass().getResource(imagePath + "cyanBR.gif"));
         Features.props[Features.XBL].image
                    = ImageIO.read(getClass().getResource(imagePath + "cyanBL.gif"));
      
      } 
      catch (Exception e1) {
         System.out.println(e1);
      }
   
      tracker = new MediaTracker(this);
      tracker.addImage(Features.props[Features.XDIAGONAL].image, 0);
      tracker.addImage(Features.props[Features.XLEFT].image, 0);
      tracker.addImage(Features.props[Features.XRIGHT].image, 0);
      tracker.addImage(Features.props[Features.XUP].image, 0);
      tracker.addImage(Features.props[Features.XDOWN].image, 0);
   
      width =  350 ;
      height = 350 ;
      System.out.println("Size = " + width + "," + height) ;
      setSize(getPreferredSize()) ;
      setLayout(null) ;
      Graphics g = getGraphics() ;
      Features.world=this ;
      setBackground(Color.white) ;
      // Set up border
      // West wall
      add(new Obstacle(xOffset,
                      yOffset,
                      bordersize,
                      height-bordersize,obstacleColor));
      // East wall
      add(new Obstacle(width-bordersize+xOffset,
                      yOffset,
                      bordersize,
                      height-bordersize,obstacleColor));
      // North wall
      add(new Obstacle(xOffset,
                      yOffset,
                      width,
                      bordersize,obstacleColor));
      // South wall
      add(new Obstacle(xOffset,
                      yOffset+height-bordersize,
                      width,
                      bordersize,
                      obstacleColor));
   
   
      // Interal walls
      add(new Obstacle((width-bordersize)/2+xOffset,
                      yOffset,
                      bordersize,
                      height/3-doorWidth-bordersize,
                      obstacleColor)) ;
   
      add(new Obstacle((width-bordersize)/2+xOffset,
                      yOffset+height/3+doorWidth,
                      bordersize,
                         (int)(height*0.67)-doorWidth-bordersize,
                      obstacleColor));
   
      add(new Obstacle((width-bordersize)/2+xOffset,
                      yOffset+(int)(height*0.5),
                      width/4-doorWidth,
                      bordersize,
                      obstacleColor)) ;
   
      add(new Obstacle((int)((width-bordersize)*0.75)+xOffset+doorWidth,
                      yOffset+(int)(height*0.5),
                      width/4-doorWidth,
                      bordersize,
                      obstacleColor)) ;
   
   // The goal
      add(goal = new Obstacle(xOffset+width-30+bordersize,
                             yOffset+(int)(height*0.75),
                             20,
                             20,
                             goalColor));
      Features.goal=goal ;
      System.out.println("Initilization complete") ;
   }

   public void start() {
      try {
         tracker.waitForID(0);
      } 
      catch (InterruptedException e) {
         return;
      }
      Control m = new Control() ;
   }
   

   public Dimension getPreferredSize() {
      return new Dimension(width+2*xOffset,
                          height+4*yOffset+cpHeight+messageHeight) ;
   }

   public void update( Graphics g ) { 
      paint(g); }

   public void paint( Graphics g ) {
      Rectangle r = getBounds();
      if (img == null)
         img = createImage(r.width, r.height);
      Graphics ig = img.getGraphics();
      ig.clipRect(0,0,r.width,r.height);
      ig.setColor(getBackground()) ;
      ig.fillRect(0,0,r.width,r.height);
      super.paint(ig);
      g.drawImage(img, 0,0,null);
      ig.dispose();
   } 
   
}


