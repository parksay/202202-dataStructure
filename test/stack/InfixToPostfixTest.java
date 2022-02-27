package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;


public class InfixToPostfixTest {



    private InfixToPostfix converter = new InfixToPostfix();


    @Test
    public void convertTest(){
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
        StackLinkedListGeneric<String> expect = new StackLinkedListGeneric<String>();
        expect.stackInit();
        expect.stackPush("1");
        expect.stackPush("2");
        expect.stackPush("*");
        expect.stackPush("3");
        expect.stackPush("+");

        //when
        StackLinkedListGeneric<String> after = converter.convert(before);

        //then
        int length = expect.stackCount();
        for(int i = 0; i < length; i++) {
            if(!expect.stackIsEmpty() && !after.stackIsEmpty()) {
//                System.out.println(after.stackPop());
                Assertions.assertEquals(expect.stackPop(), after.stackPop());
            }
        }
    }
}
