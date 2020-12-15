import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
/**
 * Class to create Concordance data structure, hashtable
 * @author 
 *
 */
public class ConcordanceDataStructure implements ConcordanceDataStructureInterface {
	/**
	 * Fields for Concordance data structure
	 */
	private int tableSize;
	private LinkedList<ConcordanceDataElement>[] hashTable;
	private ConcordanceDataElement cde;
	/**
	 * Constructor to test data structure
	 * @param test - test word
	 * @param size - size of hashtable
	 */
	@SuppressWarnings("unchecked")
	public ConcordanceDataStructure(String test, int size) {
		test = "Testing";
		hashTable = new LinkedList[size];
		for(int i = 0; i < size; i++) {
			hashTable[i] = new LinkedList<ConcordanceDataElement>();
		}
	}
	/**
	 * Constructor to create data structure, hashtable
	 * @param num  - estimated number of words in the text
	 */
	@SuppressWarnings("unchecked")
	public ConcordanceDataStructure(int num) {
		tableSize = (int) (num / 1.5); // 700/1.5 = 466, 467 is next 4k+3
		int newtableSize = (int)tableSize + 14; // with 700, not 466...467 yes
		hashTable = new LinkedList[newtableSize];
		
		for(int i = 0; i < newtableSize; i++) {
			hashTable[i] = new LinkedList<ConcordanceDataElement>();
		}
	}
	/**
	 * Method to return size of hashtable
	 * @return int size of hashtable
	 */
	@Override
	public int getTableSize() {
		
		return hashTable.length;
	}
	/**
	 * Method to return array list of the words at 
	 * indicated index in hashtable
	 * @return words - arraylist of words in index
	 */
	@Override 
	public ArrayList<String> getWords(int index) {
		
		ArrayList<String> words = new ArrayList<>();
		for(int i = 0; i < hashTable[index].size(); i++) {
			if(hashTable[index].get(i) != null)
				words.add(i, hashTable[index].get(i).getWord());
		}
		return words;
	}
	/**
	 * Method to return all page numbers in indicated index for all words
	 * @return pageNums - array list of linked list of integers
	 */
	@Override
	public ArrayList<LinkedList<Integer>> getPageNumbers(int index) {
		ArrayList<LinkedList<Integer>> pageNums = new ArrayList<>();
		for(int i = 0; i < hashTable[index].size(); i++) {
			pageNums.add(hashTable[index].get(i).getList());
		}
		return pageNums;
	}
	/**
	 * Method to add word and line number to data structure
	 * @param word - String word to add
	 * @param lineNum - line number to add
	 */
	@Override 
	public void add(String word, int lineNum) {
		
		if(word.length() < 3)
			return;
		cde = new ConcordanceDataElement(word); // word gets added to object
		
		int index = Math.abs(cde.hashCode() % hashTable.length); // index in hashTable
		LinkedList<ConcordanceDataElement> elementsInIndex = hashTable[index]; //create LinkedList of cde's in index of 
																				//hashTable to loop thru and check pg num	
		
		if(!getWords(index).contains(word)) {
			
				cde.addPage(lineNum);
				Collections.sort(cde.getList());
				hashTable[index].add(cde);
				
		}else if(getWords(index).contains(word))
			for(int i = 0; i < elementsInIndex.size(); i++) {
				
				if(elementsInIndex.get(i).getWord().equals(cde.getWord())) {
					
					elementsInIndex.get(i).addPage(lineNum);
				}
			}
	}
	/**
	 * Method to display the Concordance, word and page numbers
	 * @return showConcordance - array list of Strings
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> showConcordance = new ArrayList<>();
		String stringToTrim;
		
		for(int i = 0; i < hashTable.length; i++) {
			for(int j = 0; j < hashTable[i].size();j++){	
				
				stringToTrim = hashTable[i].get(j).toString();
				stringToTrim=stringToTrim.replace("[", "");
				stringToTrim=stringToTrim.replace("]", "");
				showConcordance.add(stringToTrim + "\n");
				Collections.sort(showConcordance);
			}
		}
		return showConcordance;
	}
}
