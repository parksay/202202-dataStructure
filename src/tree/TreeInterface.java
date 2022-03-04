package tree;

public interface TreeInterface {

    abstract void treeInit();
    abstract String getData();
    abstract String setData(String data);
    abstract boolean setLeftSubTree(BinaryTreeCustom subTree);
    abstract boolean setRightSubTree(BinaryTreeCustom subTree);
    abstract BinaryTreeCustom getLeftSubTree();
    abstract BinaryTreeCustom getRightSubTree();
    abstract boolean removeLeftSubTree();
    abstract boolean removeRightSubTree();
    abstract void printSubTree();

}
