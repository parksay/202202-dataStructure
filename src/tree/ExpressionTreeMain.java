package tree;

import customDataStructure.StackCustom;

public class ExpressionTreeMain {


    public static void main(String args[]) {

//        //level1 : 3 * (2 + 4)  => 3 2 4 + *
//        Stack<String> postfix = new Stack<>();
//        postfix.push("*");
//        postfix.push("+");
//        postfix.push("4");
//        postfix.push("2");
//        postfix.push("3");

        //level2 : 1 + 3 * (2 + 3 * 2) => 1 3 2 3 2 * + * +
        StackCustom<String> infix = new StackCustom<>();
        infix.push(")");
        infix.push("2");
        infix.push("*");
        infix.push("3");
        infix.push("+");
        infix.push("2");
        infix.push("(");
        infix.push("*");
        infix.push("3");
        infix.push("+");
        infix.push("1");
        StackCustom<String> postfix = Converter.infixToPostfix(infix);
        StackCustom<String> postfixStack = Converter.reverseStack(postfix);

        ExpressionTreeCustom expTree = new ExpressionTreeCustom();
        expTree.treeInit();
        expTree.makeExpTree(postfixStack);
        expTree.printSubTree();

        //TODO : create method evaluate expression tree
    }

}
