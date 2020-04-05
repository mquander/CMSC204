import java.util.LinkedList;
/**
 * Class to create Concordance data element
 * @author Matt Quander
 *
 */
public class ConcordanceDataElement implements Comparable<ConcordanceDataElement>{
	/**
	 * Fields for each Concordance data element
	 */
	private String word;
	private LinkedList<Integer> list;
	/**
	 * Constructor to initialize object and set field values
	 * @param word - word added to Concordance data element
	 */
	public ConcordanceDataElement(String word) {
		this.word = word;
		list = new LinkedList<>();
	}
	/**
	 * Method to display String representation of each
	 * Concordance data element
	 * @return show
	 */
	public String toString() {
		String show = word + ": ";
		for(int i = 0; i < getList().size(); i++) {
			if(i < getList().size() - 1)
				show += getList().get(i) + ", ";
			else
				show += getList().get(i);
		}
						
		return show;
	}
	/**
	 * Method to return value of the word
	 * @return word
	 */
	public String getWord() {
		return word;
	}
	/**
	 * Method to return hashcode of word
	 * @return int value of hashcode
	 */
	@Override
	public int hashCode() {
		
		return word.hashCode();
	}
	/**
	 * Method to return the list of page numbers
	 * @return list
	 */
	public LinkedList<Integer> getList(){
		return list;
	}
	/**
	 * Method to add page number to list
	 * @param lineNum
	 */
	public void addPage(int lineNum) {
		if(!getList().contains((Integer)lineNum))
			getList().add((Integer)lineNum);
		
	}
	/**
	 * Method to compare Concordance data elements
	 * return true or false
	 */
	@Override
	public int compareTo(ConcordanceDataElement arg0) {
		
		if(this == (arg0))
			return 0;
		else
			return 1;
	}
}
