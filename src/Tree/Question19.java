package Tree;

import java.util.Stack;

public class Question19 {
	
	/**
	 * ǰ���������
	 * @param root
	 * @return
	 */
	public TreeNode getMirrorTree(TreeNode root) {

		if(root == null)
			return null;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		root.left = getMirrorTree(root.left);
		root.right = getMirrorTree(root.right);
		return root;
	}
	
	public void getMirrorTree_brooke(TreeNode root) {

		if(root == null)
			return ;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		getMirrorTree_brooke(root.left);
		getMirrorTree_brooke(root.right);
		return ;
	}
	
	/**
	 * �ǵݹ��(ǰ�����)
	 */
	public TreeNode getMirrorTree_Notrecurise(TreeNode root) {
		if(root != null) {
			Stack<TreeNode> help = new Stack<>(); 
			help.add(root);
			while(!help.isEmpty()) {
				TreeNode subroot = help.pop();
				TreeNode temp = subroot.left;
				subroot.left = subroot.right;
				subroot.right = temp;
				if(subroot.right != null)
					help.add(subroot.right);
				if(subroot.left != null)
					help.add(subroot.left);
			}
		}
		return root;
	}

	/**
	 * �����������
	 * @param root
	 * @return
	 */
	public TreeNode getMirrorTree1(TreeNode root) {
		
		if(root == null)
			return null;
		root.left = getMirrorTree(root.left);
		root.right = getMirrorTree(root.right);
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		return root;
	}

	public static void main(String[] args) {
		Question6 help = new Question6();
		Question19 test = new Question19();
		int[] arr = {8,8,9,0,0,2,4,0,0,7,0,0,7,0,0};
//		int[] arr = {8,7,9,0,0,0,0};//ֻ������������
//		int[] arr = {8,0,0};//ֻ������������
		TreeNode root = help.createBintree(arr);
		System.out.println("ԭ��������");
		help.printTree(root);
		System.out.println();

		root = test.getMirrorTree(root);
		System.out.println("���������");
		help.printTree(root);	
		System.out.println();
		
		root = test.getMirrorTree1(root);
		System.out.println("ԭ��������");
		help.printTree(root);
		System.out.println();
		
		test.getMirrorTree_Notrecurise(root);
		System.out.println("���������");
		help.printTree(root);
		
	}
}
