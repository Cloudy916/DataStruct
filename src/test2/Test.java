package test2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import test.Point;
import test.TreeNode;

public class Test {

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
}
