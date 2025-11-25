package org.solution.findindexoffirstoccurrenceinstring

object Solution {
    fun strStr(haystack: String, needle: String): Int {
        val lps = computeLps(needle)

        var i = 0
        var j = 0
        var n = haystack.length
        var m = needle.length

        while (i < n) {
            if (haystack[i] == needle[j]) {
                i++
                j++
                if (j == m) {
                    return i - j
                }
            } else {
                // avoid redundant comparisons
                if (j != 0) {
                    j = lps[j - 1]
                } else {
                    i++
                }
            }
        }
        return -1
    }

    private fun computeLps(pattern: String): IntArray {
        val n = pattern.length
        val lps = IntArray(n)

        var len = 0
        var i = 1

        while (i < n) {
            if (pattern[i] == pattern[len]) {
                len++
                lps[i] = len
                i++
            } else {
                if (len != 0) {
                    len = lps[len - 1]
                } else {
                    lps[i] = 0
                    i++
                }
            }
        }
        return lps
    }
}