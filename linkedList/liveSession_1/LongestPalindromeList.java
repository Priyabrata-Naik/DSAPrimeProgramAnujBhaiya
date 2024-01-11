package linkedList.liveSession_1;

public class LongestPalindromeList {
    public static void main(String[] args) {

        Node head = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(2);
        Node n3 = new Node(1);
        Node n4 = new Node(1);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        int ans = longestPalindromeLength(head);

        System.out.println(ans);

    }
    static int longestPalindromeLength(Node head){
        if(head == null)
            return 0;
        if(head.next == null)
            return 1;
        Node cur = head;
        Node prev = null;
        int ans = 0;

        while(cur != null){
            Node next = cur.next;
            cur.next = prev;

            int commonForCurExactCenter = commonCount(prev, next);
            int lengthOfExactCenter = 2 * commonForCurExactCenter + 1;

            int commonForCurNotExactCenter = commonCount(cur, next);
            int lengthOfNotExactCenter = 2 * commonForCurNotExactCenter;

            int largestAmongTwo = Math.max(lengthOfExactCenter, lengthOfNotExactCenter);
            ans = Math.max(ans, largestAmongTwo);
            prev = cur;
            cur = next;
        }
        return ans;
    }
    static int commonCount(Node a, Node b){
        int common = 0;
        while(a != null && b != null){
            if(a.data == b.data){
                common++;
            }else
                break;
            a = a.next;
            b = b.next;
        }
        return common;
    }
}
