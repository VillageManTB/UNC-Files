package a5;


public class Main {
  public static void main(String[] args) {
    /*
    This is a basic example of how to create a BST and add values to it.
    You should add more examples and use this class to debug your code
    */
    BST<Integer> bst = new NonEmptyBST<Integer>(47);
      //bst = bst.insert(47);
      bst = bst.insert(7);
      bst = bst.insert(52);
      bst = bst.insert(3);
      bst = bst.insert(10);
      bst = bst.insert(60);
      bst = bst.insert(58);
      bst = bst.remove(7);
      //bst = bst.remove(10);
      //bst = bst.remove(52);
      //bst.printInOrderTraversal();
      bst.printPreOrderTraversal();
      //bst.printPostOrderTraversal();
      //System.out.println(bst.contains(8));
      //System.out.println(bst.contains(5));
      //System.out.println(bst.findMin());
      //bst.printBreadthFirstTraversal();
      //bst.remove(1);
    //System.out.println(double x = (4/8) * 2.0;)




  }

}
