package myphonebook;

public class Contacts {
	public class Node {
		String name;
		String number;
		String address;
		String pincode;
		Node next;

		Node(String name, String number, String address, String pincode) {

			this.name = name;
			this.number = number;
			this.address = address;
			this.pincode = pincode;
			this.next = null;
		}
	}

	static Node head = null;
	static Node tail = null;

	Node addContact(String name, String number, String address, String pincode) {
		Node newnode = new Node(name, number, address, pincode);

		if (head == null) {
			head = newnode;
			tail = newnode;
		} else {
			tail.next = newnode;
			tail = newnode;
		}
		return head;
	}

}