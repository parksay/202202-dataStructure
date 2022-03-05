package tree;

import customDataStructure.StackCustom;

import java.util.Stack;

public class ExpressionTreeCustom{

    private ExpressionTreeCustom left;
    private ExpressionTreeCustom right;
    private String data;

    public void treeInit() {
        this.left = null;
        this.right = null;
        this.data = null;
    }

    public ExpressionTreeCustom getLeftSubTree() {
        return left;
    }

    public void setLeftSubTree(ExpressionTreeCustom left) {
        this.left = left;
    }

    public ExpressionTreeCustom getRightSubTree() {
        return right;
    }

    public void setRightSubTree(ExpressionTreeCustom right) {
        this.right = right;
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


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean makeExpTree(Stack<String> postfixStack){
        //3 2 4 + *
        Stack<ExpressionTreeCustom> expStack = new Stack<>();
        final String REGEX = "[0-9]+";
        String next = null;

        while(!postfixStack.empty()) {
            ExpressionTreeCustom tree = new ExpressionTreeCustom();
            tree.treeInit();
            next = postfixStack.pop();
            if(next.matches(REGEX)) {    //next is numeric
                tree.setData(next);
                expStack.push(tree);
            } else {    //next is operator
                tree.setData(next);
                tree.setRightSubTree(expStack.pop());
                tree.setLeftSubTree(expStack.pop());
                expStack.push(tree);
            }   //You can make the code simple but this one is easier to see the difference by the case
        }
        this.setData(expStack.peek().getData());
        this.setLeftSubTree(expStack.peek().getLeftSubTree());
        this.setRightSubTree(expStack.peek().getRightSubTree());
        return true;
    }

    public boolean makeExpTree(StackCustom<String> postfixStack){
        //3 2 4 + *
        StackCustom<ExpressionTreeCustom> expStack = new StackCustom<>();
        final String REGEX = "[0-9]+";
        String next = null;

        while(!postfixStack.empty()) {
            ExpressionTreeCustom tree = new ExpressionTreeCustom();
            tree.treeInit();
            next = postfixStack.pop();
            if(next.matches(REGEX)) {    //next is numeric
                tree.setData(next);
                expStack.push(tree);
            } else {    //next is operator
                tree.setData(next);
                tree.setRightSubTree(expStack.pop());
                tree.setLeftSubTree(expStack.pop());
                expStack.push(tree);
            }   //You can make the code simple but this one is easier to see the difference by the case
        }
        this.setData(expStack.peek().getData());
        this.setLeftSubTree(expStack.peek().getLeftSubTree());
        this.setRightSubTree(expStack.peek().getRightSubTree());
        return true;
    }

    public int evalExpTree(){

        if(this.getLeftSubTree() == null || this.getRightSubTree() == null) {
            return Integer.valueOf(this.getData());
        }
        int op1 = this.getLeftSubTree().evalExpTree();
        int op2 = this.getRightSubTree().evalExpTree();
        switch (this.getData()) {
            case "+" :
                return op1 + op2;
            case "-" :
                return op1 - op2;
            case "*" :
                return op1 * op2;
            case "/" :
                return op1 / op2;
            default:
                return 0;
        }
    }

    public void printSubTree() {
        this.traverse(1);

    }

    public void traverse(int action) {
        if(this.getLeftSubTree() != null) {
            this.getLeftSubTree().traverse(action);
        }
        if(this.getRightSubTree() != null) {
            this.getRightSubTree().traverse(action);
        }
        switch (action) {
            case 1 :
                System.out.println(this.getData());
                break;
            case 2 :
                this.setData(null);
                this.setLeftSubTree(null);
                this.setRightSubTree(null);
                break;
        }
    }
}
