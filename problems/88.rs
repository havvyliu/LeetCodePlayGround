impl Solution {
    pub fn merge(nums1: &mut Vec<i32>, m: i32, nums2: &mut Vec<i32>, n: i32) {
        if n == 0 {
            return;
        }
        let mut i: usize = nums1.len() - (n as usize);
        let mut j: usize = 0;
        while i < nums1.len() {
            nums1[i] = nums2[j];
            i += 1;
            j += 1;
        }
        nums1.sort();
    }
}
