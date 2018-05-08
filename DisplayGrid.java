/* [DisplayGrid.java]
 * A Small program for Display a 2D String Array graphically
 * @author Mangat
 */

// Graphics Imports
/*
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
*/
import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.io.FileInputStream;
import java.net.URL;

class DisplayGrid { 
    
    private JFrame frame;
    private int maxX,maxY, GridToScreenRatio;
    private Object[][] world;
    
    private static Image sheep;
    private static Image dingo;
    private static Image grass;
    
    DisplayGrid(Object[][] w) { 
        this.world = w;
        
        sheep = Toolkit.getDefaultToolkit().getImage("sprite/sheep_smol.png");
        dingo = Toolkit.getDefaultToolkit().getImage("sprite/dingo_smol.png");
        grass = Toolkit.getDefaultToolkit().getImage("sprite/grass_smol.png");
        
        maxX = Toolkit.getDefaultToolkit().getScreenSize().width;
        maxY = Toolkit.getDefaultToolkit().getScreenSize().height;
        GridToScreenRatio = maxY / (world.length + 2);  //ratio to fit in screen as square map
        
        System.out.println("Map size: " + world.length+" by " + world[0].length + "\nScreen size: " + maxX + "x" + maxY + " Ratio: " + GridToScreenRatio);
        
        this.frame = new JFrame("DingoSim 2000");
        
        GridAreaPanel worldPanel = new GridAreaPanel();
        
        frame.getContentPane().add(BorderLayout.CENTER, worldPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setVisible(true);
    }
    
    
    public void refresh() { 
        frame.repaint();
    }
    
    
    
    class GridAreaPanel extends JPanel {
        public void paintComponent(Graphics g) {        
            //super.repaint();
            
            setDoubleBuffered(true); 
            g.setColor(Color.BLACK);
            
            g.setColor(new Color(220, 140, 55));
            g.fillRect(0 , 0 , maxX , maxY);
            
            g.drawImage(sheep , 20 , 20 , this);
            
            for(int i = 0; i < world[0].length; i++) { 
                for(int j = 0; j < world.length; j++) { 
                    
                    int xPos = j * GridToScreenRatio;
                    int yPos = i * GridToScreenRatio;
                                        
                    if (world[j][i] instanceof Sheep) {   //This block can be changed to match character-color pairs
                        g.drawImage(sheep , xPos , yPos , GridToScreenRatio , GridToScreenRatio , this);
                    } else if (world[j][i] instanceof Dingo) {
                        g.drawImage(sheep , xPos , yPos , GridToScreenRatio , GridToScreenRatio , this);
                    } else if (world[j][i] instanceof Grass) {
                        g.drawImage(sheep , xPos , yPos , GridToScreenRatio , GridToScreenRatio , this);
                    }
                }
            }
        }
    }//end of GridAreaPanel
    
} //end of DisplayGrid

