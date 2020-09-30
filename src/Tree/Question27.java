package Tree;

public class Question27 {
	
	//由于lastNode需要每次都指向当前节点前驱，但是直接作为参数传递属于
	
	private TreeNode lastNode = null;
	
	/**
	 * 将二叉搜索树转换为排序的双向链表
	 * 
	 * 因为BST左>根>右，所以转换为双向链表的时候，
	 * 左节点指向前驱，右节点指向后继，这样就保持了双向链表的排序
	 * @param root
	 * @return
	 */
	public TreeNode ConvertBSTtoList(TreeNode root) {
		
		ConvertBST(root);
		
		//lastNode指向双向链表得尾节点，所以必须要将其移到头
		while(lastNode != null && lastNode.left != null) {
			lastNode = lastNode.left;
		}
		
		return lastNode;
	}
	
	/**
	 * lastNode始终是指向当前节点的前驱节点
	 * @param root
	 * @param lastNode
	 */
	public void ConvertBST(TreeNode root) {
		if(root == null)
			return;
		if(root.left != null)
			ConvertBST(root.left);
		
		//当前节点的左指针指向前驱，右指针指向后继
		root.left = lastNode;
		if(lastNode != null)
			lastNode.right = root;
		lastNode = root;
		
		if(root.right != null)
			ConvertBST(root.right);
	}
	
	public void printTreeList(TreeNode head) {
		TreeNode p = head;
		while(p != null) {
			System.out.print(p.val + " ");
			p = p.right;
		}
	}
	
	public static void main(String[] args) {
		int[] A = {10,6,4,0,0,8,0,0,14,12,0,0,16,0,0};
//		int[] A = {8,7,5,0,0,0,0};//只有左子树用例
//		int[] A = {8,0,9,0,12,0,0};//只有右子树用例
//		int[] A = {8,0,0};//单节点用例
		TreeNode root = new Question6().createBintree(A);
		Question27 test = new Question27();
		TreeNode head = test.ConvertBSTtoList(root);
		test.printTreeList(head);
	}
	

}
