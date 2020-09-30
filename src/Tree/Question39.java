package Tree;

public class Question39 {
	
	/**
	 * ��һ�ö����������
	 * @param root
	 * @return
	 */
	public int getTreeLength(TreeNode root) {
		if(root == null)
			return 0;		
		return Math.max(getTreeLength(root.left), getTreeLength(root.right))+1;
	}
	
	/**
	 * �ж�һ�ö������ǲ���ƽ�������
	 * ����������Ȳ���û�г���1
	 * @param root
	 * @return
	 */
	public boolean isBalanceTree(TreeNode root) {
		testnode node = new testnode();
		getTreeLength(root,node);
		return node.flag;
	}
	
	public int getTreeLength(TreeNode root, boolean flag) {
		if(root == null)
			return 0;	
		int L = getTreeLength(root.left,flag);
		int R = getTreeLength(root.right,flag);
		if(Math.abs(L - R) > 1)
			flag = false;
		return Math.max(L,R)+1;
	}
	
	public int getTreeLength(TreeNode root, testnode node) {
		if(root == null)
			return 0;	
		int L = getTreeLength(root.left,node);
		int R = getTreeLength(root.right,node);
		if(Math.abs(L - R) > 1)
			node.flag = false;
		return Math.max(L,R)+1;
	}

	class testnode{
		public boolean flag = true;
	}
}


