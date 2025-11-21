package org.solution.minimummountaintriplets

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SolutionTest(private val expected: Int, private val nums: IntArray){

    @Test
    fun test() {
        assertEquals(expected, Solution.minimumSum(nums))
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Iterable<Array<Any>> {
            return arrayListOf(
                arrayOf(9, intArrayOf(8,6,1,5,3)),
                arrayOf(13, intArrayOf(5,4,8,7,10,2)),
                arrayOf(-1, intArrayOf(6,5,4,3,4,5))
            )
        }
    }

}