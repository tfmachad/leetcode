package org.mysolution


// Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where
// the sum of the node values in the path equals targetSum.
//
// R1: Each path should be returned as a list of the node values, not node references.

// R2: A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a
// node with no children.

object Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val paths: MutableList<List<Int>> = mutableListOf()
        val path = mutableListOf<Int>()
        findPaths(paths, path, root, targetSum)
        return paths
    }


    private fun findPaths(paths: MutableList<List<Int>>, path: MutableList<Int>, root: TreeNode?, targetSum: Int) {
        root ?: return
        path.add(root.`val`)

        if (isLeaf(root) && root.`val` == targetSum) {
            paths.add(path)
        } else {
            val needs = targetSum - root.`val`
            findPaths(paths, mutableListOf<Int>().apply { addAll(path) }, root.left, needs)
            findPaths(paths, mutableListOf<Int>().apply { addAll(path) }, root.right, needs)
        }
    }

    private fun isLeaf(node: TreeNode) = node.left == null && node.right == null
}