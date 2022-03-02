package tree;

public interface TreeInterface {

    abstract void treeInit();
    abstract String getData();
    abstract String setData(String data);
    abstract BinaryTree getLeftSubTree();
    abstract BinaryTree getRightSubTree();
    abstract boolean setLeftSubTree(BinaryTree subTree);
    abstract boolean setRightSubTree(BinaryTree subTree);
}
