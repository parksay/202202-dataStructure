package stack;

public class PostfixCalculator {

    public static int eval(StackLinkedListGeneric<String> postfix) {
        StackLinkedListGeneric<Integer> operand = new StackLinkedListGeneric<Integer>();
        operand.stackInit();

        final String REGEX = "[0-9]+";
        while(!postfix.stackIsEmpty()) {
            String next = postfix.stackPop();
            if(next.matches(REGEX)) {   //if next is numeric
                operand.stackPush(Integer.valueOf(next));
                continue;
            } else {
                Integer op1 = 0;
                Integer op2 = 0;
                switch (next) {
                    case "+" :
                        op2 = operand.stackPop();
                        op1 = operand.stackPop();
                        operand.stackPush(Integer.valueOf(op1+op2));
                        break;
                    case "-" :
                        op2 = operand.stackPop();
                        op1 = operand.stackPop();
                        operand.stackPush(Integer.valueOf(op1-op2));
                        break;
                    case "*" :
                        op2 = operand.stackPop();
                        op1 = operand.stackPop();
                        operand.stackPush(Integer.valueOf(op1*op2));
                        break;
                    case "/" :
                        op2 = operand.stackPop();
                        op1 = operand.stackPop();
                        operand.stackPush(Integer.valueOf((int)(op1/op2)));
                        break;
                }
            }
        }
        return operand.stackPop().intValue();
    }
}
