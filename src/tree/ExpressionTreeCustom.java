package tree;

import java.util.Stack;

public class ExpressionTreeCustom extends BinaryTreeCustom {


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

}
