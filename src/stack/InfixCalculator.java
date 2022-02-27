package stack;

import java.util.Scanner;

public class InfixCalculator {

    public static void main(String args[]) {

//        //TODO : create StringToStack
//        Scanner sc = new Scanner(System.in);
//        String infixString = sc.nextLine();
//        StackLinkedListGeneric<String> infixStack = StringToStack.convert(infixString);
        StackLinkedListGeneric<String> infixStack = new StackLinkedListGeneric<String>();
        infixStack.stackInit();
        infixStack.stackPush(")");
        infixStack.stackPush("2");
        infixStack.stackPush("*");
        infixStack.stackPush("3");
        infixStack.stackPush("+");
        infixStack.stackPush("2");
        infixStack.stackPush("(");
        infixStack.stackPush("*");
        infixStack.stackPush("3");
        infixStack.stackPush("+");
        infixStack.stackPush("1");

        StackLinkedListGeneric<String> postfixStack = InfixToPostfix.convert(infixStack);
        postfixStack = postfixStack.stackReverse();
        int result = PostfixCalculator.eval(postfixStack);
        System.out.println(result);
    }
}
