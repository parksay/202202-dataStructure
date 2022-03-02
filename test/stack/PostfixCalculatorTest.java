package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostfixCalculatorTest {


    private PostfixCalculator postCal = new PostfixCalculator();


    @Test
    public void evalTest() {
        //1 * 2 + 3 ===>  1 2 * 3 +
        //1 * (2 + 3) ===>  1 2 3 + *

        //given
        StackLinkedListGeneric<String> before = new StackLinkedListGeneric<String>();
        before.stackInit();
        before.stackPush(")");
        before.stackPush("3");
        before.stackPush("+");
        before.stackPush("2");
        before.stackPush("(");
        before.stackPush("*");
        before.stackPush("2");
        StackLinkedListGeneric<String> postfix = new StackLinkedListGeneric<String>();
        postfix = InfixToPostfix.convert(before);
        postfix = postfix.stackReverse();

        //when
        int result = postCal.eval(postfix);


        //then
        Assertions.assertEquals(10, result);
    }
}
