package Solutions.LinkedLists;

import java.util.Arrays;
import java.util.HashSet;

public class Solution3217 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode modifiedList(int[] nums, ListNode head) {

        HashSet<Integer> num2DeleteSet = new HashSet<>();
        Arrays.stream(nums).forEach(num2DeleteSet::add);

        ListNode pseudoHead = new ListNode();
        pseudoHead.next = head;
        ListNode slw = pseudoHead;
        ListNode fst = head;

        while (fst != null) {
            if (num2DeleteSet.contains(fst.val)) {
                // delete
                ListNode tmp = fst.next;
                fst.next = null;
                fst = tmp;
                slw.next = fst;
            }
            else {
                // skip
                slw = fst;
                fst = fst.next;
            }
        }

        return pseudoHead.next;
    }
}
