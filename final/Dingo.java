import java.util.Random;
import java.util.ArrayList;

class Dingo extends Object{
    
    
    Dingo() {
        super();
        super.changeHealth(150);
    }
    
    public int[] findSpots( ArrayList<Object> surroundings , ArrayList<int[]> surroundingCoords) {
        Random random = new Random();
        ArrayList<int[]> possibleMoves = new ArrayList<int[]>();
        
        for (int i = 0; i < surroundings.size(); i++) {
            if (!(surroundings.get(i) instanceof Dingo)) {
                possibleMoves.add(surroundingCoords.get(i));
            }
        }
        
        int randInt = random.nextInt(possibleMoves.size());
        return possibleMoves.get(randInt);
    }
    
    public void update(Object object) {
        if (object instanceof Sheep) {
            super.changeHealth(object.getHealth());
        }
    }
    
}