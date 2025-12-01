package org.mysolution

// You are given the root of a binary tree containing digits from 0 to 9 only.
// Each root-to-leaf path in the tree represents a number.
// E.g.: The root-to-leaf path 1 > 2 > 3 represents the number 123
// Return the total sum of all root-to-leaf numbers. <<<
//  Test cases are generated so that the answer will fit a 32-bit integer.
// A leaf node is a node with no children.

// The number of nodes in the tree is in the range [1, 1000]
// 0 <= Node.val <= 9
// The depth of the tree will not exceed 10


object Solution {
    fun sumNumbers(root: TreeNode?): Int {
        var total = 0

        fun dfs(node:TreeNode, sum:Int) {
            val newSum = sum + node.`val`
            if (isLeaf(node)) {
                total += newSum
            } else {
                node.left?.let { dfs(it, newSum * 10) }
                node.right?.let { dfs(it,  newSum * 10) }
            }
        }
        root?.let { dfs(it, 0) }
        return total
    }

    private fun isLeaf(node: TreeNode) = node.left == null && node.right == null
}