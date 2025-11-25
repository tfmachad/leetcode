package org.mysolution


// Given the root of a binary tree and an integer targetSum, return true if the tree has a
// root-to-leaf path such that adding up all the values along the path equals targetSum.

// A leaf is a node with no children.


// Constraints:

// Number of nodes is [0, 5000]
// -1000 <= Node.val <= 1000
// -1000 <= targetSum <= 1000

object Solution {

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        if (isLeaf(root) && root.`val` == targetSum) return true
        val need = targetSum - root.`val`
        return hasPathSum(root.left, need)
                || hasPathSum(root.right, need)
    }

    private fun isLeaf(node: TreeNode) = node.left == null && node.right == null

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}