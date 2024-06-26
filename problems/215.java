class Solution {
    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
		int index = sort(0, nums.length-1, nums);
		int low = 0;
		int high = nums.length - 1;
		k = nums.length - k;
    while (index != k) {
			if (index < k) {
				low = index + 1;
			} else {
				high = index - 1;
			}
			index = sort(low, high, nums);
    }
    return nums[k];
  }

	public void swap(int i, int j, int[] nums) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public int sort(int start, int end, int[] nums) {
    int pivotIndex = random.nextInt(end + 1 - start) + start;
		int pivot = nums[pivotIndex];
    swap(pivotIndex, end, nums);
		for (int i=start; i<end; i++) {
			if (nums[i] < pivot) {
				swap(i, start, nums);
				start++;
			}
		}
		swap(start, end, nums);
		return start;
	}
}
