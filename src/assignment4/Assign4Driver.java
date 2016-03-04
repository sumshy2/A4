package assignment4;

import java.util.List;

public class Assign4Driver
{
    public static void main(String[] args)
    {
        // Create a word ladder solver object
        Assignment4Interface wordLadderSolver = new WordLadderSolver();

        try 
        {
        	List<String> result3 = wordLadderSolver.computeLadder("heads", "tails");
        	List<String> result2 = wordLadderSolver.computeLadder("money", "beers");
            List<String> result = wordLadderSolver.computeLadder("money", "honey");
            boolean correct = wordLadderSolver.validateResult("money", "honey", result);
        } 
        catch (NoSuchLadderException e) 
        {
            e.printStackTrace();
        }
    }
}
