package tree;

public class BinaryTree implements TreeInterface {


    String data;
    BinaryTree left;
    BinaryTree right;

    public void treeInit() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    public String getData() {
        if(this.data == null) {
            return "";
        }
        return this.data;
    }

    public String setData(String data){

        this.data = data;
        return this.data;
    }

    public BinaryTree getLeftSubTree(){

        return this.left;
    }

    public BinaryTree getRightSubTree(){

        return this.right;
    }

    public boolean setLeftSubTree(BinaryTree subTree){
        this.left = subTree;
        return true;
    }

    public boolean setRightSubTree(BinaryTree subTree){
        this.right = subTree;
        return true;
    }


}
