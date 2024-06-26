/**
 *A node class for the BST.
 * @author Telmen Enkhtuvshin
 */
class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

/**
 *Class for the BST.
 */
class BinarySearchTree{
	Node root;

	/**
	 *Inserts the node into the tree.
	 * @param value The integer value to be inserted into the BST.
	 */
	public void insert(int value){
		//tree is empty
		if(root == null){
			root = new Node(value);
			return;
		}else{
			Node current = root;
			Node parent = null;
	         
			while(true){
				parent = current;

				if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
			}//closing while
	      
		}//closing main if-else
	}

	/**
	 *A method which traverses the BST and prints out the nodes in preorder.
	 * @param root The root node of the BST.
	 */
	public void preOrderTraversal(Node root){
		//Preorder: Current, Left, Right
		if (root != null) {
			//Printing current value
			System.out.println(root.value + " ");
			//Traversing left subtree
			preOrderTraversal(root.left);
			//Traversing right subtree
			preOrderTraversal(root.right);
		}
	}
	/**
	 * A method which traverses the BST and prints out the nodes as inorder.
	 * @param root The root node of the BST.
	 */
	public void inOrderTraversal(Node root) {
		//Inorder: Left, Current, Right
		if (root != null) {
			//Traversing left subtree
			inOrderTraversal(root.left);
			//Printing current value
			System.out.print(root.value + " ");
			//Traversing right subtree
			inOrderTraversal(root.right);
		}
	}

	/**
	 * A method which traverses the BST and prints out the nodes as postorder.
	 * @param root The root node of the BST.
	 */
	public void postOrderTraversal(Node root) {
		//Postorder: Left, Right, Current
		if (root != null) {
			//Traversing left subtree
			postOrderTraversal(root.left);
			//Traversing right subtree
			postOrderTraversal(root.right);
			//Printing current value
			System.out.println(root.value + " ");
		}
	}

	/**
	 * A method to find the node in the tree with a specific value.
	 * @param root The root node of the BST.
	 * @param key The value to find in the BST
	 * @return Returns true if the node is found, or false if it is not found.
	 */
	public boolean find(Node root, int key){
		//If the current node is null, return false
		if (root == null){
			return false;
		}
		//If the current node is found, return true
		if (key == root.value){
			return true;
		}
		//If the key is less, traverse left
		if (key < root.value) {
			return find(root.left, key);
		}else {
			//If the key is larger, traverse right
			return find(root.right, key);
		}
	}


	/**
	 * A method to find the node in the tree with the smallest key.
	 * @param root The root node of the BST.
	 * @return The smallest value in the BST.
	 */
	public int getMin(Node root) {
		//Empty BST
		if (root == null){
			throw new IllegalArgumentException("The BST is empty.");
		}
		//Current node variable
		Node cur = root;
		//BST traversal
		while (cur.left != null) {
			cur = cur.left;
		}
		//Returning the smallest value
		return cur.value;
	}


	/**
	 * A method to find the node in the tree with the largest key.
	 * @param root The root node of the BST
	 * @return The largest value in the BST
	 */
	public int getMax(Node root){
		//Empty BST
		if (root == null){
			throw new IllegalArgumentException("The BST is empty.");
		}
		//Current node variable
		Node cur = root;
		//BST traversal
		while (cur.right != null) {
			cur = cur.right;
		}
		//Returning the largest value
		return cur.value;
	   }


	/**
	 * A delete method that deletes the desired key from the BST.
	 * @param root The root node of the BST.
	 * @param key The integer value of the key to be deleted.
	 * @return Returns the root node of the BST.
	 */
	public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	}



	public class TreeDemov1{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();
	           
	      
	   }  
	}
