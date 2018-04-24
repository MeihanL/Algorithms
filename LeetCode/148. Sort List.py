# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None or head.next == None:
            return head
        fast = head
        slow = head
        while fast.next != None and fast.next.next != None:
            fast = fast.next.next
            slow = slow.next

        mid = slow.next
        slow.next = None
        list1 = self.sortList(head)
        list2 = self.sortList(mid)
        sorted = self.merge(list1, list2)
        return sorted

    def merge(self, list1, list2):
        if list1 == None:
            return list2
        if list2 == None:
            return list1
        head = None
        if list1.val < list2.val:
            head = list1
            list1 = list1.next
        else:
            head = list2
            list2 = list2.next

        tmp = head
        while list1 != None and list2 != None:
            if list1.val < list2.val:
                tmp.next = list1
                tmp = list1
                list1 = list1.next
            else:
                tmp.next = list2
                tmp = list2
                list2 = list2.next
        if list1 != None:
            tmp.next = list1
        if list2 != None:
            tmp.next = list2

        return head