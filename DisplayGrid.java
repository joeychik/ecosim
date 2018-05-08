/* [DisplayGrid.java]
 * A Small program for Display a 2D String Array graphically
 * @author Mangat
 */

// Graphics Imports
import javax.swing.*;
import java.awt.*;
<<<<<<< HEAD
import javax.imageio.*;
<<<<<<< HEAD
*/
import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.io.FileInputStream;
import java.net.URL;
=======

>>>>>>> parent of 6065589... asdgdasghs;lj
=======
>>>>>>> parent of 4ec3aee... pelase help images dont work

class DisplayGrid { 
    
    private JFrame frame;
    private int maxX,maxY, GridToScreenRatio;
    private Object[][] world;
    
    DisplayGrid(Object[][] w) { 
        this.world = w;
        
        maxX = Toolkit.getDefaultToolkit().getScreenSize().width;
        maxY = Toolkit.getDefaultToolkit().getScreenSize().height;
        GridToScreenRatio = maxY / (world.length+1);  //ratio to fit in screen as square map
        
        System.out.println("Map size: "+world.length+" by "+world[0].length + "\nScreen size: "+ maxX +"x"+maxY+ " Ratio: " + GridToScreenRatio);
        
        this.frame = new JFrame("Map of World");
        
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
            
            for(int i = 0; i < world[0].length; i++) { 
                for(int j = 0; j < world.length; j++) { 
                    
<<<<<<< HEAD
<<<<<<< HEAD
                    int xPos = j * GridToScreenRatio;
                    int yPos = i * GridToScreenRatio;
                                        
                    if (world[j][i] instanceof Sheep) {   //This block can be changed to match character-color pairs
                        g.drawImage(sheep , xPos , yPos , GridToScreenRatio , GridToScreenRatio , this);
                    } else if (world[j][i] instanceof Dingo) {
                        g.drawImage(sheep , xPos , yPos , GridToScreenRatio , GridToScreenRatio , this);
                    } else if (world[j][i] instanceof Grass) {
                        g.drawImage(sheep , xPos , yPos , GridToScreenRatio , GridToScreenRatio , this);
=======
=======
                    
                    
>>>>>>> parent of 4ec3aee... pelase help images dont work
                    if (world[i][j] instanceof Sheep) {   //This block can be changed to match character-color pairs
                        g.setColor(Color.RED);
                    } else if (world[i][j] instanceof Dingo) {
                        g.setColor(Color.BLUE);
                    } else if (world[i][j] instanceof Grass) {
                        g.setColor(Color.GREEN);
                    } else {
                        g.setColor(Color.WHITE);
<<<<<<< HEAD
>>>>>>> parent of 6065589... asdgdasghs;lj
=======
>>>>>>> parent of 4ec3aee... pelase help images dont work
                    }
                    
                    g.fillRect(j*GridToScreenRatio, i*GridToScreenRatio, GridToScreenRatio, GridToScreenRatio);
                    g.setColor(Color.BLACK);
                    g.drawRect(j*GridToScreenRatio, i*GridToScreenRatio, GridToScreenRatio, GridToScreenRatio);
                }
            }
        }
    }//end of GridAreaPanel
    
} //end of DisplayGrid

