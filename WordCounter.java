import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

	

	public class WordCounter {
		
		static <K,V extends Comparable<? super V>> 
        List<Entry<K, V>> entriesSortedByValues(Map<K,V> map) {

List<Entry<K,V>> sortedEntries = new ArrayList<Entry<K,V>>(map.entrySet());

Collections.sort(sortedEntries, 
        new Comparator<Entry<K,V>>() {
			//@Override
            public int compare(Entry<K,V> e1, Entry<K,V> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        }
);

return sortedEntries;
}


		public static void main(String[] args) throws IOException {
			
			//Create input stream & scanner
			FileInputStream fin = new FileInputStream("C:/temp/TheLittleMermaid.txt");
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
			
		
				
			 
				
			 System.out.println(entriesSortedByValues(Words));
			 
			 for(int i=0; i<10; i++) {
			 System.out.println(entriesSortedByValues(Words).get(i));
			 };
		
			
		//	System.out.println(Words.toString());
			
			//Close
			fileInput.close();
			fin.close();
					

		}

	}

