package org.solution

// Given a non-empty array of non-negative integers, the degree of this array is defined as the
// maximum frequency of any one of its elements.
// Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has
// the same degree as nums.


object Solution {

    fun findShortestSubArray(nums: IntArray): Int {
        val keyToElement: MutableMap<Int, Element> = mutableMapOf()
        var best: Element? = null

        for ((index, key) in nums.withIndex()) {
            val element = keyToElement[key]?.also {
                it.increment(index)
            } ?: Element(key, index).also {
                keyToElement[key] = it
            }
            best = if (element.isBetter(best)) element else best
        }
        return best?.length ?: 1
    }

    private class Element(val key: Int, val firstIndex: Int) {
        private var lastIndex: Int = firstIndex
        var frequency: Int = 1
            private set

        var length: Int = 1
            get() = lastIndex - firstIndex + 1
            private set

        fun increment(index: Int) {
            frequency++
            lastIndex = index
        }

        fun isBetter(other: Element?): Boolean {
            return other == null
                    || frequency > other.frequency
                    || (frequency >= other.frequency && length < other.length)
        }
    }
}