package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTest {

	public void pre(TreeNode root) {
		if(root==null) {
			return ;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current=root;
		while(current!=null || stack.size()!=0) {
			while(current!=null) {
				stack.push(current);
				System.out.println(current.val+"-->");
				current=current.left;
			}
			
			if(stack.size()!=0) {
				 current = stack.pop();
				 current=current.right;
			}
		}
	}
	
	public void pre2(TreeNode root) {
		if(root==null) {
			return ;
		}
		System.out.println(root.val+"-->");
	    pre2(root.left);
	    pre2(root.right);
	}
	
	public void in(TreeNode root) {
		if(root==null) {
			return ;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current=root;
		while(current!=null || stack.size()!=0) {
			while(current!=null) {
				stack.push(current);
				current=current.left;
			}
			
			if(stack.size()!=0) {
				current = stack.pop();
				System.out.println(current.val+"-->");
				current=current.right;
			}
		}
	}
	
	public void post(TreeNode root) {
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		stack1.push(root);
		while(stack1.size()!=0) {
			TreeNode node = stack1.pop();
			stack2.push(node);
			if(node.left!=null) {
				stack1.push(node.left);
			}
			if(node.right!=null) {
				stack1.push(node.right);
			}
		}
		while(stack2.size()!=0) {
			System.out.println(stack2.pop().val+"-->");
		}
	}
	
	public void mid(TreeNode root) {
		if(root==null) {
			return ;
		}
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		while(queue.size()!=0) {
			TreeNode node = queue.poll();
			System.out.println(node.val+"-->");
			if (node.left!=null) {
				queue.add(node.left);
			}
			if(node.right!=null) {
				queue.add(node.right);
			}
		}
	}
	
	public int getNodeNum(TreeNode root) {
		if(root==null) {
			return 0;
		}
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		int count=1;
		while(queue.size()!=0) {
			TreeNode node = queue.poll();
			if (node.left!=null) {
				queue.add(node.left);
				count++;
			}
			if(node.right!=null) {
				queue.add(node.right);
				count++;
			}
		}
		return count;
	}
	
	public int getDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		int depth=0;
		int levelcount=1;
		int nextLevelcount=0;
		while(queue.size()!=0) {
			TreeNode node = queue.poll();
			levelcount--;
			if(node.left!=null) {
				queue.add(node.left);
			    nextLevelcount++;
			}
			if(node.right!=null) {
				queue.add(node.right);
				nextLevelcount++;
			}
			if(levelcount==0) {
				levelcount=nextLevelcount;
				depth++;
				nextLevelcount=0;
			}
		}
		return depth;
	}
	
	public int getKthNum(TreeNode root,int k) {
		if(root==null) {
			return 0;
		}
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		int levelcount=1;
		int level=0;
		while(queue.size()!=0) {
			level++;
			levelcount=queue.size();
			if(level==k) {
				break;
			}
			int i=0;
			while(i<levelcount) {
				TreeNode node = queue.poll();
				if(node.left!=null) {
					queue.add(node.left);
				}
				if(node.right!=null) {
					queue.add(node.right);
				}
				i++;
			}
		}
		if(levelcount==k) {
			return levelcount;
		}
		return 0;
	}
	
	public int getKthLevel(TreeNode root,int k) {
		if(root==null) {
			return 0;
		}
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		int level=0;
		int levelcount=1;
		while(queue.size()!=0) {
			level++;
			levelcount=queue.size();
			if(level==k) {
				break;
			}
			int i=0;
			while(i<levelcount) {
				TreeNode node = queue.poll();
				if(node.left!=null) {
					queue.add(node.left);
				}
				if(node.right!=null) {
					queue.add(node.right);
				}
				i++;
			}
		}
		
		if(level==k) {
			int i=0;
			int leafcount=0;
			while(i<levelcount) {
				TreeNode node = queue.poll();
				if(node.left==null && node.right==null) {
					leafcount++;
				}
				i++;
			}
			return leafcount;
		}
		
		return 0;
	}
	
	public int getLeaf(TreeNode root) {
		if(root==null) {
			return 0;
		}
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		int countleaf=0;
		while(queue.size()!=0) {
			TreeNode node = queue.poll();
			if(node.left==null&&node.right==null) {
				countleaf++;
			}
			if(node.left!=null) {
				queue.add(node.left);
			}
			if(node.right!=null) {
				queue.add(node.right);
			}
		}
		return countleaf;
	}
	
	public boolean strcutSame(TreeNode root1, TreeNode root2) {
		if(root1==null && root2==null) {
			return true;
		}else if(root1==null && root2!=null) {
			return false;
		}else if(root1!=null && root2==null) {
			return false;
		}
		
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		stack1.push(root1);
		stack2.push(root2);
		while(stack1.size()!=0 && stack2.size()!=0) {
			TreeNode node1 = stack1.pop();
			TreeNode node2 = stack2.pop();
			if(node1==null && node2==null) {
				continue;
			}else if(node1!=null && node2!=null && node1.val==node2.val){
				stack1.push(node1.left);
				stack2.push(node2.left);
				stack1.push(node2.right);
				stack2.push(node2.right);
			}else {
				return false;
			}
		}
		return true;
	}
	
	public boolean isAVL(TreeNode root) {
		 if(root==null) {
			 return true;
		 }
		 if(Math.abs(getDepth(root.left)-getDepth(root.right))>1) {
			 return false;
		 }
		 return isAVL(root.left)&&isAVL(root.right);
	}
	
	public boolean bST(TreeNode root) {
		
		if(root==null) {
			return false;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while(root!=null || stack.size()!=0) {
			
			while(root!=null) {
				stack.push(root.left);
				root=root.left;
			}
			if(stack.size()!=0) {
				 root = stack.pop();
				 if(pre!=null && pre.val<root.val) {
					 return false;
				 }
				 pre=root;
				 root=root.right;
			}
		}
		return true;
		
	}
	
	public boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		boolean flag=false;
		while(queue.size()!=0) {
			TreeNode node = queue.poll();
			if(flag) {
				if(node.left==null || node.right==null) {
					return false;
				}
			}
			if(node.left!=null && node.right!=null) {
				queue.add(node.left);
				queue.add(node.right);
			}else if(node.left!=null && node.right==null) {
				queue.add(node.left);
				flag=true;
			}else if(node.left==null && node.right!=null) {
				return false;
			}else {
				flag=true;
			}
		}
		return true;
	}
	
	
}
