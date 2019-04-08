package test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import test.ListNode;
import test.ListNode2;
import test.Point;
import test.TreeNode;

public class Test {

	private int num;
	// 找出二叉树的最小深度
	public int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int depth = 0;
		while (queue.size() != 0) {
			int size = queue.size();
			depth++;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				if (node.left == null && node.right == null) {
					return depth;
				}
			}
		}
		return depth;
	}

	// 计算波兰表达式
	public int getvalue(String[] token) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < token.length; i++) {
			if (token[i].equals("+") || token[i].equals("-") || token[i].equals("*") || token[i].equals("/")) {
				int a = stack.pop();
				int b = stack.pop();
				if (token[i].equals("+")) {
					stack.push((a + b));
				}
				if (token[i].equals("-")) {
					stack.push((a - b));
				}
				if (token[i].equals("*")) {
					stack.push((a * b));
				}
				if (token[i].equals("/")) {
					stack.push((a / b));
				} else {
					throw new RuntimeException("不合法");
				}
			} else {
				stack.push(Integer.parseInt(token[i]));
			}
		}
		if (stack.size() == 1) {
			return stack.pop();
		}
		return 0;
	}

	// 找出一条线上的最大的点数
	public int maxpoint(Point[] points) {
		int size = points.length;
		if (size < 2) {
			return size;
		}
		int result = 0;
		for (int i = 0; i < size; i++) {
			int dup = 1;
			int vtl = 0;
			int count=0;
			Point point1 = points[i];
			HashMap<Float, Integer> map = new HashMap<>();
			for (int j = 0; j < size; j++) {
				Point point2 = points[j];
				if (i == j) {
					continue;
				}
				if (point1.x == point2.x) {
					if(point1.y==point2.y) {
						dup++;
					}
					vtl++;
				} else {
					float k = (float) (point1.y - point2.y) / (point1.x - point2.x);
					if (map.get(k) == 0) {
						map.put(k, 1);
					} else {
						map.put(k, map.get(k) + 1);
					}
				}
			}
			for (Float key : map.keySet()) {
				count = Math.max(vtl, map.get(key));
			}
			result=Math.max(result, count+dup);
		}
		return result;
	}
	
	//归并排序完成链表排序
	public ListNode sortList(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode midNode=getNode(head);
		ListNode midnext=midNode.next;
		midNode.next=null;
		return mergeSortList(sortList(head),sortList(midnext));
	}

	private ListNode mergeSortList(ListNode sortList, ListNode sortList2) {
		// TODO Auto-generated method stub
		ListNode preHead=new ListNode(0);
		ListNode cur=preHead;
		ListNode cur1=sortList;
		ListNode cur2=sortList2;
		while(cur1!=null && cur2!=null) {
			if(cur1.val<cur1.val) {
				cur.next=cur1;
				cur1=cur1.next;
			}else {
				cur.next=cur2;
				cur2=cur2.next;
			}
			cur=cur.next;
		}
		if(cur1!=null) {
			cur.next=cur1.next;
		}
		if(cur2!=null) {
			cur.next=cur2.next;
		}
		return preHead.next;
	}

	public ListNode getNode(ListNode head) {
		// TODO Auto-generated method stub
		ListNode slow=head;
		ListNode fast=head;
		while(fast.next!=null && fast!=null) {
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow;
	}
	
	//插入排序
	public ListNode insertionSortList(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode r=head.next;
		head.next=null;
		while(r!=null) {
			ListNode current=head;
			ListNode pre=null;
			while(current!=null && current.val<r.val) {
				pre=current;
				current=current.next;
			}
			ListNode next = r.next;
			if(current==head) {
				r.next=head;
				head=r;
			}else {
				pre.next=r;
				r.next=current;
			}
			r=next;
		}
		return head;
	}
	
	//链表有环的set解法
	public boolean hasCycle(ListNode head) {
		if(head==null) {
			return false;
		}
		HashSet<ListNode> set = new HashSet<>();
		while(head!=null) {
			if(set.contains(head)) {
				return true;
			}
			set.add(head);
			head=head.next;
		}
		return false;
	}
	
	
	//不用加减做加法
	public int add(int num1,int num2) {
		while(num2!=0) {
	       int tmp=num1^num2;
           num2=(num1&num2)<<1;
           num1=tmp;
		}
		return num1;
	}
	
	//顺时针打印数字
	public void print(int n) {
		for(int start=0;start*2<n;start++) {
			printNum(start,n);
		}
	}
	
	public void printNum(int start,int n) {
		// TODO Auto-generated method stub
		int endX=n-start-1;
		int endY=n-start-1;
		for(int startX=start;startX<=endX;startX++) {
			num++;
			System.out.print(num+" ");
		}
		for(int startY=start+1;startY<=endY;startY++) {
			System.out.println();
			int i=0;
			while(i<endX*2) {
				System.out.print(" ");
				i++;
			}
			num++;
			System.out.print(num);
		}
		for(int startX=endX-1;startX>=start;startX--) {
			num++;
			int i=0;
			while(i<(startX-1)*2) {
			   System.out.print("-");
			   i++;
			}
			System.out.print(num+" ");
		}
		for(int startY=endY-1;startY>=start+1;startY--) {
			num++;
			int i=0;
			while(i<=startY-1) {
				System.out.println();
				i++;
			}
			System.out.print(num+"-");
		}
	}
	
	//链表反转
	public void reverseLinkedlist(ListNode head) {
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow) {
				break;
			}
		}
		ListNode midNode=slow.next;
	    slow.next=null;
		ListNode behind=reversebehind(midNode);
		ListNode pre=head;
		while(behind!=null) {
			pre.next=behind;
			behind=behind.next;
			pre=pre.next;
			head=head.next;
			pre.next=head;
			pre=pre.next;
		}
	}
	

	public ListNode reversebehind(ListNode midNode) {
		// TODO Auto-generated method stub
		Stack<ListNode> stack = new Stack<>();
		stack.add(midNode);
		ListNode first;
		while(midNode!=null) {
			midNode = midNode.next;
			stack.add(midNode);
		}
		first=stack.pop();
		ListNode pre=first;
		while(!stack.isEmpty()) {
			ListNode node = stack.pop();
			pre.next=node;
			pre=pre.next;
		}
		return first;
	}

	//链表的快排
	public ListNode quickSort(ListNode head,ListNode end) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode node = sort(head,end);
		quickSort(head, node);
		quickSort(node.next,end);
		return head;
	}
	
	private ListNode sort(ListNode head, ListNode end) {
		// TODO Auto-generated method stub
		int key=head.val;
		ListNode pre=head;
		ListNode current=head.next;
		while(current!=end) {
			if(current.val<key) {
				pre=pre.next;
				swap(pre,current);
			}
			current=current.next;
		}
		swap(head,pre);	
		return pre;
	}
	
	private void swap(ListNode pre, ListNode current) {
		// TODO Auto-generated method stub
		int tmp=pre.val;
		pre.val=current.val;
		current.val=tmp;
		
	}
	
	//链表的冒泡排序
	public void bubbosort(ListNode head) {
		ListNode pre=head;
		ListNode end=null;
		while(pre!=end) {
			while(pre.next!=end) {
				if(pre.val>pre.next.val) {
					swap(pre,pre.next);
				}
				pre=pre.next;
			}
			end=pre;
			pre=head;
		}
	}
	
	//链表的选择排序
	public void selection(ListNode head) {
		ListNode pre=head;
		while(pre!=null) {
			ListNode tmp=pre;
			ListNode current=pre.next;
			while(current!=null) {
				if(tmp.val>current.val) {
					swap(tmp,current);
				}
				current=current.next;
			}
			pre=pre.next;
		}
	}
	
	//根结点到叶子总和
	public int add(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		HashMap<TreeNode,TreeNode> hashMap = new HashMap<>();
		ArrayList<TreeNode> list = new ArrayList<>();
		queue.add(root);
		hashMap.put(root, root);
		while(queue.size()!=0) {
			TreeNode node = queue.poll();
			if(node.left!=null) {
				hashMap.put(node.left, node);
			}
			if(node.right!=null) {
				hashMap.put(node.right, node);
			}
			if(node.left==null && node.right==null) {
				list.add(node);
			}
		}
		int i=0;
		int sum=0;
		while(i<list.size()) {
			TreeNode node = list.get(i);
			int nodeValue=node.val;
			int k=1;
			while(node!=root) {
				 nodeValue=nodeValue*k;
				 sum=sum+nodeValue;
				 node = hashMap.get(node);
				 k=k*10;
			}
		}
		
		return sum;
	}
	
	//给出链表，使得每个节点包含一个附加的随机指针，该指针可以指向列表中的任何节点或为空。返回列表的深层副本。
    public ListNode2 get(ListNode2 head) {
    	ListNode2 current=head;
    	//复制节点
    	while(current!=null) {
    		ListNode2 node = new ListNode2(current.val);
    		node.next=current.next;
    		current.next=node;
    		current=current.next.next;
    	}
    	current=head;
    	//随机节点
    	while(current.next!=null) {
    		if(current.random!=null) {
    			current.next.random=current.random.next;
    		}
    		current=current.next.next;
    	}
    	//分离出新节点
    	ListNode2 pre=head.next;
    	while(head.next!=null) {
    		ListNode2 newNode=head.next;
    		head.next=newNode.next;
    		if(newNode.next!=null) {
    			newNode.next=newNode.next.next;
    		}
    		head=head.next;
    	}
    	return pre;
    }

    //数组中出现超过三次的数字也可以是多次出现的数字
    public int getSinglenumber(int[] array) {
    	if(array.length==0 || array==null) {
    		return -1;
    	}
    	int result=0;
    	//int为4个字节，那么一共有4*8=32位
    	for(int i=0;i<32;i++) {
    		//保存每一位求和值
    		int sum=0;
    		for(int j=0;j<array.length;j++) {
    			//累加所有数字上第i位上的数字
    			sum=sum+(array[j]>>i);
    		}
    		//取余得到第i位上的数字，之后更新result
    		result=result | ((sum % 3)<<i);
    	}
    	return result;
    }
    
	//加油站问题贪婪算法
	public int cancomplete(int[] gas, int[] cost) {
		for (int i = 0; i < gas.length; i++) {
			//计算节点后面的累计汽油
			int number = 0;
			for (int j = i; j < gas.length; j++) {
				number = number + gas[j] - cost[j];
				if (number < 0) {
					break;
				}
			}
			if (i==0 && number>=0) {
				return 0;
			}
			//计算节点前面的累计汽油
			if (i>0 && number>=0) {
				for(int j=0;j<i;j++) {
					number=number+gas[j]-cost[j];
					if(number<0) {
						return -1;
					}
				}
				if(number>=0) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(6);
		int[] gas= {6,0,1,3,2};
		int[] cost= {4,5,2,5,5};
		listNode1.next=listNode2;
		listNode2.next=listNode3;
		listNode3.next=listNode4;
		listNode4.next=listNode5;
		listNode5.next=listNode6;
		Test test = new Test();
//		test.reverseLinkedlist(listNode1);
//		System.out.println(test.add(-1, -2));
//		test.insertionSortList(listNode1);
//		test.print(4);
		System.out.println(test.cancomplete(gas, cost));
	}
	
}
