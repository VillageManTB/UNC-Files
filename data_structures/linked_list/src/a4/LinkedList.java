package a4;



public class LinkedList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;


    /**
     * Remove the node at index i of the list.
     * Note that the first element is at index 0
     * If i is larger than the size of the list, throw an IndexOutOfBounds Exception
     *
     * ex: list: A -> B -> C -> D
     *     i: 1
     *     list after removeAtIndex: A -> C -> D
     *
     * @param i    - index of node to remove
     */
    public void removeAtIndex(int i) {
        if (i > this.size()) {
            throw new RuntimeException("IndexOutOfBounds");
        }

        this.remove(this.get(i));
    }

    /**
     * Return true if this linked list is equal to the list argument, false otherwise.
     * Two lists are equal if they have the same size, and the same
     * elements in the same order.
     * ex:  list: 1 -> 4 -> 2
     *      list2: 1 -> 4 -> 2
     *      return: true
     *
     *      list: 1 -> 5
     *      list2: 2 -> 5
     *      return false;
     *
     * @param list2 - the list to merge into the current list
     * @return true if the lists have the same elements in the same order, false otherwise
     */
    public boolean isEqual(LinkedList list2) {
        if (this.size() != list2.size()) {
            return false;
        }
        for (int i=0; i<this.size();i++) {
            if (this.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Return true if the list is symmetrical, false otherwise
     * ex: list: 1 -> 2 -> 3 -> 2 -> 1
     *     return: true
     *
     *     list: a -> b -> c -> b -> f
     *     return: false
     *
     * @return true if the list is symmetrical, false otherwise
     */

    public boolean isSymmetrical() {
        int counter = this.size()-1;
        for (int i=0;i<this.size();i++) {
            if (counter == i) {
                break;
            }
            if (this.get(i) != this.get(counter)) {
                return false;
            }
            counter--;
        }
        return true;
    }


    /**
     * Stretch the list so that each element in the list is represented factor times
     * If the factor is 0 the list should be cleared (have 0 nodes)
     * ex: list: 1 -> 2 ->3
     *     factor: 3
     *     list after multiply: 1 -> 1 -> 1 -> 2 -> 2 -> 2 -> 3 -> 3 -> 3
     *
     * @param factor the amount to multiply the number of occurrences of each element by
     */
    public void multiply(int factor) {
        if (factor == 0) {
            this.clear();
        }
        int size = this.size();
        int counter = 1;
        int slot = 0;
        for (int i=0;i<(size*factor)-factor-1;i++) {
            if (i == factor*slot) {
                continue;
            }
            this.add(i,this.get(slot));
            if (i == counter*factor-1) {
                slot+= factor;
                counter++;
            }
        }
        if (this.size()>0) {
            for (int j=0;j<factor-1;j++) {
                this.add(this.get(this.size()-1));
            }
        }
    }

    /**
     * Given a sorted linked list, remove the duplicate values from the list
     * ex: list: 5 -> 6 -> 7 -> 7 -> 7 -> 8 -> 8 -> 9
     *     list after removeRepeats: 5 -> 6 -> 7 -> 8 -> 9
     *
     */
    public void removeRepeats() {
        for (int i=0;i<this.size();i++) {
            if (this.indexOf(this.get(i)) != this.lastIndexOf(this.get(i))) {
                this.remove(this.get(this.lastIndexOf(this.get(i))));
            }
        }
    }


    /**
     * Reverse the list
     *
     * ex list:  10 -> 9 -> 8 -> 7
     *    list after reverse: 7 -> 8 -> 9 -> 10
     *
     */
    public void reverse() {
        Node<T> prev = null;
        Node<T> next = null;
        Node<T> current = head;
        while(current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }

    /**
     * Return true if the list contains a cycle, false otherwise
     * ex: list: 1 -> 2 -> 3 - > 4 --       (4 points to 2)
     *                ^              |
     *                |              |
     *                ---------------
     *      return: true
     *
     *      list: 1 -> 2 -> 3 -> 4
     *      return: false
     *
     * @return true if the list contains a cycle, false otherwise
     */
    public boolean containsCycle() {
        Node<T> fast = head;
        Node<T> slow = head;
        while(true) {
            slow = slow.getNext();
            if(fast.getNext() != null)
                fast = fast.getNext().getNext();
            else
                return false;
            if(slow == null || fast == null)
                return false;
            if(slow == fast)
                return true;
        }
    }


    /**
     * Merge the given linked list into the current list. The 2 lists will always be
     * either the same size, or the current list will be longer than list2.
     * The examples below show how to handle each case.
     *
     * Note: Do NOT create and return a new list, merge the second list into the first one.
     *
     * ex: list: 1 -> 2 -> 3
     *     list2: 4 -> 5 -> 6
     *     return: 1 -> 4 -> 2 -> 5 -> 3 -> 6
     *
     *     list: 1 -> 2 -> 3 -> 4
     *     list2: 5 -> 6
     *     return 1 -> 5 -> 2 -> 6 -> 3 -> 4
     *
     * @param list2
     */
    public void merge(LinkedList list2) {
        int newSize = this.size()+list2.size();
        int slot = 1;
        int count = 0;
        while(count<list2.size()) {
            this.add(count+slot,list2.get(count));
            slot++;
            count++;
        }
    }


    /* Implementation given to you. Do not modify below this. */
    
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean contains(Object element) {
        Node<T> current = head;
        while(current != null) {
            if(current.getValue().equals(element)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public T[] toArray() {
        T[] arr =  (T[]) new Object[size()];
        Node<T> current = head;
        int i = 0;
        if(isEmpty()) {
            return arr;
        }
        while(current != null){
            arr[i] = current.getValue();
            current = current.getNext();
            i++;
        }
        return arr;
    }

    public void add(Object element) {
        Node<T> newNode = new NodeImpl<T>((T) element, null);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            tail.setNext(newNode);
            tail = newNode;
            size++;
        }

    }

    public boolean remove(Object element) {
        Node<T> current = head;
        if(isEmpty()) {
            return false;
        }
        if(current.getValue() == element){
            head = head.getNext();
            size--;
            return true;
        }
        while(current.getNext().getValue() != element) {
            current = current.getNext();
            if(current == null) {
                return false;
            }
        }
        if(current.getNext().getNext() == null) {
            tail = current;
        }
        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    public T get(int index) {
        validIndex(index);
        Node<T> current = head;
        int i = 0;
        while (i < index) {
            current = current.getNext();
            i++;
        }
        return current.getValue();
    }

    public T set(int index, Object element) {
        validIndex(index);
        Node<T> current = head;
        T prevValue = null;
        int i = 0;
        if(index == 0) {
            prevValue = head.getValue();
            head.setValue((T) element);
        } else {
            while(current != null) {
                if(i == index) {
                    prevValue = current.getValue();
                    current.setValue((T) element);
                    return prevValue;
                }
                current = current.getNext();
                i++;
            }
        }

        return prevValue;
    }

    public void add(int index, Object element) {
        if(index > size) {
            validIndex(index);
        }
        Node<T> current = head;
        int i = 0;
        if(index == 0) {
            if(isEmpty()) {
                add(element);
                return;
            } else {
                Node<T> newNode = new NodeImpl<T>((T) element, head);
                head = newNode;
                size++;
                return;
            }

        }  else if(index == size) {
            add(element);
            return;
        }
        while(current != null) {
            if(i == (index - 1)) {
                Node<T> temp = current.getNext();
                Node<T> newNode = new NodeImpl<T>((T) element, temp);
                current.setNext(newNode);
                size++;
                return;
            } else {
                current = current.getNext();
                i++;
            }
        }
    }

    public int indexOf(Object element) {
        Node<T> current = head;
        int index = 0;
        while(current != null) {
            if(current.getValue().equals((T) element)) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }

    public int lastIndexOf(Object element) {
        Node<T> current = head;
        int index = -1;
        int i = 0;
        while(current != null) {
            if(current.getValue().equals ((T) element)) {
                index = i;
            }
            i++;
            current = current.getNext();
        }
        return index;
    }

    public void validIndex(int i) {
        if(i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public Node<T> getHead() {
        return head;
    }

    @Override
    public String toString() {
        String list = "";
        Node<T> current = head;
        while(current != null) {
            if(current.getNext() == null)
                list+= current.getValue();
            else
                list += current.getValue() + " -> ";
            current = current.getNext();
        }
        return list;
    }

}
