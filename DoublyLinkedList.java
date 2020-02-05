/**
 * The below is an implementation of DoublyLinkedList data structure It also has implementations
 * such as:
 *
 * <p>1. push - to add new elements
 *
 * <p>2. invert - to invert the existing list
 *
 * <p>3. display - to print elements of the linked list.
 */
 
 public class DoublyLinkedList {
  LinkedNode head;
  LinkedNode tail;

  class LinkedNode {
    Integer data;
    LinkedNode previous;
    LinkedNode next;

    public LinkedNode(Integer data) {
      this.data = data;
    }
  }

  public void push(Integer data) {
    LinkedNode linkedNode = new LinkedNode(data);
    if (head == null) {
      head = tail = linkedNode;
      head.previous = null;
      head.next = null;
    } else {
      tail.next = linkedNode;
      linkedNode.previous = tail;
      tail = linkedNode;
      tail.next = null;
    }
  }

  public void display(DoublyLinkedList doublyLinkedList) {
    LinkedNode linkedNode = doublyLinkedList.head;
    if (linkedNode == null) {
      System.out.println("Empty List");
      return;
    }

    while (linkedNode != null) {
      if (linkedNode.next != null) {
        System.out.print(linkedNode.data + " -> ");
      } else {
        System.out.print(linkedNode.data);
      }
      linkedNode = linkedNode.next;
    }

    System.out.println("\n============================");
  }

  public DoublyLinkedList invert(DoublyLinkedList doublyLinkedList) {
    DoublyLinkedList invertedDoublyLinkedList = new DoublyLinkedList();
    LinkedNode linkedNode = doublyLinkedList.tail;
    while (linkedNode != null) {
      invertedDoublyLinkedList.push(linkedNode.data);
      linkedNode = linkedNode.previous;
    }
    return invertedDoublyLinkedList;
  }

  public static void main(String[] args) {
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    doublyLinkedList.push(1);
    doublyLinkedList.push(4);
    doublyLinkedList.push(3);

    System.out.print("Doubly Linked List :: ");
    doublyLinkedList.display(doublyLinkedList);
    DoublyLinkedList invertedDoublyLinkedList = doublyLinkedList.invert(doublyLinkedList);
    System.out.print("Inverted Doubly Linked List :: ");
    invertedDoublyLinkedList.display(invertedDoublyLinkedList);
  }
}
