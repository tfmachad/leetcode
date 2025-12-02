package org.mysolution

// There is an integer array nums sorted in ascending order (with distinct values).
// Prior to being passed to your function, nums is possibly left rotated at an unknown index k
// (1 <= k < nums.length). For example [0,1,2,4,5,6,7] might be left rotated by 3 indices and
// become [4,5,6,7,0,1,2]

// Given the array nums after the possible rotation and an integer target, return the index of
// target if it is in nums, or -1 if it is not in nums.


object Solution {

    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex
        // while the pointers do not cross
        while (l <= r) {
            val mid = (l + r) / 2
            if (nums[mid] == target) {
                return mid
            } else if (nums[l] <= nums[mid]) {
                // left side is sorted
                if (nums[l] <= target && target <= nums[mid]) {
                    // and target is on that side
                    r = mid - 1
                } else {
                    l = mid + 1
                }
            } else {
                // right side is sorted
                if (nums[mid] < target && target <= nums[r]) {
                    // and target is on that side
                    l = mid + 1
                } else {
                    r = mid - 1
                }
            }
        }
        return -1
    }
}