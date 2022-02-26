package stack;

import org.junit.jupiter.api.Test;

public class InfixCalculatorTest {


//    //TODO
//    String infixString = "test";
//    Stack infixStack = StringToStack.convert(infixString);
//
//    Stack postfixStack = InfixToPostfix.convert(infixStack);
//
//    int result = PostCalculator.eval(postfixStack);

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
