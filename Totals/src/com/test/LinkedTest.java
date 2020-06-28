package com.test;

public class LinkedTest {
	public static void main(String[] args) {
		NodeManager nm = new NodeManager();
		System.out.println("-----------添加数据------------------");
		nm.add(0);
		nm.add(1);
		nm.add(2);
		nm.add(3);
		nm.add(4);
		nm.add(5);
		nm.print();
		System.out.println("------------查询指定元素-----------------");
		System.out.println(nm.find(5));
		System.out.println(nm.find(9));
		System.out.println("------------修改元素-----------------");
		nm.update(5, 10);
		nm.print();
		System.out.println("------------删除元素-----------------");
		nm.del(0);
		nm.del(3);
		nm.del(10);
		nm.print();
		System.out.println(nm.size());
		System.out.println("------------插入元素-----------------");
		nm.insert(1, 30);
		nm.print();
		System.out.println(nm.size());
		nm.insert(3, 11);
		nm.print();
		System.out.println(nm.size());
	}
}

class NodeManager {
	private Node root;// 根节点

	private int count = 0;

	private int currentIndex = 0;

	public void add(int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			root.addNode(data);
		}
	}

	public void print() {
		if (root != null) {
			System.out.print(root.data + "-->");
			root.printNode();
			System.out.println();
		}
	}

	public boolean find(int data) {
		if (root == null) {
			return false;
		}
		if (root.data == data) {
			return true;
		} else {
			return root.finNode(data);
		}
	}

	public void update(int oldData, int newData) {
		if (root != null) {
			if (root.data == oldData) {
				root.data = oldData;
			} else {
				root.updateNode(oldData, newData);
			}
		}
	}

	public void del(int data) {
		if (root != null) {
			if (root.data == data) {
				root = root.next;
			} else {
				root.delNode(data);
			}
		}
	}

	public void insert(int index, int data) {
		if (index < 0) {
			return;
		}
		currentIndex = 0;
		if (currentIndex == index) {
			Node newNode = new Node(data);
			newNode.next = root.next;
			root = newNode;
		} else {
			root.inserNode(index, data);
		}
	}

	public int size() {
		if (root == null) {
			return 0;
		}
		count = 0;
		return root.finNodeCont();

	}

	private class Node {
		private int data;
		private Node next;// 相当于指针 指向下个结点
		// 添加结点

		public void addNode(int data) {
			if (this.next == null) {// 有没有下个结点
				this.next = new Node(data);// 在链末端添加新的结点保存数据
			} else {
				this.next.addNode(data);// 递归遍历结点
			}
		}

		// 查询
		public void printNode() {
			if (this.next != null) {
				System.out.print(this.next.data + "-->");
				this.next.printNode();
			}
		}

		// 查找结点
		public boolean finNode(int data) {
			if (this.next != null) {
				if (this.next.data == data) {
					return true;
				} else {
					return this.next.finNode(data);
				}
			}
			return false;
		}

		public int finNodeCont() {
			count++;
			if (this.next != null) {
				this.next.finNodeCont();
			}
			return count;
		}

		// 修改结点
		public void updateNode(int oldData, int newData) {
			if (this.next != null) {
				if (this.next.data == oldData) {
					this.next.data = newData;
				} else {
					this.next.updateNode(oldData, newData);
				}
			}
		}

		public void delNode(int data) {
			if (this.next != null) {
				if (this.next.data == data) {
					this.next = this.next.next;
				} else {
					this.next.delNode(data);
				}
			}
		}

		public void inserNode(int index, int data) {
			currentIndex++;
			if (index < 0) {
				return;
			}
			if (currentIndex == index) {
				Node newNode = new Node(data);
				newNode.next = this.next;
				this.next = newNode;
			} else {
				this.next.inserNode(index, data);
			}
		}

		public Node(int data) {
			super();
			this.data = data;
		}
	}
}