package singleLinkedList;

public class SingleLinkedList {
    private Node head;  // 첫번째 노드

    // default constructor
    SingleLinkedList() {
        this.head = null;
    }

    // 1-argument constructor
    SingleLinkedList(int value){
        this.head = new Node(value, null);
    }

    class Node{
        private int value;  // 값
        private Node next;  // 다음노드

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue(){
            return this.value;
        }
    }

    public Node getHead(){
        return this.head;
    }

    /**
     * Single Linked List 끝에 node추가
     */
    public void append(int value){
        if(this.head == null){
            this.head = new Node(value, null);
            return;
        }

        // head가 null이 아니면, head(첫번째 node)를 pointer에 저장
        Node pointer = this.head;
        // pointer.next를 이용하여 다음 node를 가르키도록하여 멘 끝 node로 이동
        while(pointer.next != null){
            pointer = pointer.next;
        }
        // 멘 끝 node 다음에 해당 값을 갖는 node추가
        pointer.next = new Node(value, null);
    }


    /**
     * value값이 같은 node 삭제
     */
    public void delete(int value){
        Node pointer = this.head;

        // 첫 노드의 값이 value와 같으면, 이를 지우고 head가 다음 node를 가르키도록 함
        if(pointer.getValue() == value){
            Node removeNode = this.head;
            this.head = this.head.next;
            removeNode = null;
            return;
        }

        Node temp = pointer;
        // 포인터가 null이 아니고, value가 아닐 때까지 반복
        while(pointer != null && pointer.getValue() != value){
            temp = pointer;
            pointer = pointer.next;
        }

        // 마지막 노드를 삭제하는 경우
        if(pointer.next == null){
            temp.next = null;
        }else{
            temp.next = pointer.next;
        }
        pointer = null;
    }

    /**
     * 모든 노드 출력
     */
    public void printAll(){
        Node pointer = this.head;

        StringBuilder builder = new StringBuilder();
        while (pointer.next != null) {
            builder.append(pointer.getValue());
            builder.append(" -> ");
            pointer = pointer.next;
        }

        builder.append(pointer.getValue());
        System.out.println(builder.toString());
    }
}
