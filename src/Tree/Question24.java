package Tree;

public class Question24 {
	
	/**
	 * ¶ş²æËÑË÷Ê÷µÄºóĞò±éÀú
	 * @param arr
	 * @return
	 */
	public boolean VerifyPostSequenceisBST(int[] arr) {
		if(arr == null || arr.length == 0)
			return true;
	
		return isBst_postorder(arr,0,arr.length - 1);
	}

	private boolean isBst_postorder(int[] arr, int start, int end) {
		if(start >= end)
			return true;
		int lsize = 0;
		boolean flag = true;
		for(int i = start;i<end;i++) {
			if(flag && arr[i] < arr[end])
				lsize++;
			if(arr[i] > arr[end])
				flag = false;
			if(!flag && arr[i]<arr[end])
				return false;
		}
		return isBst_postorder(arr,start,start+lsize-1)&&
				isBst_postorder(arr,start+lsize,end-1);
	}
	
	
	/**
	 * ¶ş²æËÑË÷Ê÷µÄ Ç°Ğò±éÀú
	 * @param args
	 */
	public boolean VerifyPreSequenceisBST(int[] arr) {
		if(arr == null || arr.length == 0)
			return true;
		return isBST_preorder(arr,0,arr.length-1);
	}

	
	private boolean isBST_preorder(int[] arr, int start, int end) {
		if(start >= end)
			return true;
		int lsize = 0;
		int root = arr[start];
		boolean flag = true;
		for(int i = start+1;i <= end;i++) {
			if(flag && arr[i]<root)
				lsize++;
			if(flag && arr[i] > root)
				flag = false;
			if(!flag && arr[i] < root)
				return false;
		}
		
		return isBST_preorder(arr,start+1,start+lsize) &&
				isBST_preorder(arr,start+lsize+1,end);
	}

	public static void main(String[] args) {
		Question24 test = new Question24();
		int[] arr = {5,7,6,9,11,10,8};
		int[] arr1 = {8,6,7,8,10,9,11};
		System.out.println(test.VerifyPostSequenceisBST(arr));
		System.out.println(test.VerifyPreSequenceisBST(arr1));
	}

}
