/* [Ecosim.java]
 * ecosystem simulator
 * Author: Joey Chik
 * 2018-04-24
 */

import java.util.Random;
import java.util.ArrayList;

class Ecosim {
    
    private static int ITERATIONS = 500;
    private static int TICK = 50;
    private static int SIZE = 25;
    
    private static double GRASS_DENSITY = 0.7; // dont go past 1 please thanks
    private static double SHEEP_DENSITY = 0.1;
    private static double DINGO_DENSITY = 0.1;
    
    private static double GRASS_PER_TURN = 0.1; // grass per turn
    
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
    private static void update(int x , int y , Object[][] map , int iteration) { // needs fixing
        Random random = new Random();
        
        if (map[x][y] != null) {
            if (map[x][y].getHealth() <= 0) {
                map[x][y] = null;
            } else {
                map[x][y].changeHealth(-1);
            }
        }
        
        Object current = map[x][y];
        
        //makes sure only animals that havent been moved are moved
        if (!(current instanceof Grass) && (current != null) && (current.getIteration() < iteration)) {
            if (Math.random() > MOVE_CHANCE) { // chance to not move
                ArrayList<Object> surroundings = new ArrayList<Object>();
                ArrayList<int[]> surroundingCoords = new ArrayList<int[]>();
                
                for (int row = -1; row < 2; row++) { // find all null spots around the object
                    if (x + row >= 0 && x + row < SIZE) {
                        for (int col = -1; col < 2; col++) {
                            if (y + col >= 0 && y + col < SIZE) {
                                if (!(row == 0 && col == 0)) {
                                    surroundings.add(map[x + row][y + col]);
                                    surroundingCoords.add(new int[]{x + row , y + col});
                                }
                            }
                        }
                    }
                }
                
                if (!surroundings.isEmpty()) {
                    // find new spot to move to
                    int[] newCoords = current.findSpots(surroundings , surroundingCoords);
                    
                    // move to new spot
                    map[x][y].updateIteration();
                    map[newCoords[0]][newCoords[1]] = current;
                    map[x][y] = null;
                }
            } else {
                map[x][y].updateIteration();
            }
        }
        if (Math.random() < GRASS_PER_TURN && map[x][y] == null) {
            map[x][y] = new Grass();
        }
    }
    
}