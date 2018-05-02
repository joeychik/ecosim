/* [Ecosim.java]
 * ecosystem simulator
 * Author: Joey Chik
 * 2018-04-24
 */

import java.util.Random;

class Ecosim {
    
    private int iterations = 50;
    private int tick = 100;
    private int size = 25;
    
    private double grassDensity = 0.7; // dont go past 1 please thanks
    private double sheepDensity = 0.1;
    private double dingoDensity = 0.1;
    
    
    private Object map[][];
    
    public static void main(String[] args) throws Exception {
        map = new Object[size][size];
        
        //Set up Grid Panel
        DisplayGrid grid = new DisplayGrid(map);
        
        // populate grid
        for(int row; row < size; row++) {
            for(int col; col < size; col++) {
                
                double rand = Math.random();
                
                if (rand < grassDensity) {
                    map[row][col] = new Grass();
                } else if (rand < grassDensity + sheepDensity) {
                    map[row][col] = new Sheep();
                }else if (rand < grassDensity + sheepDensity + dingoDensity) {
                    map[row][col] = new Dingo();
                }
                
            }
        }
        
        grid.refresh();
        
        /*for(int i = 0; i < iterations; i++) {        
            // Initialize Map (Making changes to map)
            for(int row; row < size; row++) {
                for(int col; col < size; col++) {
                    update(row , col , map);
                }
            }
            
            //Display the grid on a Panel
            grid.refresh();
            
            //Small delay
            try{ Thread.sleep(tick); }catch(Exception e) {};
        }*/
    }
    
    /*/ Method to simulate grid movement
    public static void update(int x , int y , String[][] map) { 
        Object current = map[x][y];
        
        if (current instanceof Grass) {
            if (current.getHealth == 0) {
                map[x][y] = null;
            } else {
                
        } else if (current instanceof Dingo) {
            
        } else if (current instanceof Sheep) {
            
        }
        
    }*/
    
}