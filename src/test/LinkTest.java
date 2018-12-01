package test;

public class LinkTest {

	public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null || pHead.next==null){
           return pHead;
        }
        ListNode first=new ListNode(0);
        first.next=pHead;
        ListNode pre=first;
        ListNode last=pHead;
        while(last!=null){
           if(last.next!=null && last.val==last.next.val){
               while(last.next!=null && last.val==last.next.val){
                   last=last.next;
               }
               pre.next=last.next;
               last=last.next;
           }else{
               pre=pre.next;
               last=last.next;
           }
        }
        return first.next;
    }
	
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(2);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(4);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		listNode1.next=listNode2;
		listNode2.next=listNode3;
		listNode3.next=listNode4;
		listNode4.next=listNode5;
		LinkTest test = new LinkTest();
		ListNode node = test.deleteDuplication(listNode1);
		System.out.println(node.val);
	}
}
