package org.solution.minimumindexsumoftwolists

import kotlinx.coroutines.joinAll
import kotlin.math.min

object Solution {
    // Given two arrays of strings l1 and l2, find the common strings with the least index sum

    fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
        // map strings in the first list to their corresponding position
        val stringToIndex: MutableMap<String, Int> = mutableMapOf()
        for ((i, string) in list1.withIndex()) {
            stringToIndex[string] = i
        }

        var results: MutableList<String> = mutableListOf()
        var minSum = Int.MAX_VALUE
        for ((j, string) in list2.withIndex()) {
            if (j > minSum) break // optimization; no i + j sum can be lower

            val i = stringToIndex[string]
            if (i == null) continue
            val sum = i + j
            if (sum < minSum) {
                results = mutableListOf(string) // reset
                minSum = sum
            } else if (sum == minSum) {
                results.add(string)
            }
        }
        return results.toTypedArray()
    }
}