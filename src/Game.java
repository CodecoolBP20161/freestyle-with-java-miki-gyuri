import java.util.*;

/**
 * Created by gyuri & miki on 2016.11.03..
 */
public class Game {
    Object[] pastGuesses;
    List<Integer> puzzle = new ArrayList<>(4);
    List<Integer> userInput = new ArrayList<>(4);
    Game(Object[] pastGuesses, List<Integer> userInput){
        this.pastGuesses = pastGuesses;
        this.userInput = userInput;
        numGenerator();
    }
    List<Integer> numGenerator(){
        for (Integer i=0; i<4; i++){
            Integer rndNum;
            do {
                rndNum = new Random().nextInt(10);
            } while (Arrays.asList(puzzle).contains(rndNum));
            puzzle.set(i, rndNum);
        }
        return puzzle;
    }
    int[] compare(){
        int[] helper = {0, 0};
        List<Integer> cpPuzzle = puzzle;
        List<Integer> cpUserInput = userInput;
        for (int i=0; i<cpPuzzle.size(); i++){
            if (Objects.equals(cpPuzzle.get(i), cpUserInput.get(i))){
                helper[0]++;
                cpPuzzle.remove(i);
                cpUserInput.remove(i);
            } else if (cpPuzzle.contains(cpUserInput.get(i))){
                helper[1]++;
            }
        }
        return helper;
    }
}