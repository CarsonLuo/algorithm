package exercise.linkedlList;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
// 示例 1：
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
// 示例 2：
//输入：head = [1], n = 1
//输出：[]
//
// 示例 3：
//输入：head = [1,2], n = 1
//输出：[1]
//
// 提示：
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Related Topics 链表 双指针
// 👍 1222 👎 0

public class LeetCode19 {
    private ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode var = head;
        while (true){
            if(var != null){
                length++;
                var = var.next;
            }else {
                break;
            }
        }
        ListNode node = null;
        for(int i = 1; i <= length - n; i++){
            if(node == null){
                node = head;
            }
            node = node.next;
        }
        if(node == null){
            return head.next;
        }
        if(node.next != null) {
            node.next = node.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3,n4);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,n2);
        LeetCode19 leetCode19 = new LeetCode19();
        n1 = leetCode19.removeNthFromEnd(n1,3);
        System.out.println(n1.toString());
    }
}