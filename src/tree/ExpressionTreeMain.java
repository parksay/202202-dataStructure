package tree;

import java.util.Stack;

public class ExpressionTreeMain {


    public static void main(String args[]) {

        Stack<String> postfix = new Stack<>();
        //level1 : 3 * (2 + 4)  => 3 2 4 + *
        postfix.push("*");
        postfix.push("+");
        postfix.push("4");
        postfix.push("2");
        postfix.push("3");

        ExpressionTreeCustom expTree = new ExpressionTreeCustom();
        expTree.treeInit();
        expTree.makeExpTree(postfix);
        expTree.printSubTree();

    }

}
