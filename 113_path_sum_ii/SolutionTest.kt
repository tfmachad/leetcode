package org.mysolution

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SolutionTest(val root: TreeNode?, val targetSum: Int, val expected: List<List<Int>>) {
    @Test
    fun test() {
        assertEquals(expected, Solution.pathSum(root, targetSum))
    }



    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Iterable<Array<Any>> {
            return arrayListOf(
                arrayOf(treeFromArray(arrayOf(5,4,8,11,null,13,4,7,2,null,null,5,1)), 22, listOf(listOf(5,4,11,2), listOf(5,8,4,5)))
            ) as Iterable<Array<Any>>
        }

        fun treeFromArray(arr: Array<Int?>): TreeNode? {
            if (arr.isEmpty() || arr[0] == null) return null

            val root = TreeNode(arr[0]!!)
            val queue: ArrayDeque<TreeNode> = ArrayDeque()
            queue.add(root)

            var i = 1
            while (i < arr.size) {
                val curr = queue.removeFirst()

                // left
                if (arr[i] != null) {
                    curr.left = TreeNode(arr[i]!!)
                    queue.add(curr.left!!)
                }
                i++

                // right
                if (i < arr.size && arr[i] != null) {
                    curr.right = TreeNode(arr[i]!!)
                    queue.add(curr.right!!)
                }
                i++
            }
            return root
        }
    }
}