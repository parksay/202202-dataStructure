package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostfixCalculatorTest {


    private PostfixCalculator postCal = new PostfixCalculator();

    //TODO : test infix expression that include ()

    @Test
    public void evalTest() {
        //1 * 2 + 3 ===>  1 2 * 3 +
        //1 * (2 + 3) ===>  1 2 3 + *

        //given
        StackLinkedListGeneric<String> before = new StackLinkedListGeneric<String>();
        before.stackInit();
        before.stackPush("3");
        before.stackPush("+");
        before.stackPush("2");
        before.stackPush("*");
        before.stackPush("1");
        StackLinkedListGeneric<String> postfix = new StackLinkedListGeneric<String>();
        postfix = InfixToPostfix.convert(before);
        postfix = postfix.stackReverse();

        //when
        int result = postCal.eval(postfix);


        //then
        Assertions.assertEquals(5, result);
    }
}
