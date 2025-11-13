package org.solution

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {
    @Test
    fun `test case 1`() {
        assertEquals(2, Solution.findShortestSubArray(intArrayOf(1,2,2,3,1)))
    }

    @Test
    fun `test case 2`() {
        assertEquals(6, Solution.findShortestSubArray(intArrayOf(1,2,2,3,1,4,2)))
    }
}