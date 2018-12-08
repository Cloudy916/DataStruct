package test;

public class RBTreeTest {

	private RBNode<Integer> root;
	private static boolean RED=false;
	private static boolean BLACK=true;
	
	public boolean isRed(RBNode<Integer> node) { //判断节点的颜色
		return (node != null)&&(node.color == RED)? true : false;
	}
	
	public boolean isBlack(RBNode<Integer> node) {
		return !isRed(node);
	}
	
	public void setRed(RBNode<Integer> node) { //设置节点的颜色
		if(node != null) 
			node.color = RED;
	}
	
	public void setBlack(RBNode<Integer> node) {
		if(node != null) {
			node.color = BLACK;
		}
	}


	public void leftRotate(RBNode<Integer> x) {
		RBNode<Integer> y = x.right;
		x.right = y.left;
		if (y.left != null) {
			y.left.parent = x;
		}

		y.parent = x.parent;

		if (x.parent == null) {
			this.root = y;
		} else {
			if (x == x.parent.left) {
				x.parent.left = y;
			} else {
				x.parent.right = y;
			}
		}

			y.left = x;
			x.parent = y;
	}

	public void rightRotate(RBNode<Integer> y) {
       RBNode<Integer> x = y.left;
       y.left=x.right;
       
       if(x.right!=null) {
    	   x.right.parent=y;
       }
       
       x.parent=y.parent;
       if(y.parent==null) {
    	   this.root=x;
       }else {
    	   if(y==y.parent.right) {
    		   y.parent.right=x;
    	   }else {
    		   y.parent.left=x;
    	   }
       }
       
       x.right=y;
       y.parent=x;
	}
	
	public void insert(int key) {
		RBNode<Integer> node = new RBNode<>(key, false, null, null, null);
		RBNode<Integer> pre=null;
		RBNode<Integer> current=root;
		while(current!=null) {
			pre=current;
			if(current.key>node.key) {
				current=current.left;
			}else {
				current=current.right;
			}
		}
		node.parent=pre;
		if(pre!=null) {
			if(node.key<pre.key) {
				pre.left=node;
			}else {
				pre.right=node;
			}
		}else {
			this.root=node;
		}
		insertRBtree(node);
	}

	private void insertRBtree(RBNode<Integer> node) {
		// TODO Auto-generated method stub
		
	}
}
