package com.chanpter1.oop;
/**
 * ============================================
 * �ݹ��㷨��һ��ֱ�ӻ��߼�ӵĵ�������Ĺ���
 * �ڼ���������д�У��ݹ��㷨�Խ��һ�����������ʮ����Ч��
 * ������ʹ�㷨�������������������
 *   ע�⣺1,�ݹ����Ҫ�г���  2���ݹ��ڴ����Ĵ����׷����ڴ���� 3����ε���Խ�࣬ԽΣ��
 *   �����⣺100��50�׳��Ƕ���  �𰸣�0 
 * ���������ݽṹ�У�������Ҫʹ�õ��ݹ��㷨   
 *  ==============================����=================================================== 
 * ����һ�ֳ����Ļ������ݽṹ����һ�����Ա����ǲ����ǰ����Ե�˳��洢����
 * 		������ÿһ���������浽��һ������ָ�루pointer��
 * 
 * 	 ���������飺�������ݽṹ
 * 		�����ʺ������ң��������̶�����
 * 		�����ʺ������룬ɾ�������˹����������±��������½�
 * ===================================================================================
 * 
 *@version:
 *@Description: 
 *@author :�⾧
 *@date:2019��9��18�� ����3:26:03
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
	private Node root;//�����
	private int currentIndex = 0;//������ţ�ÿ�β������㿪ʼ
	
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
	
	//��ӡ����
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
			//ǰ���� ������֮ǰ����
			newNode.next = root;
			root = newNode;
		}else{
			root.insertNode(index, data);
		}
		
	}
	
	private class Node{
		private int data;//����
		private Node next;//������Ϊ����
		// ��ӽ��
		public void addNode(int data) {
			if(this.next == null){
				this.next = new Node(data);
			}else{
				this.next.addNode(data);
			}
		}

		// ɾ�����
		public void delNode(int data) {
			if(this.next!=null){
				if(this.next.data==data){
					this.next=this.next.next;
				}else{
					this.next.delNode(data);
				}
			}
		}

		// ��ѯ���н��
		public void printNode() {
			if(this.next!=null){
				System.out.print(this.next.data+"-->");
				this.next.printNode();
			}
		}

		// ���ҽ��
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

		// �޸Ľ��
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

		// ������
		public void insertNode(int index, int data) {
			currentIndex++;
			if(index==currentIndex){
				Node newNode = new Node(data);
				//ǰ����
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


