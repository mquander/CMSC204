/**
 * Class to create a tree node
 * @author
 *
 * @param <T>
 */
public class TreeNode<T> {
	/**
	 * Class fields
	 */
	protected T nodeData;
	protected TreeNode<T> leftChild, rightChild;
	/**
	 * Constructor to create TreeNode object
	 * @param data
	 */
	public TreeNode(T data) {
		this.nodeData = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	/**
	 * Constructor to create copy of TreeNode object
	 * @param node
	 */
	public TreeNode(TreeNode<T> node) {
		new TreeNode<T>(node);
	}
	/**
	 * Method to return data of tree node
	 * @return
	 */
	public T getData() {
		return nodeData;
	}
	
}
