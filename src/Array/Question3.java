package Array;

public class Question3 {
	
	public boolean matrixisnull(int[][] nums) {
		if(nums == null || nums.length ==0 || nums[0].length == 0)
			return true;
		else
			return false;
	}
	
	/**
	 * nums�����ҵ��������µ����Ķ�ά���飬target�ڲ���nums��
	 * ѡ�����Ͻǵ������Ƚ�
	 * @param nums
	 * @param target
	 * @return
	 */
	public boolean findnumber(int[][] nums , int target) {
		if(matrixisnull(nums))
			return false;
		int i = 0;
		int j = nums[0].length-1;
		for(;i<nums.length && j>=0;) {
			if(nums[i][j] == target)
				return true;
			if(nums[i][j] > target)
				j--;
			else
				i++;
		}
		return false;
	}
	
	/**
	 * ѡ�����½����Ƚ�
	 * @param nums
	 * @param target
	 * @return
	 */
	public boolean findnumber1(int[][] nums , int target) {
		if(matrixisnull(nums))
			return false;
		int i = nums.length - 1;
		int j = 0;
		for(;i>=0 && j<nums[0].length;) {
			if(nums[i][j] == target)
				return true;
			if(nums[i][j] > target)
				i--;
			else
				j++;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] nums = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		int target = 2;
		Question3 test = new Question3();
		System.out.println(test.findnumber(nums, target));
		System.out.println(test.findnumber1(nums, target));
	}

}
