package org.mysolution

// Given the root of a binary tree, flatten the tree into a "linked list"
// * The "linked list" should use the same TreeNode class where the right child pointer points to
// the next node in the list and the left child pointer is always null.
// * The "linked list" should be in the same order as a pre-order traversal (recursive left) of the
// binary tree.
// Constraints:
// * The number of nodes in the tree is in the range [0, 2000]
// * -100 <= Node.val <= 100
// FUQ: Can you flatten the tree in-place (with O(1) extra space)?

object Solution {
    fun flatten(root: TreeNode?): Unit {
        dfs(root)
    }

    private fun dfs(node: TreeNode?): TreeNode? {
        // tree is a recursive structure; node to node to node
        node ?: return null

        val leftTail = dfs(node.left)
        val rightTail = dfs(node.right)

        if (leftTail != null) {
            leftTail.right = node.right
            node.right = node.left
            node.left = null
        }
        return when {
            rightTail != null -> rightTail
            leftTail != null -> leftTail
            else -> node
        }
    }
}