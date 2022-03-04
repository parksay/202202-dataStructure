package tree;

public class BinaryTree implements TreeInterface {


    private String data;
    private BinaryTree left;
    private BinaryTree right;

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


    public boolean removeLeftSubTree() {
        this.left.traverse(2);
        this.left = null;
        return true;
    }

    public boolean removeRightSubTree() {
        this.right.traverse(2);
        this.right = null;
        return true;
    }


    public boolean printSubTree() {
        this.traverse(1);
        return true;
    }


    private void traverse(int act){
        //act 1: print / 2: remove

//        System.out.println(this.data);  //preorder traversal
        if(this.getLeftSubTree() != null) {
            this.getLeftSubTree().traverse(act);
        }
//        System.out.println(this.data);  //inorder traversal
        if(this.getRightSubTree() != null) {
            this.getRightSubTree().traverse(act);
        }
//        System.out.println(this.data);  //postorder traversal

        switch(act) {
            case 1:
                System.out.println(this.data);
                break;
            case 2:
                this.data = null;
                this.left = null;
                this.right = null;
                break;
        }
    }

}
