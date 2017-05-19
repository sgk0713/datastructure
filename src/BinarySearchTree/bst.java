package BinarySearchTree;


public class bst {
   public static void main(String[] args){
	   bst bst = new bst();
	   bst.put(50, "50");
	   bst.put(20, "20");
	   bst.put(70, "70");
	   bst.put(10, "10");
	   bst.put(30, "30");
	   bst.put(25, "25");
	   bst.put(21, "21");
	   bst.put(27, "27");
	   bst.put(60, "60");
	   bst.put(90, "90");
	   bst.put(100, "100");
	   bst.inOrder(bst.root);
	   System.out.println("remove : "+ bst.remove(70));
	   System.out.println("remove : "+ bst.remove(25));
	   System.out.println("remove : "+ bst.remove(30));
	   System.out.println("remove : "+ bst.remove(50));
	   System.out.println("remove : "+ bst.remove(20));
	   System.out.println("remove : "+ bst.remove(10));
	   System.out.println("remove : "+ bst.remove(21));
	   System.out.println("remove : "+ bst.remove(27));
	   System.out.println("remove : "+ bst.remove(60));
	   System.out.println("remove : "+ bst.remove(90));
	   System.out.println("remove : "+ bst.remove(100));
	   bst.inOrder(bst.root);
	   
   }
   
   private class Node{
	   int key;
	   String data;
	   Node leftChild;
	   Node rightChild;
	   public Node(int key, String data){
		   this.key = key;
		   this.data = data;
	   }
   }
   Node root;
   
   private Node treeSearch(Node p, int key){
	   Node point = p;
	   
	   while(point.key != key){
		   if(key < point.key){
			   point = point.leftChild;
		   }else{
			   point = point.rightChild;
		   }if(point == null) return null;
	   }
	   return point;
   }
   
   public String get(int key){
	   Node p = treeSearch(root, key);
	   return key+" has the data, "+p.data;
   }
   
   public void put(int key, String data){
	   Node point = root;
	   Node parent = root;
	   Node newNode = new Node(key, data);
	   if(root == null) root = newNode;
	   else{
		   Node result = treeSearch(root, key);
		   if(result != null){
			   result.data = data;
			   System.out.println("data is replaced");
		   }else{
			   while(point != null){
				   if(key<point.key){
					   parent = point;
					   point = parent.leftChild;
					   if(point == null){
						   parent.leftChild = newNode;
						   return;
					   }
				   }else{
					   parent = point;
					   point = parent.rightChild;
					   if(point == null){
						   parent.rightChild = newNode;
						   return;
					   }
				   }
			   }
		   }
	   }
   }
   
   public void inOrder(Node p){
	   if(p != null){
		   inOrder(p.leftChild);
		   System.out.println(p.key);
		   inOrder(p.rightChild);
		   return;
	   }
   }
   
   public String remove(int key){
	   Node p = treeSearch(root, key);
	   if(p == null) return "the key doesn't exist";
	   else{
		   Node point = root;
		   Node parent = point;
		   boolean isLeft = true;
		   while(point.key != key){
			   if(key < point.key){
				   parent = point;
				   point = parent.leftChild;
				   isLeft = true;
			   }else{
				   parent = point;
				   point = parent.rightChild;
				   isLeft = false;
			   }
		   }
		   
		   if(point.leftChild == null && point.rightChild == null){
			   if(point == root) root = null;
			   else if(isLeft) parent.leftChild = null;
			   else parent.rightChild = null;
			   return point.data;
		   }else if(point.leftChild == null || point.rightChild == null){
			   if(point.leftChild == null){
				   if(point == root) root = point.rightChild;
				   else if(isLeft) parent.leftChild = point.rightChild;
				   else parent.rightChild = point.rightChild;
				   return point.data;
			   }else{
				   if(point == root) root = point.leftChild;
				   else if(isLeft) parent.leftChild = point.leftChild;
				   else parent.rightChild = point.leftChild;
				   return point.data;
			   }
		   }else{
			   Node replace = point.rightChild;
			   Node replaceParent = point;
			   while(replace.leftChild != null){
				   replaceParent = replace;
				   replace = replaceParent.leftChild;
			   }
			   if(point == root){
				   root = replace;
				   replace.leftChild = point.leftChild;
				   if(replaceParent != point){
					   replaceParent.leftChild = replace.rightChild;
					   replace.rightChild = point.rightChild;
				   }
				   return point.data;
			   }else if(isLeft){
				   parent.leftChild = replace;
				   replace.leftChild = point.leftChild;
				   if(replaceParent != point){
					   replaceParent.leftChild = replace.rightChild;
					   replace.rightChild = point.rightChild;
				   }
				   return point.data;
			   }else{
				   parent.rightChild = replace;
				   replace.leftChild = point.leftChild;
				   if(replaceParent != point){
					   replaceParent.leftChild = replace.rightChild;
					   replace.rightChild = point.rightChild;
				   }
				   return point.data;
			   }
			  
		   }
	   }
   }
	   
	   
	 

   
   
   
   
   /*private class Node{
	   int key;
	   String data = null;
	   Node rightChild = null;
	   Node leftChild = null;
	   
	   public Node(int key, String data){
		   this.key = key;
		   this.data = data;
	   }
   }
   
   private Node treeSearch(Node p, int key){
	   Node point = p;
	   while(key != point.key){
		   if(key < point.key){
			   point = point.leftChild;
		   }else if(key > point.key){
			   point = point.rightChild;
		   }if(point==null){
			   return null;
		   }
	   }
	   return point;
   }

   Node root;
   public void put(int key, String data){
	   Node newNode = new Node(key, data);
	   if(root == null) root = newNode;
	   else{
		   Node point = treeSearch(root, key);
		   if(point != null){
			   point.data = data;
			   System.out.println("the data is replaced");
		   }else {
			   Node focusnode = root;
			   Node parent;
			   while(true){
				   if(key<focusnode.key){
					   parent = focusnode;
					   focusnode = parent.leftChild;
					   if(focusnode == null){
						   parent.leftChild = newNode;
						   return;
					   }
				   }else if(key > focusnode.key){
					   parent = focusnode;
					   focusnode = parent.rightChild;
					   if(focusnode == null){
						   parent.rightChild = newNode;
						   return;
					   }
				   }
			   }
		   }
	   }
   }
   
   public void inOrder(Node p){
	   if(p != null){
		   inOrder(p.leftChild);
		   System.out.println(p.key);
		   inOrder(p.rightChild);
	   }
   }
   
   
   public String get(int key){
	   Node point = treeSearch(root, key);
	   if(point != null) return "key you inserted = "+key+", data = "+point.data;
	   else return "key you inserted = "+key+", data = "+null;
   }
   
   public String remove(int key){
	   Node point = root;
	   Node parent = root;
	   boolean isLeft = true;
	   while(key != point.key){
		   if(key < point.key){
			   parent = point;
			   point = parent.leftChild;
			   isLeft = true;
		   }else if(key > point.key){
			   parent = point;
			   point = parent.rightChild;
			   isLeft = false;
		   }if(point == null) return "the key, "+key+", doens't exist";
	   }
	   
	   if(point.leftChild == null && point.rightChild == null){
		   if(point == root) root = null;
		   else if(isLeft) parent.leftChild = null;
		   else parent.rightChild = null;
		   return point.data;
	   }else if(point.leftChild == null|| point.rightChild == null){
		   if(point.leftChild == null){
			   if(point == root) root = point.rightChild;
			   else if(isLeft) parent.leftChild = point.rightChild;
			   else parent.rightChild = point.rightChild;
			   return point.data;
		   }if(point.rightChild == null){
			   if(point == root) root = point.leftChild;
			   if(isLeft) parent.leftChild = point.leftChild;
			   else parent.rightChild = point.leftChild;
			   return point.data;
		   }
	   }else{
		   Node replace = point.rightChild;
		   Node replaceParent = point;
		   while(replace.leftChild!=null){
			   replaceParent = replace;
			   replace = replace.leftChild;		   
		   }
		   if(point == root){
			   if(replaceParent != point){
				   replaceParent.leftChild = replace.rightChild;
				   replace.rightChild = root.rightChild;
			   }
			   replace.leftChild = root.leftChild;
			   root = replace;
		   }else{
			   if(replaceParent != point){
				   replaceParent.leftChild = replace.rightChild;
			   	   replace.rightChild = point.rightChild;
			   }
			   replace.leftChild = point.leftChild;
			   if(isLeft) parent.leftChild = replace;
			   else parent.rightChild = replace;
		   }
		   return point.data;		   
	   }
	return null;
   }   */
}