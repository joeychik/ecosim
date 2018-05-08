import java.util.ArrayList;

class Grass extends Object{
    
    private int nutrition;
    
    Grass() {
        super();
        this.nutrition = 30;
        super.changeHealth(5);
    }
    
    public int[] findSpots(ArrayList<Object> surroundings , ArrayList<int[]> surroundingCoords) {
        return null;
    }
    
    public int getNutrition() {
        return this.nutrition;
    }
    
    public void update(Object object) {
        
    }
    
}