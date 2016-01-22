
public class BinaryTree<E>{
	
	private BinaryTreenode<E> root; //reference to root of tree
	private BinaryTreenode<E> curr; //current node in navigation
	
	//construct empty tree with null root
	public BinaryTree(){
		this.root = new BinaryTreenode<E>(null);
	}
	
	//construct tree with data stored as root	
	public BinaryTree(E data){
		this.root.setData(data);
	}
	
	//move current pointer to root of tree to begin navigation
	public void start(){
		this.curr = this.root;
	}
	
	//return data in current node, null if no current node
	//throw InvalidBinaryTreeOpException if no current node
	public E getCurrent() throws InvalidBinaryTreeOpException{
		try{
			if(curr == null){
				throw new InvalidBinaryTreeOpException();
			}
			return curr.getData();
		}catch(InvalidBinaryTreeOpException e){
			System.out.println("There is no current node.");
		}
		return null;
	}
	
	//move pointer to left child of current node in navigation
	//throw InvalidBinaryTreeOpException if no left child
	public void goLeft() throws InvalidBinaryTreeOpException{
		BinaryTreenode<E> leftChild = curr.getLeft();
		//leftChild null if no left child
		try{
			if(leftChild == null){
				throw new InvalidBinaryTreeOpException();
			}
			curr = curr.getLeft();
		}catch(InvalidBinaryTreeOpException e){
			System.out.println("There is no left child");
		}
	}
	
	//move pointer to right child of current node in navigation
	//throw InvalidBinaryTreeOpException if no right child
	public void goRight() throws InvalidBinaryTreeOpException{
		BinaryTreenode<E> rightChild = curr.getRight();
		try{
			if(rightChild == null){
				throw new InvalidBinaryTreeOpException();
			}
			curr = curr.getRight();
		}catch(InvalidBinaryTreeOpException e){
			System.out.println("There is no right child");
		}
	}
	
	//checks if the current node in navigation is a leaf
	//return true if no children
	public boolean isLeaf(){
		//leaf node if both children are null
		//changfed from != to ==
		if(curr.getLeft() == null && curr.getRight() == null){
			return true;
		}
		//node has at least one child
		return false;
	}
	
	//change data held by current node in navigation
	public void changeCurrent(E data){
		curr.setData(data);
	}
	
	//add node with specified data as right child of current node in navigation
	//throws InvalidBinaryTreeOpException if current node already has right child
	public void addRightChild(E data) throws InvalidBinaryTreeOpException{
		//check if current node already has right child
		try{
			if (curr.getRight() != null){
				throw new InvalidBinaryTreeOpException();
			}
			curr.setRight(data);
		}catch(InvalidBinaryTreeOpException e){
			System.out.println("Current node already has a right child");
		}
	}
	
	//add node with specified data as left child of current node in navigation
	//throws InvalidBinaryTreeOpException if current node already has left child
	public void addLeftChild(E data) throws InvalidBinaryTreeOpException{
		//check if current node already has right child
		try{
			if (curr.getLeft() != null){
				throw new InvalidBinaryTreeOpException();
			}
			curr.setLeft(data);
		}catch(InvalidBinaryTreeOpException e){
			System.out.println("Current node already has a left child");
		}
	}
	
	//pre-order print the tree starting from the root. Each level of tree
	//incremented by three spaces
	//parent, left, right
	public void print(){
		PreorderPrint(root, 0);//pass root to helper method
		
	}
	
	private void PreorderPrint(BinaryTreenode<E> print, int level){
		
		if (print == null){
			return;
		}
		
		for(int i = 0; i < level; i++){
			//get correct amount of spaces for each level
			System.out.print("   ");
		}
		System.out.println(print.getData());
		level ++;
		PreorderPrint(print.getLeft(), level);
		PreorderPrint(print.getRight(), level);
	}
}
