package assignment4;

//import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import assignment4.WordLadderSolver;

public class Assign4Driver
{
    public static void main(String[] args)
    {
        // Create a word ladder solver object
        Assignment4Interface wordLadderSolver = new WordLadderSolver();

		if (args.length != 1) {
			System.err.println ("Error: Incorrect number of command line arguments");
			System.exit(-1);
		}
		
		processLines (args[0], wordLadderSolver);

    }
    
    public static void processLines (String filename, Assignment4Interface wordLadderSolver) 
	{ 
	    try {
			ArrayList<String> dict = new ArrayList<String>();
			wordLadderSolver.getDictionaryWords(dict);
			FileReader freader = new FileReader(filename);
			BufferedReader reader = new BufferedReader(freader);
			for (String s = reader.readLine(); s != null; s = reader.readLine()) 
			{
				try{
					String[] command = s.split(" ");
					//THE COMMENTED CODE BELOW IS SKELETON CODE, IT'S NOT ACTUALLY PART OF OUR CODE
/*		        	List<String> result3 = wordLadderSolver.computeLadder("heads", "tails");
		        	List<String> result2 = wordLadderSolver.computeLadder("money", "beers");
		            List<String> result = wordLadderSolver.computeLadder("money", "honey");
		            boolean correct = wordLadderSolver.validateResult("money", "honey", result);*/
		            List<String> result = wordLadderSolver.computeLadder(command[0], command[1]); 
				}
		        catch (NoSuchLadderException e) 
		        {
		            e.printStackTrace();
		            System.out.println("Error");
		            continue;
		        }
	    	}
			System.exit(-1);
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println ("Error: File not found. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) 
		{
			System.err.println ("Error: IO exception. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		}

	}
	
    
}
