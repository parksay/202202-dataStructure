package stack;

import org.junit.jupiter.api.Test;

public class InfixCalculatorTest {


//    //TODO
//    String infixString = "test";
//    Stack infixStack = StringToStack.convert(infixString);
//
//    Stack postfixStack = InfixToPostfix.convert(infixStack);
//
//    int result = PostfixCalculator.eval(postfixStack);

    @Test
    public void reverseTest() {
        StackLinkedListGeneric<Integer> test = new StackLinkedListGeneric<Integer>();
        test.stackInit();
        test.stackPush(Integer.valueOf(5));
        test.stackPush(Integer.valueOf(3));
        test.stackPush(Integer.valueOf(1));

//        test = test.stackReverse();
        while(!test.stackIsEmpty()){
            System.out.println(test.stackPop());
        }
    }


    @Test
    public void integerTest(){
        final String REGEX = "[0-9]+";
        String a = "1234234";
        if(a.matches(REGEX)) {
            System.out.println("true");
        } else {
            System.out.println("false");

        }
    }
}
