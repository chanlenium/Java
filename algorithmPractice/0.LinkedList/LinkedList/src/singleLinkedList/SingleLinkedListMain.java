package singleLinkedList;

public class SingleLinkedListMain {
    public static void main(String[] args) {
        SingleLinkedList singlyLinkedList = new SingleLinkedList();
        singlyLinkedList.append(85);
        singlyLinkedList.append(59);
        singlyLinkedList.append(70);
        singlyLinkedList.append(23);
        singlyLinkedList.append(65);

        System.out.print("원본 단일 연결 리스트: ");
        singlyLinkedList.printAll();

        singlyLinkedList.delete(85);
        System.out.print("노드 85를 삭제한 단일 연결 리스트: ");
        singlyLinkedList.printAll();

        singlyLinkedList.delete(70);
        System.out.print("노드 70을 삭제한 단일 연결 리스트: ");
        singlyLinkedList.printAll();

        singlyLinkedList.delete(65);
        System.out.print("노드 65를 삭제한 단일 연결 리스트: ");
        singlyLinkedList.printAll();
    }
}
