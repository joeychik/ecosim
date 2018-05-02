/* [Ecosim.java]
 * ecosystem simulator
 * Author: Joey Chik
 * 2018-04-24
 */

class Ecosim {
    
    private int iterations = 50;
    private int tick = 100;
    private int size = 25;
    
    private double grassDensity = 0.7; // dont go past 1 please thanks
    
    
    private Object map[][] = new Object[size][size];
    
    public static void main(String[] args) {
        
        int sheep = 1;
        int wolf = 1;
        
        // display the fake grid on Console
        //DisplayGridOnConsole(map);
        
        //Set up Grid Panel
        DisplayGrid grid = new DisplayGrid(map);
        
        for(int i = 0; i < iterations; i++) {        
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
        }
    }
    
    
    // Method to simulate grid movement
    public static void update(int x , int y , String[][] map) { 
        
        for(int i = 0; i<map[0].length;i++)        
            for(int j = 0; j<map.length;j++) 
        { 
            
            map[i][j]=((int)(Math.random()* 3))+"";
        }
    }
    
    //method to display grid a text for debugging
    public static void DisplayGridOnConsole(String[][] map) { 
        for(int i = 0; i<map.length;i++){        
            for(int j = 0; j<map[0].length;j++) 
                System.out.print(map[i][j]+" ");
            System.out.println("");
        }
    }
}