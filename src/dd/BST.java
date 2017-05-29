package dd;
public class BST {
	private Node root;
	private Node parent;
	
	private class Node{
		private int key;
		private Node left_child;
		private Node right_child;
		private Node parent;
		Node(int key){
			this.key = key;
		}
	}
	
	public void insert(int key){
		if(this.search(key) != null){
			System.out.println(key + " is already in the tree");
			return;
		}else{
			Node newNode = new Node(key);
			if(root == null) root = newNode;
			else{
				Node point=root;
				while(point != null){
					if(key<point.key){
						parent = point;
						point = parent.left_child;
						if(point==null){
							parent.left_child = newNode;
							return;
						}
					}else{
						parent = point;
						point = parent.right_child;
						if(point==null){
							parent.right_child = newNode;
							return;
						}
					}
				}
			}
			
		}
		
		//////////////////////////////////// todo
		

		
		////////////////////////////////////
		
	}
	public void delete(int key){
		//////////////////////////////////// todo
		if(search(key)==null) return;
		else{
			Node point = root;
			Node parent = null;
			boolean isLeft = true;
			while(point.key != key){
				if(key< point.key){
					parent = point;
					point = point.left_child;
					isLeft = true;
				}else if(key> point.key){
					parent = point;
					point = point.right_child;
					isLeft = false;
				}
			}
			if(point.left_child == null && point.right_child == null){
				if(point == root) root = null;
				else if(isLeft) parent.left_child = null;
				else if(!isLeft) parent.right_child = null;
			}else if(point.left_child == null || point.right_child == null){
				if(point == root){
					if(point.left_child == null) root = root.right_child;
					else if(point.right_child == null) root = root.left_child;
				}else if(isLeft){
					if(point.left_child == null) parent.left_child = point.right_child;
					else if(point.right_child == null) parent.left_child = point.left_child;
				}else if(!isLeft){
					if(point.left_child == null) parent.right_child = point.right_child;
					else if(point.right_child == null) parent.right_child = point.left_child;
				}
			}else{
				Node replace= point.right_child;
				Node replaceParent = point; 
				while(replace.left_child != null){
					replaceParent = replace;
					replace = replace.left_child;
				}
				
				if(point == root){
					root = replace;
					replace.left_child = point.left_child;
					if(replaceParent != point){
						replaceParent.left_child = replace.right_child;
						replace.right_child = point.right_child;
					}
				}else{
					replace.left_child = point.left_child;
					if(isLeft) parent.left_child = replace;
					else if(!isLeft) parent.right_child = replace;
					if(replaceParent != point){
						replaceParent.left_child = replace.right_child;
						replace.right_child = point.right_child;
					}
					 
				}
				
			}
			
		}
		
		
		////////////////////////////////////
	}

	public Node search(int key){
		////////////////////////////////////todo
		Node point = root;
		if(point != null){
			while(key != point.key){
				if(key < point.key){
					point = point.left_child;
							
				}else if(key >point.key){
					point = point.right_child;
				}if(point == null) return null;
			}
			return point;
		}else return null;
		
		
		////////////////////////////////////
		
	}
	public void printPreorder(Node node){
		////////////////////////////////////todo
		if(node != null){
			System.out.print(node.key+" ");
			printPreorder(node.left_child);
			printPreorder(node.right_child);
		}
		
		
		////////////////////////////////////
	}
	public void printInorder(Node node){
		
		if(node != null){
			printInorder(node.left_child);
			System.out.print(node.key+" ");
			printInorder(node.right_child);
		}
	}
	public void printPostorder(Node node){
		if(node != null){
			printPostorder(node.left_child);
			printPostorder(node.right_child);
			System.out.print(node.key+" ");
		}
	}
	public Node getRoot(){
		return root;
	}
}
