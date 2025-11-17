package org.solution.maxsubarray

import kotlin.math.max

object Solution {
    fun maxSubArray(nums: IntArray): Int {
        var localMax = nums[0]
        var maxFound = nums[0]

        for (i in 1..nums.lastIndex) {
            localMax = max(nums[i], localMax + nums[i])
            maxFound = max(localMax, maxFound)
        }
        return maxFound
    }
}