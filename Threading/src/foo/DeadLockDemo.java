package foo;

import java.util.ArrayList;
import java.util.List;

public class DeadLockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableObject runn = new RunnableObject();
		Thread t1 = new Thread(runn);
		Thread t2 = new Thread(runn);
		t1.start();
		t2.start();
	}

}

class RunnableObject implements Runnable{
	TreeNode parent = new TreeNode();
	TreeNode child = new TreeNode();
	boolean flag = true;
	public void run(){
		if(flag){
			flag = false;
		parent.addChild(child);
		} else {
		child.setParent(parent);
		}
	}
}
class TreeNode{
	TreeNode parent;
	List childList = new ArrayList();
	
	public synchronized void addChild(TreeNode child){
		System.out.println("addChild");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!childList.contains(child)){
			childList.add(child);
			child.setParentOnly(this);
		}
	}
	
	public synchronized void addChildOnly(TreeNode child){
		System.out.println("addChildOnly");
		if(!childList.contains(child)){
			childList.add(child);
		}
	}
	
	public synchronized void setParent(TreeNode parent){
		System.out.println("setParent");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.parent = parent;
		parent.addChildOnly(this);
	}
	
	public synchronized void setParentOnly(TreeNode parNode){
		System.out.println("setParentOnly");
		this.parent = parNode;
	}
}
