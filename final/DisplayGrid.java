/* [DisplayGrid.java]
 * A Small program for Display a 2D String Array graphically
 * @author Mangat
 */

// Graphics Imports
import javax.swing.*;
import java.awt.*;

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
                    if (world[i][j] instanceof Sheep) {   //This block can be changed to match character-color pairs
                        g.setColor(Color.RED);
                    } else if (world[i][j] instanceof Dingo) {
                        g.setColor(Color.BLUE);
                    } else if (world[i][j] instanceof Grass) {
                        g.setColor(Color.GREEN);
                    } else {
                        g.setColor(Color.WHITE);
                    }
                    
                    g.fillRect(j*GridToScreenRatio, i*GridToScreenRatio, GridToScreenRatio, GridToScreenRatio);
                    g.setColor(Color.BLACK);
                    g.drawRect(j*GridToScreenRatio, i*GridToScreenRatio, GridToScreenRatio, GridToScreenRatio);
                }
            }
        }
    }//end of GridAreaPanel
    
} //end of DisplayGrid

