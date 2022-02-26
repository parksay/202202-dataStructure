package stack;

import org.junit.jupiter.api.Assertions;

public class InfixToPostfixTest {



    private InfixToPostfix converter = new InfixToPostfix();

    public void convertTest(StackLinkedListGeneric<String> before){
        //given
        before = new StackLinkedListGeneric<String>();
        before.stackPush("1");
        before.stackPush("*");
        before.stackPush("2");
        before.stackPush("+");
        before.stackPush("3");
        //1*2+3  ==>  12*3+
        StackLinkedListGeneric<String> expect = new StackLinkedListGeneric<String>();
        expect.stackPush("1");
        expect.stackPush("2");
        expect.stackPush("*");
        expect.stackPush("3");
        expect.stackPush("+");

        //when
        StackLinkedListGeneric<String> after = converter.convert(before);

        //then
        Assertions.assertEquals(expect, after);
    }
}
