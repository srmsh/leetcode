package addTwoNum;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);

        ListNode start1 = l1, start2 = l2, now = result;
        int add = 0;
        while (start1 != null || start2 != null) {
            int a1 = null == start1 ? 0 : start1.val, a2 = null == start2 ? 0: start2.val;
            ListNode nowNext = new ListNode((add + a1 + a2)%10);
            now.next = nowNext;
            start1 = null == start1 ? null : start1.next;
            start2 = null == start2 ? null : start2.next;
            now = nowNext;
            add = (add + a1 + a2) / 10;
        }
        if (add != 0) {
            now.next = new ListNode(add);
        }
        return result.next;
    }
}
