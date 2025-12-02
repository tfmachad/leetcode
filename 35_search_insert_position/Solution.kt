package org.mysolution

import kotlin.math.max

// Given a sorted array of distinct integers and a target value, return the index if the target is
// found. If not, return the index where it would be if it were inserted in order.

// You must write the algorithm with O(log n) runtime complexity.
// 1 <= nums.length <= 10^4
// -10^4 <= nums[i] <= 10^4
// nums contains distinct values sorted in ascending order
// -10^4 <= target <= 10^4

// Thoughts:
// 1. Sorted array > binary search

object Solution {

    fun searchInsert(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex
        while (l <= r) {
            val mid = (l + r) / 2
            when {
                nums[mid] < target -> l = mid + 1
                nums[mid] > target -> r = mid - 1
                else -> return mid
            }
        }
        return l
    }
}