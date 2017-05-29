package midTermTest;

public class BST_T {
	
	
	Node root;
	
	private class Node{
		int key;
		String data;
		Node leftChild;
		Node rightChild;
		Node(int key, String data){
			this.key = key;
			this.data = data;
		}
	}
	
	public Node treeSearch(Node n, int key){
		Node point = n;
		while(point.key != key){
			if(key<point.key) point = point.leftChild;
			else if(key>point.key) point = point.rightChild;
			if(point== null) break;
		}
		return point;
		
	}
	
	public void put(int key, String data){
		Node newNode = new Node(key, data);
		if(root == null) root = newNode;
		else{
			Node p = treeSearch(root, key);
			if(p != null){
				p.data = newNode.data;
				System.out.println("The data is replaced");
			}else{
				Node point = root;
				Node parent;
				while(point != null){
					if(key<point.key){
						parent = point;
						point = parent.leftChild;
						if(point == null){
							parent.leftChild = newNode;
							return;
						}
					}else if(key>point.key){
						parent = point;
						point = parent.rightChild;
						if(point == null){
							parent.rightChild = newNode;
							return;
						}
					}
				}
				
				System.out.println("The data is inserted");
			}
		}
	}
	
	public String get(int key){
		if(root == null) return null;
		else return treeSearch(root, key).data;
	}
	
	
	public String remove(int key){
		if(treeSearch(root, key) == null) return "The key does NOT exist"; 
		else{
			Node point = root;
			Node parent = point;
			boolean isLeft = true;
			while(point.key != key){
				if(key<point.key){
					parent = point;
					point = parent.leftChild;
					isLeft = true;
				}else if(key> point.key){
					parent = point;
					point = parent.rightChild;
					isLeft = false;
				}
			}
			if(point.leftChild == null && point.rightChild == null){
				if(point == root) root = null;
				else if(isLeft)parent.leftChild = null;
				else if(!isLeft) parent.rightChild = null;
				return point.data;
			}else if(point.leftChild == null || point.rightChild == null){
				if(point == root){
					if(point.leftChild == null) root = point.rightChild;
					else if(point.rightChild == null) root = point.leftChild;
				}else if(isLeft){
					if(point.leftChild == null) parent.leftChild = point.rightChild;
					else if(point.rightChild == null) parent.leftChild = point.leftChild;
				}else if(!isLeft){
					if(point.leftChild == null) parent.rightChild= point.rightChild;
					else if(point.rightChild == null) parent.rightChild = point.leftChild;
				}return point.data;
			}
			else if(point.leftChild != null && point.rightChild != null){
				Node replace = point.rightChild;
				Node replaceParent = point;
				while(replace.leftChild != null){
					replaceParent = replace;
					replace = replace.leftChild;
				}
				
				if(point == root){
					root = replace;
					replace.leftChild = point.leftChild;
					replace.rightChild = point.rightChild;
					if(replaceParent != point){
						replaceParent.leftChild = replace.rightChild;
					}
				}else if(replaceParent == point){
					replace.leftChild = point.leftChild;					
					if(isLeft)parent.leftChild = replace;
					else parent.rightChild = replace;
				}else{
					replaceParent.leftChild = replace.rightChild;
					replace.leftChild = point.leftChild;
					replace.rightChild = point.rightChild;
					if(isLeft) parent.leftChild = replace;
					else parent.rightChild = replace;
				}return point.data;
			}
		}
		return null;
	}
	
	
	
	public String inOrder(Node n){
		if(n != null){
			inOrder(n.leftChild);
			System.out.println(n.data);
			inOrder(n.rightChild);
		}
		return null;
	}
}
