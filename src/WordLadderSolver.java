/*
    ADD YOUR HEADER HERE
 */

package assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// do not change class name or interface it implements
public class WordLadderSolver implements Assignment4Interface
{
    // declare class members here.
 
    // add a constructor for this object. HINT: it would be a good idea to set up the dictionary there

    // do not change signature of the method implemented from the interface
    @Override
    
    /**
     * This function computes the word ladder
     *  dictionaryWord- stores all of the dictionary words
	 *	possibleWords - stores all the possible words the word can change to
     */
    public List<String> computeLadder(String startWord, String endWord) throws NoSuchLadderException 
    {
    	
    	ArrayList<String> dictionaryWordArray = new ArrayList<String>();//stores the dictionary words
		ArrayList<String> possibleWordArray = new ArrayList<String>();//stores the possible words the word can change to
		ArrayList<String> wordLadderArray = new ArrayList<String>();//stores the current word ladder array
		boolean finished=false;//stores if the process is finished
		
		wordLadderArray.add(startWord);//get the start word in the word ladder array
		
		//get the dictionary words and stores in the dictonaryWordArray
    	getDictionaryWords(dictionaryWordArray);
    	
		
		//for(int index=0; index<5 && finished == false;index++)
		while(finished==false)
    	{
			//get the possible words that the word can change to
			possibleWordArray = possibleWords(startWord, dictionaryWordArray);
			for(String tempString : possibleWordArray)
			{
				if(tempString.matches(endWord))
				{
					finished=true;
					wordLadderArray.add(tempString);
				}
					
			}
			if(finished!=true)
			{
				for(String possibleWord:possibleWordArray)
				{
					if(!wordLadderArray.contains(possibleWord))
					{
						wordLadderArray.add(possibleWord);//add this new value in 
						System.out.println(possibleWord);
						computeLadder(possibleWord, endWord);
					}
					//if(possibleWord.charAt(index) == endWord.charAt(index))//SEE iF THE CHAR IS THE SAME as end word
					//{
						
					//}
						
					//if invalid send a -1
				}
			}
				
		}
		
		//if it is true then print out the word ladder
		if(finished == true)
		{
			System.out.println("For the input words \""+startWord+ "\" and \"" + endWord + 
					"\" the following word ladder was found:");
			for(String tempWord: wordLadderArray)
				System.out.println(tempWord);
		}
			
		
	
    	
  
    	//get the possible words that the word can change to
    	
    	
    	
        // implement this method
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public boolean validateResult(String startWord, String endWord, List<String> wordLadder) 
    {
        throw new UnsupportedOperationException("Not implemented yet!");
    }
    
    
    /**
     * This function opens the dictionary file and stores the words in
     * an ArrayList for future use
     * @param tempArrayList - This is the ArrayList that is initially empty
     * @return tempArrayList - This is the ArrayList that is passed to the method
     * and it returns a full ArrayList of the dictionary words
     */
    public void getDictionaryWords(ArrayList<String> tempArrayList)
    {
    	//open the dictionary and get the words into an array
    	try {
			FileReader freader = new FileReader("A4words.dat");
			BufferedReader reader = new BufferedReader(freader);
		
			//processes every line in the file until it has read every line in the file
			//and stores the words into an array
			for (String tempString = reader.readLine(); tempString != null; tempString = reader.readLine()) {
				tempString=tempString.substring(0, 5);
				if(tempString.charAt(0) != '*')
				{
					tempArrayList.add(tempString);
					//System.out.println(tempString);
				}
				
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println ("Error: File not found. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			System.err.println ("Error: IO exception. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		}
    	//return tempArrayList;
    }
    
    
    
    public ArrayList<String> possibleWords(String currentWord, ArrayList<String> dictionaryArray)
    {
    	ArrayList<String> possibleWordArray = new ArrayList<String>();//stores the dictionary words
		String tempDictionaryWord;//stores the dictionaryWord that is missing one char
		for(int indexToChange=0; indexToChange<5;indexToChange++)
		{
			//stores the temporary string that will be compared to to see if the words differ by one letter
			String tempString = currentWord.substring(0, indexToChange) + currentWord.substring(indexToChange+1);

			for(String dictionaryWord : dictionaryArray)
			{
				tempDictionaryWord=dictionaryWord.substring(0, indexToChange) + dictionaryWord.substring(indexToChange+1);
				
				//if the words match (only if they differ by one letter specified by the indexToChange)
				//and they are not the same word, store it into the array
				if(tempDictionaryWord.matches(tempString) && !(dictionaryWord.matches(currentWord)))
				{
					possibleWordArray.add(dictionaryWord);
				}
			}
		}
				
    	return possibleWordArray;
	}
    // add additional methods here
}