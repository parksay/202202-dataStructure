package tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Stack;

public class ExpressionTreeMainTest {




    @Test
    public void mainTest() {

        Stack<String> postfix = new Stack<>();
        //level1 : 3 * (2 + 4)  => 3 2 4 + *
        postfix.push("*");
        postfix.push("+");
        postfix.push("4");
        postfix.push("2");
        postfix.push("3");


//        //level2
//        postfix.push(")");
//        postfix.push("2");
//        postfix.push("*");
//        postfix.push("3");
//        postfix.push("+");
//        postfix.push("2");
//        postfix.push("(");
//        postfix.push("*");
//        postfix.push("3");
//        postfix.push("+");
//        postfix.push("1");
        ExpressionTreeCustom expTree = new ExpressionTreeCustom();
        expTree.treeInit();
        expTree.makeExpTree(postfix);
        expTree.printSubTree();
    }

}
