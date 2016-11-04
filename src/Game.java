import java.util.*;

/**
 * Created by gyuri & miki on 2016.11.03..
 */
public class Game {
    List<Integer> puzzle = new ArrayList<>(4);
    Game(){
        numGenerator();
    }
    void numGenerator(){
        for (Integer i=0; i<4; i++){
            Random rndNum = new Random();
            Integer numToAdd;
            numToAdd = rndNum.nextInt(10);
            while (puzzle.contains(numToAdd)) {
                numToAdd = rndNum.nextInt(10);
            }
            puzzle.add(numToAdd);
        }
    }
    List<Integer> getHelper(List<Integer> userInput){
        List<Integer> helpers = new ArrayList<>(Collections.nCopies(2, 0));
        List<Integer> cpPuzzle = puzzle;
        List<Integer> cpUserInput = userInput;
        for (int i=cpPuzzle.size()-1; i>=0; i--){
            if (Objects.equals(cpPuzzle.get(i), cpUserInput.get(i))){
                helpers.set(0, helpers.get(0)+1);
                cpPuzzle.remove(i);
                cpUserInput.remove(i);
            } else if (cpPuzzle.contains(cpUserInput.get(i))){
                helpers.set(1, helpers.get(1)+1);
            }
        }
        return helpers;
    }
}