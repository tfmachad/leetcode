package org.solution.intersectionoftwolinkedlists

object Solution {
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        val listANodes: HashSet<ListNode> = HashSet()
        var node = headA
        while(node != null) {
            listANodes.add(node)
            node = node.next
        }

        node = headB
        while (node != null) {
            if (listANodes.contains(node)) return node
            node = node.next
        }
        return null
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}