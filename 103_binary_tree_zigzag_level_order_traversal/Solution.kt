package org.mysolution

import java.util.LinkedList

// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
// (i.e., from left to right, then right to left for the next level and alternate between).

// The number of nodes in the tree is in the range [0, 2000]
// -100 <= Nodel.val <= 100

object Solution {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val result = mutableListOf<List<Int>>()
        val queue = ArrayDeque<TreeNode>()
        var isLeftToRight = true

        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            val currentLevel = LinkedList<Int>()
            for (i in 0 until size) {
                val node = queue.removeFirst()
                if (isLeftToRight) {
                    currentLevel.addLast(node.`val`) // append
                } else {
                    currentLevel.addFirst(node.`val`) // prepend
                }

                // BFS traversal
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
            result.add(currentLevel)
            isLeftToRight = !isLeftToRight
        }
        return result
    }
}