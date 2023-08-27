import java.util.*;

class SENode {
    int value;
    SENode next;

    SENode(int val) {
        this.value = val;
    }
}

class SLLResponse {
    int responseCode;
    static String responseMsg;

    public SLLResponse(int code, String msg) {
        this.responseCode = code;
        this.responseMsg = msg;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }
}

class SinglyLinkedListADT {
    SENode head;
    SENode rear;
    int length = 0;

    public SinglyLinkedListADT() {
        head = null;
        rear = head;
        length = 0;
    }

    public SLLResponse addFront(int val) {
        SENode node = new SENode(val);
        if (length == 0) {
            head = node;
            rear = head;
        } else {
            node.next = head;
            head = node;
        }
        this.length++;
        return new SLLResponse(1, "Node added with given value.");
    }

    public SLLResponse addRear(int val) {
        SENode node = new SENode(val);
        if (length == 0) {
           return addFront(val);
        } else {
            return addAtPosition(val, length);
        }
    }

    public SLLResponse addAtPosition(int val, int pos) {
        if (pos > length || pos < 1) {
            return new SLLResponse(-1, "Invalid position specified. No node was added.");
        }
        SENode node = new SENode(val);
        SENode insertAfter = head;
        while (pos > 2) {
            pos--;
            insertAfter = insertAfter.next;
        }
        SENode first = insertAfter;
        SENode third = insertAfter.next;
        first.next = node;
        node.next = third;
        length--;
        return new SLLResponse(1, "Node added with given value.");
    }

    public SLLResponse deleteFromRear() {
        if (length < 1)
            return new SLLResponse(-1, "No node in Linked List. Deleting nothing.");
        if (length == 1) {
            head = null;
            rear = null;
            length--;
            return new SLLResponse(1, "The only node in the linked list was deleted. Linked List is now empty.");
        }
        return deleteFromPosition(length);
    }

    public SLLResponse deleteFromFront() {
        if (length < 1)
            return new SLLResponse(-1, "No node in Linked List. Deleting nothing.");
        head = head.next;
        length--;
        return new SLLResponse(1, "The only node in the linked list was deleted. Linked List is now empty.");
    }

    public SLLResponse deleteFromPosition(int pos) {
        SENode deleteAfter = this.head;
        while (pos > 2) {
            pos--;
            deleteAfter = deleteAfter.next;
        }
        SENode first = deleteAfter;
        SENode second = deleteAfter.next;
        if(second!=null)
            first.next = second.next;
        else
            rear=first;
        length--;
        return new SLLResponse(1, "The give node in the linked list was deleted.");
    }

    public int getLength() {
        return this.length;
    }

    public SLLResponse syncDetails() {
        int count = 0;
        SENode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        this.length = count;
        return new SLLResponse(1, "Singly linked list Synced");
    }

    public SLLResponse linearSearch(int val) {
        int count = 1;
        SENode node = head;
        while (node != null) {
            if (node.value == val)
                return new SLLResponse(count, "The element was found at this position : " + count);
            count++;
            node = node.next;
        }
        return new SLLResponse(count, "The element was not found");
    }

    public SLLResponse deleteParticularElement(int val)
    {
        if (this.length == 0) {
            return new SLLResponse(-1, "No node in Linked List. Deleting nothing.");
        }
        if (this.length == 1) {
            if (head.value == val) {
                head = null;
                rear = null;
            }
            this.length--;
            return new SLLResponse(1, "The only node in the linked list was deleted. Linked List is now empty.");
        }
        SENode prev = head;
        SENode curr = head.next;

        while (curr.next != null) {
            if (curr.value == val) {
                prev.next = curr.next;
                this.length--;
                break;
            }
            curr=curr.next;
            prev=prev.next;
            System.out.println(1);
        }
        return new SLLResponse(1, "All the occurences of given element were removed");
    }

    public void display() {
        System.out.println("----------");
        SENode node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println("----------");
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedListADT linkedList = new SinglyLinkedListADT();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("This is a program for Singly Linked Lists");
            System.out.println("Choose one from menu :");
            System.out.println("1. Insert an element : Front");
            System.out.println("2. Insert an element : Rear");
            System.out.println("3. Insert an element : Given Position");
            System.out.println("4. Delete an element : Front");
            System.out.println("5. Delete an element : Rear");
            System.out.println("6. Delete an element : Given Position");
            System.out.println("7. Delete a particular element");
            System.out.println("8. Linear Search");
            System.out.println("9. Sync and Display");
            System.out.println("10. length of List");

            int choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter the number to be inserted at Front");
                    int ans = scan.nextInt();
                    System.out.println((linkedList.addFront(ans).getResponseMsg()));
                    break;
                }
                case 2: {
                    System.out.println("Enter the number to be inserted at Rear");
                    int ans = scan.nextInt();
                    System.out.println(linkedList.addRear(ans).getResponseMsg());
                    break;
                }
                case 3: {
                    System.out.println("Enter the number to be inserted at a specified position");
                    int ans1 = scan.nextInt();
                    System.out.println("Enter the specified position");
                    int ans2 = scan.nextInt();
                    System.out.println(linkedList.addAtPosition(ans1, ans2).getResponseMsg());
                    break;
                }
                case 4: {
                    System.out.println(linkedList.deleteFromFront().getResponseMsg());
                    break;
                }
                case 5: {
                    System.out.println(linkedList.deleteFromRear().getResponseMsg());
                    break;
                }
                case 6: {
                    System.out.println("Enter the specified position");
                    int ans = scan.nextInt();
                    System.out.println(linkedList.deleteFromPosition(ans).getResponseMsg());
                    break;
                }
                case 7: {
                    System.out.println("Enter the particular element");
                    int ans = scan.nextInt();
                    System.out.println(linkedList.deleteParticularElement(ans).getResponseMsg());
                    break;
                }
                case 8: {
                    System.out.println("Enter the element to be linear searched for");
                    int ans = scan.nextInt();
                    System.out.println(linkedList.linearSearch(ans).getResponseMsg());
                    break;
                }
                case 9: {
                    System.out.println(linkedList.syncDetails().getResponseMsg());
                    linkedList.display();
                    break;
                }
                case 10: {
                    System.out.println(linkedList.getLength());
                    break;
                }
            }
        }
    }
}