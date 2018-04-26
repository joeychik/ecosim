/* [Ecosim.java]
 * 
 * @author Mangat
 */

class Ecosim {  
  public static void main(String[] args) { 
    
    String stringMap[][] = new String[25][25];
    Object map[][] = new Object[25][25];
    int sheep = 1;
    int wolf = 1;
    
    // Initialize Map
    moveItemsOnGrid(stringMap);
    
    // display the fake grid on Console
    //DisplayGridOnConsole(map);
    
    //Set up Grid Panel
    DisplayGrid grid = new DisplayGrid(stringMap);
    
    while(true) {        
        // Initialize Map (Making changes to map)
        moveItemsOnGrid(stringMap);
        
        //Display the grid on a Panel
        grid.refresh();
        
        //Small delay
        try{ Thread.sleep(1000); }catch(Exception e) {};
    }
  }
  
  
  // Method to simulate grid movement
  public static void moveItemsOnGrid(String[][] map) { 
    
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