/* Given a sentence and a word, your task is that to count the number of occurrences of the given word
   in the string and print the number of occurrence of the word.
1. Perform the above task using only methods of the String class (2 ways).
2. Print the tokenizers as a specific word is the delimiter using StringTokenizer class
"ITI develops people and ITI house of developers and ITI for people" */

import java.util.StringTokenizer;

class StringSplit {
	public static void main (String args[]){
		String sentence ="ITI develops people and ITI house of developers and ITI for people";
		String keyword="ITI";
		                        //First Way //
		int counter = 0;
		int index = 0;
		while(sentence.indexOf(keyword,index)!= -1){
			index = sentence.indexOf(keyword,index)+1;
			counter += 1;
		}
		System.out.println("Number of Occurence for the Keyword : " + counter);
		
		                       // Second Way //
		String splittedArr[] = sentence.split(" ");
		int ocurs = 0;
		for (String x:splittedArr)
		{
			if (keyword.equals(x))
				ocurs+=1;
		}
		System.out.println("Number of Occurence for the Keyword : " + ocurs);
		
		                    // String Tokenizer //
		StringTokenizer toknz = new StringTokenizer(sentence);
		while(toknz.hasMoreTokens())
		{
			System.out.println(toknz.nextToken("ITI"));
		}
	}
	
}