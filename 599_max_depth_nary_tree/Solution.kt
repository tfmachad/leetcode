package org.mysolution

import kotlin.math.max

// Given a n-ary tree, find its maximum depth
// The maximum depth is the number of nodes along the longest path from the root node down to the
// farthest leaf node.
//

// The total number of nodes is in the range [0, 10^4]
// The depth of the n-ary tree is less than or equal to 1000

object Solution {

    fun maxDepth(root: Node?): Int {
        return root?.let { visit(it, 0) } ?: 0
    }

    private fun visit(node: Node, lastDepth: Int): Int {
        val thisDepth = lastDepth + 1
        if (isLeaf(node)) return thisDepth

        var maxDepth = 0
        for (child in node.children) {
            if (child != null) {
                maxDepth = max(maxDepth, visit(child, thisDepth))
            }
        }
        return maxDepth
    }

    private fun isLeaf(node: Node): Boolean {
        for (child in node.children) {
            if (child != null) return false
        }
        return true
    }
}