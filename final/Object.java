import java.util.ArrayList;

abstract class Object{
    private int health;
    private int decay;
    private int lastIteration;
    
    Object() {
        this.lastIteration = 0;
        this.health = 0;
    }
    
    abstract int[] findSpots(ArrayList<Object> surroundings , ArrayList<int[]> surroundingCoords);
    
    abstract void update(Object object);
    
    // getters and setters
    public int getHealth() {
        return this.health;
    }
    
    public void updateIteration() {
        this.lastIteration++;
    }
    
    public int getIteration() {
        return this.lastIteration;
    }
        
    public void changeHealth(int h) {
        this.health += h;
    }
    
}