package a4;


public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(3);
        //list.removeAtIndex(0);
        //list.removeRepeats();
        list.reverse();

        System.out.println(list.toString());
        System.out.println(list.containsCycle());
    }
}
