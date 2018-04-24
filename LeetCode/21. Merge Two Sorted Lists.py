# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 == None:
            return l2
        if l2 == None:
            return l1
        head = None
        if l1.val < l2.val:
            head = l1
            l1 = l1.next
        else:
            head = l2
            l2 = l2.next
        tmp = head
        while l1 != None and l2 != None:
            if l1.val < l2.val:
                tmp.next = l1
                tmp = l1
                l1 = l1.next
            else:
                tmp.next = l2
                tmp = l2
                l2 = l2.next
        while l1 != None:
            tmp.next = l1
            tmp = l1
            l1 = l1.next
        while l2 != None:
            tmp.next = l2
            tmp = l2
            l2 = l2.next
        return head        