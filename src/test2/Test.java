package test2;

import java.util.LinkedList;
import java.util.Queue;

import test.TreeNode;

public class Test {

	//找出二叉树的最小深度
	public int depth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null && root.right==null) {
			return 1;
		}
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		int depth=0;
		while(queue.size()!=0) {
			int size = queue.size();
			depth++;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if(node.left!=null) {
					queue.add(node.left);
				}
				if(node.right!=null) {
					queue.add(node.right);
				}
				if(node.left==null && node.right==null) {
					return depth;
				}
			}
		}
		return depth;
	}
}
