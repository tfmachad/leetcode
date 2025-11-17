package org.solution.maxsubarray

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SolutionTest(private val expected: Int, private val nums: IntArray) {

    @Test
    fun `test maxSubArray`() {
        assertEquals(expected, Solution.maxSubArray(nums))
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "array = {1}, expected = {0}")
        fun data(): Iterable<Array<Any>> {
            return arrayListOf(
                arrayOf(6, intArrayOf(-2,1,-3,4,-1,2,1,-5,4)),
                arrayOf(1, intArrayOf(1)),
                arrayOf(23, intArrayOf(5,4,-1,7,8))
            )
        }
    }
}