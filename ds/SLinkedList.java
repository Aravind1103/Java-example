package com.example.demo.ds;

public class SLinkedList {

    Node head;

    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;

        Node(int d) {data = d; next = null; }
    }

    public void insertAtFirst(int data){
        Node new_node = new Node(data);
        if(head == null){
           head = new_node;
        }
        else{
            new_node.next = head;
            head = new_node;
        }
    }

    public void insertAtEnd(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
        }
        else {
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new_node;
        }
    }

    public void insertAfter(Node prevNode, int data) {
        Node temp = head;
        while(temp != prevNode){
            temp = temp.next;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void insertAfter(int data, int x) {
        Node temp = head;
        Node newNode = new Node(data);
        if(x == 1) {
            newNode.next = head;
            head = newNode;
        }
        else{
            while(temp.next != null && x-1 > 1){
                temp = temp.next;
                x--;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void deleteNode(int x){
        Node temp = head;
        if(x == 1) {
            head = temp.next;
        }
        else{
            while(temp.next != null && x-1 > 1){
                temp = temp.next;
                x--;
            }
            Node temp1 = temp.next;
            temp.next = temp1.next;
        }
    }

    public void insertBefore(Node nextNode, int data) {
        Node temp = head;
        while(temp.next != nextNode){
            temp = temp.next;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr =next;
        }
        head = prev;
    }

    public void printListInReverse(Node head) {
        if(head == null){
            return;
        }
        printListInReverse(head.next);
        System.out.print(head.data + " ");
    }

    public void printListRecursive(Node head) {
        if(head == null){
            return;
        }
        System.out.print(head.data + " ");
        printListRecursive(head.next);
    }

    public void reverseRecursive(Node node) {
        if(node.next == null){
            head = node;
            return;
        }
        reverseRecursive(node.next);
        Node temp = node.next;
        temp.next = node;
        node.next = null;

    }
    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SLinkedList linkedList = new SLinkedList();
        linkedList.printList();
        linkedList.insertAtFirst(1);
        linkedList.printList();
        linkedList.insertAtFirst(0);
        linkedList.printList();
        linkedList.insertAtEnd(2);
        linkedList.printList();
        linkedList.insertAfter(linkedList.head, 3);
        linkedList.printList();
        linkedList.insertAfter(linkedList.head.next, 4);
        linkedList.printList();
        linkedList.insertAfter(linkedList.head, 6);
        linkedList.printList();
        linkedList.insertBefore(linkedList.head.next.next.next, 5);
        linkedList.printList();
        linkedList.reverse();
        System.out.print("Reverse: ");
        linkedList.printList();
        System.out.print("Print in Reverse: ");
        linkedList.printListInReverse(linkedList.head);
        System.out.print("Print in Recursive: ");
        linkedList.printListRecursive(linkedList.head);
        linkedList.reverseRecursive(linkedList.head);
        System.out.print("Reverse Recursive: ");
        linkedList.printList();
        linkedList.insertAfter(8,2);
        linkedList.printList();
        linkedList.deleteNode(3);
        linkedList.printList();

    }
}
