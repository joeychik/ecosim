abstract class Object{
    private int health;
    private int decay;
    private int lastIteration;
    
    Object() {
        this.lastIteration = 0;
        this.health = 0;
    }
    
    //abstract void update( ArrayList<int[]> surroundings);
    
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