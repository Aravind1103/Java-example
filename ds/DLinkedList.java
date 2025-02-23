package com.example.demo.ds;

public class DLinkedList {

    class DNode
    {
        int data;
        DNode prev;
        DNode next;

        DNode(int d) {
            data = d;
            prev = null;
            next = null;
        }
    }

    DNode head;

    public void insert(int data) {
        DNode newNode = new DNode(data);
        if(head == null) {
            head = newNode;
        }
        else {
            DNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public void delete(int x) {
        if(head == null) {
            System.out.println("Already Empty");
            return;
        }
        if(x == 1){
            head = head.next;
            System.out.println("List Emptied");
        }
        else {
            DNode temp = head;
            while(temp.next != null && x-1 > 1){
                temp = temp.next;
                x--;
            }
            if(temp.next == null) {
                if(temp.prev == null) {
                    head = null;
                    System.out.println("List Emptied");
                    return;
                }
                temp.prev.next = null;
                return;
            }
            DNode temp1 = temp.next;
            temp1.prev.next = temp1.next;
            temp1.next.prev = temp1.prev;
        }
    }

    public void print() {
        DNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DLinkedList linkedList = new DLinkedList();

        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.print();
        linkedList.delete(2);
        linkedList.print();
        linkedList.delete(5);
        linkedList.print();
        linkedList.delete(5);
        linkedList.print();
        linkedList.delete(2);
        linkedList.print();
        linkedList.delete(2);
    }
}
