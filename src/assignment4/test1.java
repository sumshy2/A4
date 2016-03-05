package assignment4;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class test1 {
	//WordLadder solution = new WordLadder();
	WordLadderSolver solution = new WordLadderSolver();
	@Test
/*	public void test() {
		//fail("Not yet implemented");
		ArrayList<String> dict = new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));
		assertEquals(true,solution.inDictionary("Buenos Aires", "Córdoba", dict));
	}*/
	
/*	public void test2() {
		//fail("Not yet implemented");
		ArrayList<String> dict = new ArrayList<>(Arrays.asList("buenos", "cordoba", "La Plata"));
		assertEquals(true,solution.inDictionary("buenos", "cordoba", dict));
	}*/
	
	public void test3() throws NoSuchLadderException{
		ArrayList<String> dict = new ArrayList<String>();
		solution.getDictionaryWords(dict);
		assertEquals(true,solution.inDictionary("amaze", "alien!", dict));
	}
	//WordLadder

}
