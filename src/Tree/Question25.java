package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question25 {
	
	List<List<TreeNode>> Lists = new ArrayList<>();
	
	public void printrouteTree(TreeNode root, int target) {
		if(root != null) {
			List<TreeNode> list = new LinkedList<>();
			printroutertree(root,list ,target,0);
		}
		//printroutertree(treenode,list,target,count)
	}
	public void printroutertree(TreeNode root,List<TreeNode> list,int target, int count) {
		if(root == null)
			return ;
		
		list.add(root);
		count += root.val;
		//只有是叶子节点才打印
		if(count == target && root.left == null && root.right == null)
			print(list);
		printroutertree(root.left, list, target, count);
		printroutertree(root.right, list, target, count);
		list.remove(list.size()-1);
	}
	
	public List<List<TreeNode>> printrouteTree_list(TreeNode root, int target) {
		if(root != null) {
			List<TreeNode> list = new LinkedList<>();
			return printroutertree_list(root,list ,target,0);
		}
		return null;
	}
	public List<List<TreeNode>> printroutertree_list(TreeNode root,List<TreeNode> list,int target, int count) {
		if(root == null)
			return null;
		
		list.add(root);
		count += root.val;
		//只有是叶子节点才打印
		if(count == target && root.left == null && root.right == null) {
			List<TreeNode>  dest = new LinkedList<>();
			for(TreeNode node : list)
				dest.add(node);
			Lists.add(dest);
		}
		
		printroutertree_list(root.left, list, target, count);
		printroutertree_list(root.right, list, target, count);
		list.remove(root);
		return Lists;
	}
	

	private void print(List<TreeNode> list) {
		if(list == null || list.size() == 0)
			return;
		for(TreeNode node : list)
			System.out.print(node.val + " ");
		System.out.println();
	}
	
	private void print1(List<List<TreeNode>> lists) {
		if(lists == null || lists.size() == 0)
			return;
		for(List<TreeNode> list : lists) {
			for(TreeNode node : list)
				System.out.print(node.val + " ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
//		int[] arr = {8,8,9,0,0,2,4,0,0,7,0,0,7,0,0};
		int[] arr = {10,5,4,0,0,7,0,0,12,0,0};
		Question25 test = new Question25();
		TreeNode root = new Question6().createBintree(arr);
		test.print1(test.printrouteTree_list(root, 19));
		
		List<TreeNode> list = new ArrayList<>();
		TreeNode node1 = new TreeNode(1, null, null);
		list.add(node1);
		System.out.println(list.get(0).val);
		node1.val = 2;
		System.out.println(list.get(0).val);
		
	}
	
}
