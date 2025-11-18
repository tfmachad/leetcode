package org.solution.longestalternatingsubarray

import kotlin.math.max

object Solution {
    // given a 0-indexed integer array nums, a subarray s of length m is called alternating if:
    // a. m is greater than 1
    // b. s1 = s0 + 1
    // c. looks like s1 - s0 = 1, s2 - s1 = -1, ..., s[m - 1] - s[m - 2] = (-1)^m

    // return
    // maximum length of all alternating subarrays
    // OR
    // -1 if no such subarray exists

    fun alternatingSubarray(nums: IntArray): Int {
        var maxLength = -1
        var curLength = -1
        var isAlternating = false

        for (i in 1..nums.lastIndex) {
            if (isAlternating) {
                isAlternating = nums[i] == nums[i-2]
                curLength += if (isAlternating) 1 else 0
            }
            if (!isAlternating) {
                isAlternating = isFirstAlternate(nums, i)
                if (isAlternating) {
                    curLength = 2
                }
            }
            maxLength = max(maxLength, curLength)
        }
        return maxLength
    }

    private fun isFirstAlternate(nums: IntArray, i: Int): Boolean {
        return nums[i] == nums[i-1] + 1
    }
}