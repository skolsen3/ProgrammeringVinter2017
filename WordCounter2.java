import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

	

	public class WordCounter2 {
		
		//Lader os sortere på Value og ikke Key i TreeMap
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
			
			
			//Initialisering af variablerne AntalOrd og SamletKarakterLængde
			 int AntalOrd = 0;
			 int SamletKarakterLængde = 0;
			
			
			
			String TekstFilNavn = "C:/temp/EndnuStørreTekstFil.txt";
			//Create input stream & scanner
			FileInputStream fin = new FileInputStream(TekstFilNavn);
			Scanner fileInput = new Scanner(fin);
			
			//Laver TreeMap ved navn Words
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
					AntalOrd++;
					SamletKarakterLængde = SamletKarakterLængde + (nextWord.length());
				} else {
					Words.put(nextWord, 1);
					AntalOrd++;
					SamletKarakterLængde = SamletKarakterLængde + (nextWord.length());
				}
			}
			/*Gennemsnitlængde bliver afrundet til helt tal fx 4.0 i stedet for 4.32478 
			//Det er fordi SamletKarakterLængde og AntalOrd er declare'et som int
			Derfor castes enten SamletKarakterLængde eller AntalOrd som Double, 
			alternativet er at initialisere dem som typen double */
			double GennemsnitligOrdLængde = (double)SamletKarakterLængde/AntalOrd;
			 
			
			 
			 
			 //Karaktergivning (En lærer der går meget op i opgavelængden)
			 //Her oprettes en læser der beder om Brugerens input.
			 Scanner reader = new Scanner(System.in);  // Reading from System.in
			 System.out.println("Hvor mange ord er opgavekravet på? (Skriv venligst i inputfelt) ");
			 int AntalOrdOpgaveKrav = reader.nextInt(); // Scans the next token of the input as an int.
			 
			 //Intervallerne for de forskellige karakterer.
			 int KMaks12 =	(int) (AntalOrdOpgaveKrav*1.05);
			 int KMin12 = 	(int) (AntalOrdOpgaveKrav*0.95);
			 int KMaks10 = 	(int) (AntalOrdOpgaveKrav*1.1);
			 int KMin10 = 	(int) (AntalOrdOpgaveKrav*0.9);
			 int KMaks7 = 	(int) (AntalOrdOpgaveKrav*1.15);
			 int KMin7 = 	(int) (AntalOrdOpgaveKrav*0.85);
			 int KMaks4 = 	(int) (AntalOrdOpgaveKrav*1.2);
			 int KMin4 = 	(int) (AntalOrdOpgaveKrav*0.8);
			 int KMaks02 = 	(int) (AntalOrdOpgaveKrav*1.25);
			 int KMin02 = 	(int) (AntalOrdOpgaveKrav*0.75);
			 int KMaks00 =	(int) (AntalOrdOpgaveKrav*1.3);
			 int KMin00 = 	(int) (AntalOrdOpgaveKrav*0.7);
			 
			 //En stor if/else der printer den beregnede karakter
			 if(KMaks12>AntalOrd && KMin12<AntalOrd) {
				 System.out.println("Karakteren er 12");
			 } else if(KMaks10>AntalOrd && KMin10<AntalOrd) {
				 System.out.println("Karakteren er 10");
			 } else if(KMaks7>AntalOrd && KMin7<AntalOrd) {
				 System.out.println("Karakteren er 7");
			 } else if(KMaks4>AntalOrd && KMin4<AntalOrd) {
				 System.out.println("Karakteren er 4");
			 } else if(KMaks02>AntalOrd && KMin02<AntalOrd) {
				 System.out.println("Karakteren er 02");
			 } else if(KMaks00>AntalOrd && KMin00<AntalOrd) {
				 System.out.println("Karakteren er 00");
			 } else { 
				 System.out.println("Karakteren er -3");
			 }
			 
			 
			
			 System.out.println("Analyse af teksten = "+TekstFilNavn);
			 System.out.println("Samlede antal karakterer uden mellemrum = " +SamletKarakterLængde);
			 System.out.println("Samlet Antal Ord = " +AntalOrd);
			 System.out.println("Gennemsnitlige ordlængde = " +GennemsnitligOrdLængde);
			 
			
			 
			 for(int i=0; i<20; i++) {
			 System.out.println(entriesSortedByValues(Words).get(i));
			 };
		
			
			//Close
			fileInput.close();
			fin.close();
					
			reader.close(); 

		}

	}
