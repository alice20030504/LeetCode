import heapq

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists):
        min_heap = []
        
        # Push first node of each list into heap
        for index, node in enumerate(lists):
            if node:
                heapq.heappush(min_heap, (node.val, index, node))
        
        dummy = ListNode()
        curr = dummy
        
        while min_heap:
            val, index, node = heapq.heappop(min_heap)
            curr.next = node
            curr = curr.next
            
            if node.next:
                heapq.heappush(min_heap, (node.next.val, index, node.next))
        
        return dummy.next
