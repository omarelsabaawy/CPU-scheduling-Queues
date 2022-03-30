/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiqueuescheduler;

/**
 *
 * @author Omar Mohamed Adel Elsabaawy
 */
public class list {
    Node head;
    Node tail;
    
    public void addLast(process process){
        Node node = new Node(process);
        node.next = null;
        if (head == null) {
            head = tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }
    
    public void deleteFront(){
        head = head.next;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void sortedInsert(Node new_node){
        Node current;
        if (head == null || head.process.brust_time >= new_node.process.brust_time) {
                new_node.next = head;
                head = new_node;
        }
        else {
                current = head;
                while (current.next != null && current.next.process.brust_time <= new_node.process.brust_time)
                        current = current.next;
                new_node.next = current.next;
                current.next = new_node;
        }
    }
    
    public void traverse(){
        Node n = head;
        while(n != null){
            System.out.println(n.process.process_number);
            if (n.process.complete_time > 0) {
                System.out.println("complete time: " + n.process.complete_time);
            }
            n = n.next;            
        }
    }
    
    
}

