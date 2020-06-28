package com.chanpter1.oop;
/**
 * ============================================
 * 递归算法是一种直接或者间接的调用自身的过程
 * 在计算机程序编写中，递归算法对解决一大类的问题是十分有效的
 * 它往往使算法的描述简洁而且易于理解
 *   注意：1,递归必需要有出口  2，递归内存消耗大，容易发生内存溢出 3，层次调用越多，越危险
 *   面试题：100或50阶乘是多少  答案：0 
 * 在链表数据结构中，我们需要使用到递归算法   
 *  ==============================链表=================================================== 
 * 链表：一种常见的基础数据结构，是一种线性表，但是并不是按线性的顺序存储数据
 * 		而是在每一个结点里面存到下一个结点的指针（pointer）
 * 
 * 	 链表与数组：线性数据结构
 * 		数组适合做查找，遍历。固定长度
 * 		链表适合做插入，删除。不宜过长，否则导致遍历性能下降
 * ===================================================================================
 * 
 *@version:
 *@Description: 
 *@author :衡晶
 *@date:2019年9月18日 下午3:26:03
 */
public class LinkedDesc {
	public static void main(String[] args) {
//		int result=factorial(5);
//		result=recursion(5);
//		System.out.println(result);
		
		NodeManager nm=new NodeManager();
		System.out.println("==============add=====================");
		nm.add(5);
		nm.add(4);
		nm.add(3);
		nm.add(2);
		nm.add(1);
		nm.print();
		System.out.println("===============del====================");
		nm.del(4);
		nm.del(2);
		nm.del(3);
		nm.print();
		System.out.println("===============find====================");
		System.out.println(nm.find(1));//true
		System.out.println(nm.find(2));//false
		System.out.println("===============update===============");
		nm.update(1, 10);
		nm.print();
		System.out.println("===============insert===============");
		nm.insert(1, 7);
		nm.print();
		
	}

	private static int recursion(int num) {
		if(num == 1 || num == 0) return 1;
		return num*recursion(num-1);
	}

	private static int factorial(int num) {
		int result = num;
		int i = num - 1;
		
		do{
			result = result * i;
			i--;
		}while(i>1);
		
		return result;
	}
}

class NodeManager{
	private Node root;//根结点
	private int currentIndex = 0;//结点的序号，每次操作从零开始
	
	public void add(int data){
		if (null == root) {
			root = new Node(data);
		} else {
			root.addNode(data);
		}
	}
	public void del(int data){
		if(root==null){return;}
		if(root.getData()==data){
			root = root.next;
		}else{
			root.delNode(data);
		}
	}
	
	//打印所有
	public void print(){
		if(root != null){
			System.out.print(root.getData()+"-->");
			root.printNode();
			System.out.println();
		}
		
	}

	public boolean find(int data) {
		if (root == null) {
			return false;
		}
		if (root.getData() == data) {
			return true;
		} else {
			return root.findNode(data);
		}
	}
	public boolean update(int oldData,int newData){
		if(root==null){
			return false;
		}
		if(root.getData()==oldData){
			root.setData(newData);
			return true;
		}else{
			return root.updateNode(oldData, newData);
		}
	}
	public void insert(int index,int data){
		if(index<0){
			return;
		}
		currentIndex = 0;
		if(index==currentIndex){
			Node newNode=new Node(data);
			//前插入 向索引之前插入
			newNode.next = root;
			root = newNode;
		}else{
			root.insertNode(index, data);
		}
		
	}
	
	private class Node{
		private int data;//数据
		private Node next;//本类做为属性
		// 添加结点
		public void addNode(int data) {
			if(this.next == null){
				this.next = new Node(data);
			}else{
				this.next.addNode(data);
			}
		}

		// 删除结点
		public void delNode(int data) {
			if(this.next!=null){
				if(this.next.data==data){
					this.next=this.next.next;
				}else{
					this.next.delNode(data);
				}
			}
		}

		// 查询所有结点
		public void printNode() {
			if(this.next!=null){
				System.out.print(this.next.data+"-->");
				this.next.printNode();
			}
		}

		// 查找结点
		public boolean findNode(int data) {
			if(this.next!=null){
				if(this.next.getData()==data){
					return true;
				}else{
					return this.next.findNode(data);
				}
			}
			return false;
		}

		// 修改结点
		public boolean updateNode(int oldData, int newData) {
			if(this.next!=null){
				if(this.next.data==oldData){
					this.next.data=newData;
					return true;
				}else{
					return this.next.updateNode(oldData, newData);
				}
			}
			return false;
		}

		// 插入结点
		public void insertNode(int index, int data) {
			currentIndex++;
			if(index==currentIndex){
				Node newNode = new Node(data);
				//前插入
				newNode.next = this.next;
				this.next = newNode;
			}else{
				this.next.insertNode(index, data);
			}
		}
		
		
		
		public Node(int data){ this.data=data;}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		
	}
}


