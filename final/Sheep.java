import java.util.Random;
import java.util.ArrayList;

class Sheep extends Object{
    Sheep(){
        super();
        super.changeHealth(100);
    }
    
    public int[] findSpots(ArrayList<Object> surroundings , ArrayList<int[]> surroundingCoords) {
        Random random = new Random();
        ArrayList<int[]> possibleMoves = new ArrayList<int[]>();
        
        for (int i = 0; i < surroundings.size(); i++) {
            if (!(surroundings.get(i) instanceof Dingo) && !(surroundings.get(i) instanceof Sheep)) {
                possibleMoves.add(surroundingCoords.get(i));
            }
        }
        
        int randInt = random.nextInt(possibleMoves.size());
        return possibleMoves.get(randInt);
    }
    
    public void update(Object object) {
        if (object instanceof Grass) {
            super.changeHealth(((Grass) object).getNutrition());
        }
    }
    
}