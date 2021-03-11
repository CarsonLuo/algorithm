package exercise.linkedlList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ListNode
 * @Author Carson
 * @Date 2021/2/20 17:36
 **/
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        ListNode node = this;
        while (true){
            if(node != null){
                list.add(node.val);
                node = node.next;
            }else {
                break;
            }
        }
        return Arrays.toString(list.toArray());
    }
}
