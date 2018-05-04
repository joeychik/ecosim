/* [Ecosim.java]
 * ecosystem simulator
 * Author: Joey Chik
 * 2018-04-24
 */

import java.util.Random;
import java.util.ArrayList;

class Ecosim {
    
    private static int ITERATIONS = 50;
    private static int TICK = 500;
    private static int SIZE = 25;
    
    private static double GRASS_DENSITY = 0; // dont go past 1 please thanks
    private static double SHEEP_DENSITY = 0.1;
    private static double DINGO_DENSITY = 0.1;
    
    private static double MOVE_CHANCE = 0.6;
    
    private static Object[][] map;
    
    public static void main(String[] args) throws Exception {
        map = new Object[SIZE][SIZE];
        
        //Set up Grid Panel
        DisplayGrid grid = new DisplayGrid(map);
        
        // populate grid
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                
                double rand = Math.random();
                
                if (rand < GRASS_DENSITY) {
                    map[row][col] = new Grass();
                } else if (rand < GRASS_DENSITY + SHEEP_DENSITY) {
                    map[row][col] = new Sheep();
                }else if (rand < GRASS_DENSITY + SHEEP_DENSITY + DINGO_DENSITY) {
                    map[row][col] = new Dingo();
                }
                
            }
        }
        
        grid.refresh();
        
        try{ Thread.sleep(TICK); }catch(Exception e) {};
        
        for(int i = 0; i < ITERATIONS; i++) {        
            // Initialize Map (Making changes to map)
            for(int row = 0; row < SIZE; row++) {
                for(int col = 0; col < SIZE; col++) {
                    update(row , col , map , i);
                }
            }
            
            //Display the grid on a Panel
            grid.refresh();
            
            //Small delay
            try{ Thread.sleep(TICK); }catch(Exception e) {};
        }
        System.out.println("done");
    }
    
    // 
    private static void update(int x , int y , Object[][] map , int iteration) { 
        Object current = map[x][y];
        
        //makes sure only animals that havent been moved are moved
        if (!(current instanceof Grass) && current != null && current.getIteration() < iteration) {
            ArrayList<int[]> surroundings = new ArrayList<int[]>();
            
            for (int row = -1; row < 2; row++) { // find all null spots around the object
                if (x + row >= 0 && x + row < SIZE) {
                    for (int col = -1; col < 2; col++) {
                        if (y + col >= 0 && y + col < SIZE) {
                            if (map[x + row][y + col] == null) {
                                int[] temp = {x , y};
                                surroundings.add(temp);
                            }
                        }
                    }
                }
            }
            
            if (surroundings.size() >= 0) { 
                int random = new Random().nextInt(surroundings.size());
                int newX = surroundings.get(random)[0];
                int newY = surroundings.get(random)[1];
                map[x][y].updateIteration();
                map[newX][newY] = map[x][y];
                map[x][y] = null;
            }
        }
    }//
    
}