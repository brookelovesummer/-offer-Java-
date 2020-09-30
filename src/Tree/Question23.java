package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Question23 {
	
	/**
	 * 按层次遍历二叉树
	 * @param root
	 */
	public void printTreeBFS(TreeNode root) {
		if(root == null)
			return;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.val + " ");
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
		}
	}

	public static void main(String[] args) {
		Question6 help = new Question6();
		Question23 test = new Question23();
		int[] arr = {8,8,9,0,0,2,4,0,0,7,0,0,7,0,0};
		TreeNode root = help.createBintree(arr);
		test.printTreeBFS(root);
	}
}
