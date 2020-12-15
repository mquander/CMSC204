import java.util.ArrayList;
/**
 * Class to create MorseCodeTree data structure
 * @author Matt Quander
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	/**
	 * Class fields
	 */
	private TreeNode<String> root = null;
	private String letter;
	
	/**
	 * Constructor to build the tree
	 */
	public MorseCodeTree() {
		buildTree();
	}
	/**
	 * Method to return letter
	 * @return letter
	 */
	private String getLetter() {
		return letter;
	}
	/**
	 * Method to set letter
	 * @param letter
	 */
	private void setLetter(String letter) {
		this.letter = letter;
	}
	/**
	 * Method to return root	
	 */
	@Override
	public TreeNode<String> getRoot() {
		
		return this.root;
	}
	/**
	 * Method to set root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
		
	}
	/**
	 * Method to insert a letter based on the code
	 */
	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		
		addNode(root, code, result);
		return this;
	}
	/**
	 * Method to add a node (with a letter) to the tree
	 */
	@Override // check logic of this method, see printed values below
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		if(code.length() == 1) {
			TreeNode<String> leaf = new TreeNode<String>(letter);
			if(code.charAt(0)  == '.') 
				root.leftChild = leaf; 
			else if(code.charAt(0) == '-')
				root.rightChild = leaf; 
				
			return;
		}
		else if(code.length() > 1) {
			if(code.charAt(0)  == '.')
				addNode(root.leftChild, code.substring(1), letter);
			else if(code.charAt(0) == '-')
				addNode(root.rightChild, code.substring(1), letter);
		}
	}
	/**
	 * Method to call recursive fetchNode method
	 * @return String English letter
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}
	/**
	 * Recursive method to get letter based on Morse Code
	 * @return String English letter
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		
		if(code.length() == 1) {
			
			if(code.equals(".") ) {
				setLetter(root.leftChild.getData()); 
			}
			else if(code.equals("-")){
				setLetter(root.rightChild.getData()); 
			}
		}
		
		else if(code.length() > 1) {
			
			if(code.substring(0, 1).equals(".")){
				fetchNode(root.leftChild, code.substring(1));
			}
			else if(code.substring(0, 1).equals("-")){
				fetchNode(root.rightChild, code.substring(1));
			}
		}
		return getLetter();
	}
	/**
	 * Unsupported method
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		
		throw new UnsupportedOperationException("Unsupported Operation");
		
		//return null;
	}
	/**
	 * Unsupported method
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		
		throw new UnsupportedOperationException("Unsupported Operation");
		
		//return null;
	}
	/**
	 * Method to build the tree
	 */
	@Override
	public void buildTree() {
		
		setRoot(new TreeNode<String>(""));
		
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
		
	}
	/**
	 * Method to return array list of tree nodes
	 */
	@Override
	public ArrayList<String> toArrayList() {
		
		ArrayList<String> arrayList = new ArrayList<>();
		LNRoutputTraversal(root, arrayList);
		return arrayList;
	}
	/**
	 * Method to traverse tree and add nodes to array list
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		
		if(root == null)
			return;
		else {
			LNRoutputTraversal(root.leftChild, list);
			list.add(root.getData());
			LNRoutputTraversal(root.rightChild, list);
		}
	}

}
