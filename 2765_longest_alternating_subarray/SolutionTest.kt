package org.solution.longestalternatingsubarray

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SolutionTest(private val expected: Int, private val nums: IntArray) {

    @Test
    fun test() {
        assertEquals(expected, Solution.alternatingSubarray(nums))
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Iterable<Array<Any>> {
            return arrayListOf(
                arrayOf(4, intArrayOf(2,3,4,3,4)),
                arrayOf(2, intArrayOf(4,5,6)),
                arrayOf(-1, intArrayOf(1)),
                arrayOf(2, intArrayOf(1,29,30,5))
            )
        }
    }
}