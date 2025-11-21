package org.solution.minimummountaintriplets

import kotlin.math.min

private const val UNDEFINED = -1

object Solution {

    fun minimumSum(nums: IntArray): Int {

        // 3 <= nums.length <= 50
        // 1 <= nums[i] <= 50
        // RETURN: minimum possible sum of a mountain triplet if exists, else -1

        // two pointers, left and right, scanning inwards
        // if next number in is smaller, move inwards

        var l: Int
        var r: Int
        var minSum = UNDEFINED
        var leftMin = IntArray(nums.size)
        var rightMin = IntArray(nums.size)
        leftMin[0] = Integer.MAX_VALUE
        rightMin[nums.lastIndex] = Integer.MAX_VALUE

        for (i in 1..nums.lastIndex - 1) {
            l = i
            r = nums.lastIndex - i
            leftMin[l] = min(leftMin[l - 1], nums[l - 1])
            rightMin[r] = min(rightMin[r + 1], nums[r + 1])
        }

        for (i in 1..nums.lastIndex - 1) {
            // is this the peak of a mountain?
            if (nums[i] > leftMin[i] && nums[i] > rightMin[i]) {
                val sum = leftMin[i] + rightMin[i] + nums[i]
                minSum = if (minSum == UNDEFINED) sum else min(minSum, sum)
            }
        }

        return minSum
    }
}