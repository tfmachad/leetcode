package org.solution.longestturbulentsubarray

import kotlin.math.max

object Solution {
    fun maxTurbulenceSize(arr: IntArray): Int {
        // we want to keep track of the turbulence state of the array

        // start looking from the second position (index = 1)


        if (arr.size <= 1) return 1
        var curLength = 0
        var maxLength = 1
        var isTurbulent = false
        var expectIsGreaterThan = false
        for (i in 1..arr.lastIndex) {
            if (arr[i] == arr[i-1]) {
                isTurbulent = false
                continue
            }
            if (isTurbulent && expectIsGreaterThan == arr[i] > arr[i-1]) {
                expectIsGreaterThan = !expectIsGreaterThan
                curLength++
            } else {
                isTurbulent = true
                expectIsGreaterThan = arr[i] < arr[i-1]
                curLength = 2 // this and the previous
            }
            maxLength = max(maxLength, curLength)
        }
        return maxLength
    }
}