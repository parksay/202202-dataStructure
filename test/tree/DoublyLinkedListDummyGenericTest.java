package tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListDummyGenericTest {

    @Test
    public void mainTest(){
        DoublyLinkedListDummyGeneric<BinaryTree> list = new DoublyLinkedListDummyGeneric<>();
        Assertions.assertEquals(null, list.get(3));
        Assertions.assertEquals(false, list.remove(1));
        Assertions.assertEquals(0, list.getCount());


        BinaryTree node1 = new BinaryTree();
        BinaryTree node2 = new BinaryTree();
        BinaryTree node3 = new BinaryTree();
        BinaryTree node4 = new BinaryTree();
        BinaryTree node5 = new BinaryTree();
        node1.treeInit();
        node1.setData("3");
        node2.treeInit();
        node2.setData("5");
        node3.treeInit();
        node3.setData("7");
        node4.treeInit();
        node4.setData("9");
        node5.treeInit();
        node5.setData("11");
        node1.setLeftSubTree(node2);
        node1.setRightSubTree(node3);
        node2.setLeftSubTree(node4);
        node2.setRightSubTree(node5);

        list.add(node1);
        list.add(node2);
        list.add(node3);
        Assertions.assertEquals(node3, list.get(2));
        Assertions.assertEquals(3, list.getCount());
        Assertions.assertEquals(false, list.remove(4));
        Assertions.assertEquals(true, list.remove(0));
        Assertions.assertEquals(2, list.getCount());
        Assertions.assertEquals(node2, list.get(0));
        Assertions.assertEquals(node3, list.get(1));





    }
}
