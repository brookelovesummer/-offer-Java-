package Tree;

public class Question27 {
	
	//����lastNode��Ҫÿ�ζ�ָ��ǰ�ڵ�ǰ��������ֱ����Ϊ������������
	
	private TreeNode lastNode = null;
	
	/**
	 * ������������ת��Ϊ�����˫������
	 * 
	 * ��ΪBST��>��>�ң�����ת��Ϊ˫�������ʱ��
	 * ��ڵ�ָ��ǰ�����ҽڵ�ָ���̣������ͱ�����˫�����������
	 * @param root
	 * @return
	 */
	public TreeNode ConvertBSTtoList(TreeNode root) {
		
		ConvertBST(root);
		
		//lastNodeָ��˫�������β�ڵ㣬���Ա���Ҫ�����Ƶ�ͷ
		while(lastNode != null && lastNode.left != null) {
			lastNode = lastNode.left;
		}
		
		return lastNode;
	}
	
	/**
	 * lastNodeʼ����ָ��ǰ�ڵ��ǰ���ڵ�
	 * @param root
	 * @param lastNode
	 */
	public void ConvertBST(TreeNode root) {
		if(root == null)
			return;
		if(root.left != null)
			ConvertBST(root.left);
		
		//��ǰ�ڵ����ָ��ָ��ǰ������ָ��ָ����
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
//		int[] A = {8,7,5,0,0,0,0};//ֻ������������
//		int[] A = {8,0,9,0,12,0,0};//ֻ������������
//		int[] A = {8,0,0};//���ڵ�����
		TreeNode root = new Question6().createBintree(A);
		Question27 test = new Question27();
		TreeNode head = test.ConvertBSTtoList(root);
		test.printTreeList(head);
	}
	

}
