package test;

public class RBNode<Integer> {

	boolean color;
	int key;
	RBNode<Integer> left;
	RBNode<Integer> right;
	RBNode<Integer> parent;
	
	public RBNode(int key,boolean color,RBNode<Integer> parent,RBNode<Integer> left,RBNode<Integer> right) {
		this.color=color;
		this.left=left;
		this.right=right;
		this.key=key;
		this.parent=parent;
	}
	
	public int getKey() {
		return this.key;
	}
	
}
