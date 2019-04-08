package test2;

import java.util.Stack;

import test.TreeNode;

public class Test2 {

	public static void Print1ToMaxOfNDigits_2(int n) {
		if (n <= 0) {
			return;
		}
		StringBuffer number = new StringBuffer();
		for (int i = 0; i < n; i++) {
			number.append('0');
		}
		while (!Increment(number)) {
			PrintNumber(number);
		}
	}

	public static boolean Increment(StringBuffer s) {
		boolean isOverflow = false;
		int nTakeOver = 0;
		int nLength = s.length();
		for (int i = nLength - 1; i >= 0; i--) {
			int nSum = s.charAt(i) - '0' + nTakeOver;
			if (i == nLength - 1) {
				nSum++;
			}
			if (nSum >= 10) {
				if (i == 0) {
					isOverflow = true;
				} else {
					nSum -= 10;
					nTakeOver = 1;
					s.setCharAt(i, (char) ('0' + nSum));
				}
			} else {
				s.setCharAt(i, (char) ('0' + nSum));
				break;
			}
		}
		return isOverflow;
	}

	public static void PrintNumber(StringBuffer s) {
		boolean isBeginning0 = true;
		for (int i = 0; i < s.length(); i++) {
			if (isBeginning0 && s.charAt(i) != '0') {
				isBeginning0 = false;
			}
			if (!isBeginning0) {
				System.out.print(s.charAt(i));
			}
		}
		System.out.println();
	}

	public static void Print1ToMaxOfNDigits_3(int n) {
		if (n < 0) {
			return;
		}
		StringBuffer s = new StringBuffer(n);
		for (int i = 0; i < n; i++) {
			s.append('0');
		}
		for (int i = 0; i < 10; i++) {

			s.setCharAt(0, (char) (i + '0'));
			Print1ToMaxOfNDigits_3_Recursely(s, n, 0);
		}

	}

	public static void Print1ToMaxOfNDigits_3_Recursely(StringBuffer s, int n, int index) {
		if (index == n - 1) {
			PrintNumber(s);
			return;
		}
		for (int i = 0; i < 10; i++) {
			s.setCharAt(index + 1, (char) (i + '0'));
			Print1ToMaxOfNDigits_3_Recursely(s, n, index + 1);
		}
	}

	public TreeNode ConvertBSTToBiList(TreeNode root) {
		if (root == null)
			return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		TreeNode pre = null;// 用于保存中序遍历序列的上一节点
		boolean isFirst = true;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			p = stack.pop();
			if (isFirst) {
				root = p;// 将中序遍历序列中的第一个节点记为root
				pre = root;
				isFirst = false;
			} else {
				pre.right = p;
				p.left = pre;
				pre = p;
			}
			p = p.right;
		}
		return root;
	}

	public static void main(String[] args) {
		Test2.Print1ToMaxOfNDigits_3(2);
		Test2 test2 = new Test2();
		test2.ConvertBSTToBiList(null);
	}
}
