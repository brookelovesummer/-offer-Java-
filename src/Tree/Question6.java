package Tree;

import java.util.Stack;

public class Question6 {
	
	/**
	 * 关于对本题的一点思考：
	 * 
	 * 注意指针移动，最好手动画个具体的图进行分析
	 * 注意递归结束的条件以及对应的代码书写
	 * 考虑特殊情况1.前序遍历和后序遍历不匹配2.空值
	 * 
	 * PS:特别注意，像这种递归左右子树的情况，一定注意要看有没有左右子树，否则容易出错
	 * 本题就是通过左右子树的大小来判断需不需要进行递归左右子树
	 * 
	 * 启发：
	 * 中序遍历+{前序or后序}即可重建二叉树
	 * 通过前序找根节点，然后中序找左右子树
	 */
	
	public int count = 0;
	/**
	 * 根据前序遍历和中序遍历的结果重建二叉树
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode ReBuildTree(int[] preorder, int[] inorder) {
		
		if(preorder == null || preorder.length == 0 
			|| inorder == null || inorder.length == 0)
			return null;
		
		return getrebuildtree(preorder, inorder,0,preorder.length-1,0,inorder.length-1);
	}

	private TreeNode getrebuildtree(int[] preorder, int[] inorder,int ps, int pe,int is,int ie) {

		if(is == ie) {
			if(preorder[ps] == inorder[is])//对前序遍历和中序遍历匹配验证
				return new TreeNode(preorder[ps],null,null);
			else {
				System.out.println("前序遍历和中序遍历不匹配！");
				System.exit(1);
			}
		}
		
		int rootvalue = preorder[ps];
		int lsize = 0;
		int rsize = 0;
		for(int i=is;i<=ie;i++) {
			if(inorder[i] != rootvalue)
				lsize++;
			else
				break;
		}
		rsize = ie - is - lsize;
		TreeNode root = new TreeNode(rootvalue, null, null);
		if(lsize > 0)//判断需不需要进行递归子树
			root.left = getrebuildtree(preorder, inorder, ps+1, ps+lsize, is, is+lsize-1);
		if(rsize > 0)
			root.right = getrebuildtree(preorder, inorder, pe-rsize+1, pe, ie-rsize+1, ie);
		
		return root;
	}
	
	/**
	 * 根据中序遍历和后序遍历的结果重建二叉树
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode ReBuildTree2(int[] inorder, int[] postorder) {
		
		if(postorder == null || postorder.length == 0 
			|| inorder == null || inorder.length == 0)
			return null;
		
		return getrebuildtree2(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
	}

	private TreeNode getrebuildtree2(int[] inorder, int[] postorder,int is, int ie,int ps,int pe) {

		if(is == ie) {
			if(postorder[ps] == inorder[is])
				return new TreeNode(postorder[ps],null,null);
			else {
				System.out.println("中序遍历和后序遍历不匹配！");
				System.exit(1);
			}
		}
		
		int rootvalue = postorder[pe];
		int lsize = 0;
		int rsize = 0;
		for(int i=is;i<=ie;i++) {
			if(inorder[i] != rootvalue)
				lsize++;
			else
				break;
		}
		rsize = ie - is - lsize;
		TreeNode root = new TreeNode(rootvalue, null, null);
		if(lsize > 0)
			root.left = getrebuildtree2(inorder, postorder, is, is+lsize-1, ps, ps+lsize-1);
		if(rsize > 0)
			root.right = getrebuildtree2(inorder, postorder, ie-rsize+1, ie, pe-rsize, pe-1);
		
		return root;
	}
	
	//8,8,9,0,0,2,4,0,0,7,0,0,7,0,0,0
	public TreeNode createBintree(int[] arr) {
		TreeNode p = null;
		if(count >= arr.length || arr[count] == 0) {
			count++;
			return null;	
		}
		else {
			p = new TreeNode();
			p.val = arr[count++];
			p.left = createBintree(arr);
			p.right = createBintree(arr);
			return p;
		}
	}
	
	public void printTree(TreeNode root) {
		TreeNode p = root;
		if(p != null) {
			
			System.out.print(p.val + " ");
			printTree(p.left);
			printTree(p.right);
//			System.out.print(p.val + " ");
		}
	}
	
	/**
	 * 后序遍历的非递归版本，中序遍历的非递归版本都得重新理解
	 * @param root
	 */
	public void printTree_Notrecurisely(TreeNode root) {
		if(root != null) {
			Stack<TreeNode> stack = new Stack<>();
			stack.add(root);
			while(!stack.isEmpty()) {
				root = stack.pop();
				if(root.right != null) {
					stack.add(root);
					stack.add(root.right);
				}else if(root.left != null) {
					stack.add(root);
					stack.add(root.left);
				}
			} 
		}
	}
	
	public static void main(String[] args) {
		Question6 test = new Question6();
//		int[] preorder = {1,2,3,4,5,6,7};
//		int[] inorder = {3,2,4,1,6,5,7};
//		int[] postorder = {3,4,2,6,7,5,1};
		
//		int[] preorder = {'A','B','C','D','E','F','G'};
//		int[] inorder = {'C','B','D','A','F','E','G'};
//		int[] postorder = {'C','D','B','F','G','E','A'};
		
		int[] preorder = {7,2,4,7,3,5,6,8};
		int[] inorder = {4,7,2,1,5,3,8,6};
		int[] postorder = {7,4,2,5,8,6,3,1};
		
//		int[] preorder = {};
//		int[] inorder = {};
//		int[] postorder = {};
		TreeNode root = test.ReBuildTree(preorder, inorder);
		test.printTree(root);
		System.out.println();
		test.printTree_Notrecurisely(root);
		System.out.println();
		System.out.println();
		root = test.ReBuildTree2(inorder, postorder);
		test.printTree(root);
	}

}

class TreeNode{
	
	int val;
	TreeNode left;
	TreeNode right;
	
	
	public TreeNode() {
		super();
	}


	public TreeNode(int value, TreeNode lchild, TreeNode rchild) {
		super();
		this.val = value;
		this.left = lchild;
		this.right = rchild;
	}
	
	
}
