package structures;

public class SimpleLinkedList<E> {

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    private Node<E> head;

    public SimpleLinkedList() {
        /* empty */
    }

    public void add(E element) {
        Node<E> last = findLastNode();
        if (last == null) {
            head = new Node<>(element, null);
        } else {
            last.next = new Node<>(element, null);
        }
    }

    public void setAfter(E afterElement, E element) {
        Node<E> curr = findNode(afterElement,false);
        if (curr != null) {
            curr.next = new Node<>(element, curr.next);
        }
    }

    public void remove(E element) {
        Node<E> curr = findNode(element, true);
        if (curr != null) {
            if (curr == head) {
                head =  head.next;
            } else {
                curr.next = curr.next.next;
            }
        }
    }

    public SimpleLinkedList union(SimpleLinkedList<E> list1,SimpleLinkedList<E> list2) {
        Node<E> last = list1.findLastNode();
        if (last == null) {
            return list2;
        } else {
            last.next = list2.head;
        }
        return list1;
    }

    @SuppressWarnings("unchecked")
    public boolean find(E element) {
        return findNode(element,false) != null;
    }

    @SuppressWarnings("unchecked")
    private Node<E> findLastNode() {
        if (head != null) {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            return curr;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private Node<E> findNode(E element, boolean removeFlag) {
        if (head != null) {
            Node curr = head;

            if (removeFlag && curr.item.equals(element)) {
                    return curr;
            }

            while (curr.next != null) {

                if ((removeFlag && curr.next.item.equals(element)) || curr.item.equals(element))
                        return curr;

                curr = curr.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.setAfter(2,5);
        list.setAfter(5,8);
        System.out.println(list.find(5));
        list.remove(5);
        list.remove(4);
        list.remove(1);
        System.out.println("dsa");
    }
}