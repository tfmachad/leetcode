package org.mysolution

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SolutionTest(val nums: IntArray, val target: Int, val expected: Int) {

    @Test
    fun test() {
        assertEquals(expected, Solution.search(nums, target))
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Iterable<Array<Any>> {
            return arrayListOf(
                arrayOf(intArrayOf(4,5,6,7,0,1,2), 3, -1),
                arrayOf(intArrayOf(4,5,6,7,0,1,2), 0, 4),
                arrayOf(intArrayOf(5,1,2,3,4), 1, 1),
            ) as Iterable<Array<Any>>
        }
    }
}