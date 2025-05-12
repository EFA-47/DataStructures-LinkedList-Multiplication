public class BinarySearchTree
{
    Node root;
    
    // Node structure containing the subtrees
	static class Node
	{
		// Your code here
		Node right;
		Node left;
		int item;
		int height;
		public Node(int value) {
			item=value;
			left=null;
			right=null;
			height=0;
		}

	};

    // Constructor
    public BinarySearchTree()
    {
        // Your code here
        root=null;
    }

    // Insert new item into the binary tree
    public void insert(int data)
    {
        // Your code here
       root=insterting(root, data);
    }
    
    public Node insterting(Node root, int data) {
    	if(root==null) {
    		root=new Node(data);
    		return root;
    	}else if(root.item>data) {
    		root.left=insterting(root.left, data);
    	}else if(root.item<data) {
    		root.right=insterting(root.right, data);
    	}return root;
    	
    }

    // Check if the tree is balanced or not
    public boolean isBalanced()
    {
        // Your code here
        return balancing(root);
    }
    
    public boolean balancing(Node root) {
    	int a=0;
    	a=getHeight(root);
    	if(a<1&&a>-1) {
    		return true;
    	}return false;
    }
    public int getHeight(Node root) {
    	int left=0;
    	int right=0;
    	if(root.left!=null) {
    		left=getHeight(root.left)+1;
    	}
    	if(root.right!=null) {
    		right=getHeight(root.right)+1;
    	}
    	
    	return left-right;
    }
	
	// Remove an item from the tree
	public void remove(int item)
	{
		// Your code here
		
			root=deleting(root,item);
	}
	
	public Node deleting(Node root, int item) {

		if(item==root.item) {
			root.right=null;
			root.left=null;
			root=null;
		}else if(item<root.item) {
			if(root.left!=null) {
				root.left=deleting(root.left, item);
			}
			
		}else if(item>root.item) {
			if(root.right!=null) {
				root.right=deleting(root.right, item);
			}
			
		}return root;
	}
	
	// Compare two trees. Return true if both trees are same
	public boolean compareTo(BinarySearchTree tree)
	{
		// Your code here
		
		return comparing(root, tree.root);
	}
	
	public boolean comparing(Node first, Node second) {
		
		if(first==null&&second==null) {
			return true;
		}else if (first!=null&&second!=null) {
			
			if(first.item==second.item) {
				
				return comparing(first.left, second.left)&&comparing(first.right, second.right);	
			}
		}return false;
	}
	
	// Given function to print the tree
	public void printInOrder(Node node)
	{
		if (node != null)
		{
			printInOrder(node.left);
			System.out.print(node.item + " ");
			printInOrder(node.right);
		}
    }
}
