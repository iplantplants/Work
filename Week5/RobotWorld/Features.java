import java.awt.Color ;
import java.awt.* ;
import java.awt.image.* ;
import java.applet.* ;

class Prop {
   Color color ; 
   String name;
   Image image = null  ;

   Prop(String n, Color c) {
      color=c ; 
      name=n; 
   }  
}

class Features {
   static final int XDIAGONAL = 0,
            XRANDOM = 1,
            XOTHER = 2,
            XLEFT = 3, 
            XRIGHT = 4, 
            XUP = 5, 
            XDOWN = 6,
            XTR = 7, 
            XTL = 8, 
            XBR = 9, 
            XBL = 10;

   static Prop props[]
            = {new Prop("Diagonal", Color.cyan),
                new Prop("Random", Color.magenta),
                new Prop("Other", Color.orange),
                new Prop("cyanLeft", Color.cyan),
                new Prop("cyanRight", Color.cyan),
                new Prop("cyanUp", Color.cyan),
                new Prop("cyanDown", Color.cyan),
                new Prop("cyanTR", Color.cyan),
                new Prop("cyanTL", Color.cyan),
                new Prop("cyanBR", Color.cyan),
                new Prop("cyanBL", Color.cyan)
   
            };
  
   static final int SIZE = 30 ;      
   static final int pop = props.length ;
   static RobotWorld world = null ;
   static WComponent goal = null ;
   static AudioClip goalSound = null,
                     collisionSound = null ;
}
