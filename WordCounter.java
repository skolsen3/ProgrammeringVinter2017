import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class WordCounter {

	public static void main(String[] args) throws IOException {
		
		//Create input stream & scanner
		FileInputStream fin = new FileInputStream("Rotten123.txt");
		Scanner fileInput = new Scanner(fin);
		
		//Laver Hashtable ved navn Words
		SortedMap<String, Integer> Words
		 = new TreeMap<String, Integer>();
		//Read through file and find the words
		//Kalder metoden has.Next som returnerer en værdi af typen boolean
		while(fileInput.hasNext()){
			//Get the next word
			//Finder det næste input i scanneren
			String nextWord = fileInput.next();
			//Determine if the word is in the ArrayList
			//Hvis ordet er i Hashtabl'et i forvejen lægges 1 til i ("",Integer) ellers oprettes ordet med put (1)
			if(Words.containsKey(nextWord)){
				Words.put(nextWord,  Words.get(nextWord) + 1);
			} else {
				Words.put(nextWord, 1);
			}
		}
		
		SortedMap<Integer, String> Flippedmap
		= new List<Integer, String>(new Comparator<Integer>() {
			 public int compare(Integer o1, Integer o2) {
				 return o2.compareTo(o1);
			}
		});
		System.out.println(Collections.sort((Words.values()));
		for(Map.Entry<String,Integer> Word : Words.entrySet()) 
		{
//			System.out.println(Word.getValue());
			Flippedmap.put(Word.getValue(), Word.getKey());
		
		}
		System.out.println(Words.toString());
		System.out.println(Flippedmap.toString());
		//Close
		fileInput.close();
		fin.close();
				

	}

}
