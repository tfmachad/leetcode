package org.solution.longestturbulentsubarray

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {

    @Test
    fun `test case 1`() {
        assertEquals(5, Solution.maxTurbulenceSize(intArrayOf(9,4,2,10,7,8,8,1,9)))
    }
}