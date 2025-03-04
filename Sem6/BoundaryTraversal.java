
class TreeNode
{
    int val;
    TreeNode left , right;
    public TreeNode(int val)
    {
        this.val=val;
        this.left=this.right=null;
    }
}


public class Main
{
    private static void printleftboundary(TreeNode root)
    {
        if(root==null|| root.left==null && root.right==null) // To avoid NULL pointers and leaf node
        {
            return ;
        }
        System.out.print(root.val+ " ");// print the value after checking for null and leaf node
        
        //traversal. Keep travelling left, if there is no left but there is a right, go right.
        // But priority to left
        if(root.left!=null)
        {
            printleftboundary(root.left);
        }
        else
        {
            printleftboundary(root.right);
        }
        
    }
    
    private static void printleaves(TreeNode root)
    {
        if(root==null)// To Avoid null errors and base case
        {
            return;
        }
        if(root.left==null && root.right==null) //If its a leaf node print
        {
            System.out.print(root.val+" ");
            return ;
        }
        //to recursively traverse the whole tree, with priority to left first
        printleaves(root.left); 
        printleaves(root.right);
        
        
    }
    
    private static void printrightboundary(TreeNode root)
    {
        
        if(root==null|| root.left==null && root.right==null)// To avoid NULL pointers and leaf node
        {
            return ;
        }
        
        //traversal. Keep travelling right, if there is no right but there is a left, go left.
        // But priority to right
        if(root.right!=null)
        {
            printleftboundary(root.right);
        }
        else
        {
            printleftboundary(root.left);
        }
        System.out.print(root.val+" ");// print the value in the end, after all traversals. Thus traversing in //revserse manner
    }
    
    public static void boundaryTraversal(TreeNode root)
    {
        if(root==null)
        {
            return ;
        }
        System.out.print(root.val + " ");
        printleftboundary(root.left); //Calculate Left Boundary
        printleaves(root);            //Calculate leaf Nodes
        printrightboundary(root.right);//Calculate Right Boundary

    }
	public static void main(String[] args) {
	    
	    //Tree Generation
	    TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);            
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);        
        boundaryTraversal(root);

	    
	}
}