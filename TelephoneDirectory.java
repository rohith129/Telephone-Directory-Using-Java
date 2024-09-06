import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class TelephoneDirectory  implements ActionListener
{
    	
    JFrame frame;
    JTextField t1,t2,t3,t4;
    JLabel l1,l2,l3,l4;
    JButton clear ,next ,submit;
    TelephoneDirectory()
    {
        frame = new JFrame("TELEPHONE DIRECTORY");
        t1 = new JTextField(15);
        t1.setBounds(150,50,100,20);
        t2 = new JTextField(15);
        t2.setBounds(150,80,100,20);
        t3 = new JTextField(15);
        t3.setBounds(150,110,100,20);
        t4 = new JTextField(15);
        t4.setBounds(150,140,100,20);
        l1 = new JLabel("Name   :");
        l1.setBounds(50,50,80,20);
        l2 = new JLabel("Number :");
        l2.setBounds(50,80,80,20);
        l3 = new JLabel("Address:");
        l3.setBounds(50,110,80,20);
        l4 = new JLabel("Pincode:");
        l4.setBounds(50,140,80,20);

        clear = new JButton("Clear");
        clear.setBounds(40,200,80,30);
        next  = new JButton("Next");
        next.setBounds(250,200,80,30);
        submit = new JButton("Submit");
        submit.setBounds(150,250,80,30);
        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        frame.add(t4);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(clear);
        frame.add(next);
        frame.add(submit);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,500);
        frame.setLayout(null);
        frame.setVisible(true);
	
        clear.addActionListener(this);
        next.addActionListener(this);
        submit.addActionListener(this);
        
        clear.setActionCommand("Clear");
        next.setActionCommand("Next");
        submit.setActionCommand("Submit");
    }

	    	public void actionPerformed(ActionEvent e)
		{
	    	String command = e.getActionCommand();
			if("Clear".equals(command))
			{	t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
			}
			else if("Next".equals(command))
			{
				Contacts ob = new Contacts();
				ob.addContact(t1.getText(),t2.getText(),t3.getText(),t4.getText());
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
			}
			else if("Submit".equals(command))
			{
				frame.setVisible(false);
			}

		}
	  
	public static void main (String args[])
	{
		 Scanner scanner = new Scanner(System.in);
		 Contacts obj = new Contacts();
	        while (true) {
	            System.out.println("\n1. Add Contact");
	            System.out.println("2. Search Contact");
	            System.out.println("3. Display All Contacts");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character after reading the integer

	            switch (choice) {
	                case 1:
	                  	TelephoneDirectory tp = new TelephoneDirectory();
	                  	
	                    break;
	                case 2:
	                    
			    System.out.println("Enter the name to search the contact details :");
			    String name = scanner.nextLine();
			    obj.searchContact(name);
	                    break;
	                case 3:
	                	
	                	obj.display();
	                    break;
	                case 4:
	                    System.out.println("Exiting the telephone directory.");
	                    scanner.close();
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }	
		
      
   	 }
	
}

class Contacts
{
	class Node
	{
		String name;
		String number;
		String address;
		String pincode;
		Node next;
		Node(String name,String number,String address,String pincode)
		{
		
			this.name =name;
			this.number =number;
			this.address =address;
			this.pincode =pincode;
			this.next = null;
		}
	}
	static Node head = null;
	static Node tail = null;
	
	void addContact(String name, String number, String address, String pincode)
	{
		Node newnode = new Node(name,number,address,pincode); 
		if(head == null)
		{
			head = newnode ;
			tail = newnode ;
		}
		else
		{
			tail.next = newnode;
			tail = newnode;
		}
	}
	
	void display()
	{
		Node temp = head;
		if(head == null)
		{
			System.out.println("Contact list is Empty.");
		}
		else
		{
			System.out.println("\n\nTelephone Directory:");
			System.out.println("-----------------------------------------------------------------------------");
			while(temp != null)
			{
				System.out.print("Name :"+temp.name);
				System.out.print("\tNumber :"+temp.number);
				System.out.print("\tAddress :"+temp.address);
				System.out.println("\tPincode :"+temp.pincode+"\n");
				temp = temp.next;
			}
			System.out.println("-----------------------------------------------------------------------------");
		}
	}
	void searchContact(String name)
	{
		Node temp = head;
		while(temp!=null)
		{
			if(temp.name.equals(name))
			{
				System.out.println("-----------------------------------------------------------------------------");
				System.out.print("Name :"+temp.name);
				System.out.print("\tNumber :"+temp.number);
				System.out.print("\tAddress :"+temp.address);
				System.out.println("\tPincode :"+temp.pincode);
				System.out.println("-----------------------------------------------------------------------------");
				return;
			}
			temp = temp.next;
		}
		System.out.println(name+" is not found in the directory");
	} 
	
}
