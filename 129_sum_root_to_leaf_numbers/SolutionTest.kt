package org.mysolution

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SolutionTest(val root: TreeNode?, val expectedSum: Int) {

    @Test
    fun test() {
        assertEquals(expectedSum, Solution.sumNumbers(root))
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Iterable<Array<Any>> {
            return arrayListOf(
                arrayOf(treeFromArray(arrayOf(1, 2, 3)), 25)
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