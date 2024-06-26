// done
impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut i: usize = 0;
        while i < nums.len() - 1 {
            let mut j: usize = i;
            while j < nums.len() {
                if nums[i] + nums[j] == target {
                    return vec![i as i32, j as i32];
                }
                j += 1;
            }
            i += 1;
        }
        return vec![0];
    }
}
