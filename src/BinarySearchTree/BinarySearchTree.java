package BinarySearchTree;

	
public class BinarySearchTree {
	public static void main(String[] args){
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.put(50, "root");				//			   50
		bst.put(40, "root left");			//		40			60
		bst.put(30, "root left left");		//	30	    45	  55   	61
		bst.put(45, "root left right");		//		 41 
		bst.put(41, "root left right left");//        42
		bst.put(42, "root left right left right");//		
		bst.put(60, "root right");			//
		bst.put(55, "root right left");
		bst.put(61, "root right right");
		
		
		System.out.println("inorder go====");
		bst.inOrderTraversal(bst.root);
		System.out.println();
		System.out.println("remove 50 go======");
		
		System.out.println(bst.remove(50));
		System.out.println(bst.remove(30));
		System.out.println(bst.remove(42));
		System.out.println(bst.remove(61));
		System.out.println(bst.remove(55));
		
		

		System.out.println("inorder go=======");
		bst.inOrderTraversal(bst.root);
		System.out.println();
		//bst.inOrderTraversal(bst.root);
		
	}
	
	
	
	
	Node root;
	public void put(int key, String value){
			
			if(root == null){
				Node newNode = new Node(key, value);
				root = newNode;
			}else if(TreeSearch(root, key) != null){
					String old = TreeSearch(root, key).value;
					TreeSearch(root, key).value = value;
					System.out.println("The value is switched : "+ old);
			}else if(TreeSearch(root, key) == null){
				Node newNode = new Node(key, value);				
				Node point = root;
				Node parent;
				while(true){
					parent = point;
					if(key < point.key){
						point = point.leftChild;
						if(point == null){
							parent.leftChild = newNode;
							return;
						}
					}else if(key > point.key){
						point = point.rightChild;
						if(point == null){
							parent.rightChild = newNode;
							return;
						}
					}
				}
			}
		
	}
	
	public String remove(int key){
		
		Node point = root;
		Node parent = root;
		
		boolean isItALeftChild = true;
		
		while(point.key != key){
			
			parent = point;
			
			if(key < point.key){
				isItALeftChild = true;	
				point = point.leftChild;
			}else{
				isItALeftChild = false;
				point = point.rightChild;
			}		
			if(point == null){
				return "The Key Does NOT exist";
			}
		}
		if(point.leftChild == null && point.rightChild == null){
			if(point == root){
				root = null;
			}else if(isItALeftChild){
				parent.leftChild = null;
			}else parent.rightChild = null;
			return point.value;
			
		}else if(point.rightChild == null){
			if(point == root){
				root = point.leftChild;
			}else if(isItALeftChild){
				parent.leftChild = point.leftChild;
			}else parent.rightChild = point.leftChild;
			return point.value;
			
		}else if(point.leftChild == null){
			if(point == root){
				root = point.rightChild;
			}else if(isItALeftChild){
				parent.leftChild = point.rightChild;
			}else parent.rightChild = point.rightChild;
			return point.value;
		}else{
			Node replacement = getReplacementNode(point);
			
			if(point == root)
				root = replacement;
			else if(isItALeftChild)
				parent.leftChild = replacement;
			else
				parent.rightChild = replacement;
			
			replacement.leftChild = point.leftChild;
		}
		
		return point.value;
	}
	
	private Node getReplacementNode(Node n){
		Node replaceParent = n;
		Node replace = n;
		
		Node focusNode = n.rightChild;
		
		while(focusNode != null){
			replaceParent = replace;
			replace = focusNode;
			focusNode = focusNode.leftChild;
		}
		
		if(replace != n.rightChild){
			replaceParent.leftChild = replace.rightChild;
			replace.rightChild = n.rightChild;
		}
		return replace;
	}
	
	
	
	
	public void inOrderTraversal(Node p){
 		if(p != null){
			inOrderTraversal(p.leftChild);
			System.out.println(p.key);
			inOrderTraversal(p.rightChild);
		}
	}
	
	public void preOrderTraversal(Node p){
		if(p != null){
			System.out.println(p.key);
			preOrderTraversal(p.leftChild);
			preOrderTraversal(p.rightChild);
		}
	}
	
	public void postOrderTraversal(Node p){
		if(p != null){
			postOrderTraversal(p.leftChild);
			postOrderTraversal(p.rightChild);
			System.out.println(p.key);
		}
	}
	
	private Node TreeSearch(Node p, int key){
		Node point = p;
		while(point.key != key){
			if(key < point.key){
				point = point.leftChild;
			}else if(key > point.key){
				point = point.rightChild;
			}if(point == null){
				return null;
			}
		}
		return point;
	}
	
	
	
	
	public String get(int key){
		Node p = TreeSearch(root, key);
		return "The key "+key+ " has a value of \"" + p.value+ "\"";
		
	}
	
	
	
	class Node{
		int key;
		String value;
		
		Node leftChild;
		Node rightChild;
		
		Node(int key, String value){
			this.key = key;
			this.value = value;
		}
	}
	
}
