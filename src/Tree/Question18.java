package Tree;

public class Question18 {
	
	/**
	 * �ж�B�ṹ�ǲ���A������
	 * ���õݹ鷽����һ���ݹ����ڱ�����A��һ���ݹ������ж�B�ǲ���A������
	 * @param rootA
	 * @param rootB
	 * @return
	 */
	public boolean isSubTree(TreeNode rootA, TreeNode rootB) {
		if(rootA == null || rootB == null)
			return false;
		
		boolean res = false;

		res = DoesisSubTree(rootA,rootB);
		if(!res)
			res = isSubTree(rootA.left, rootB);
		if(!res)
			res = isSubTree(rootA.right, rootB);
		return res;
	}

	private boolean DoesisSubTree(TreeNode rootA, TreeNode rootB) {
		if(rootB == null)
			return true;
		if(rootA == null)
			return false;
		if(rootA.val != rootB.val)
			return false;
		return DoesisSubTree(rootA.left, rootB.left) &&
			   DoesisSubTree(rootA.right, rootB.right);
	}
	
	
	public static void main(String[] args) {
		Question18 test = new Question18();
		Question6 help = new Question6();
		//��ͨ����������
//		int[] A = {8,8,9,0,0,2,4,0,0,7,0,0,7,0,0};
//		int[] B = {8,8,0,0,2,0,0};
		
//		int[] A = {8,7,9,0,0,0,0};//ֻ������������
//		int[] B = {8,0,9,0,6,0,0};//ֻ������������
		int[] A = {8,0,0};//���ڵ�����
		int[] B = {8,9,0,1};
		TreeNode rootA = help.createBintree(A);
		help.count = 0;
		TreeNode rootB = help.createBintree(B);
		System.out.println(test.isSubTree(rootA, rootB));
	}

}
