package stack;

public class InfixToPostfix {


    public static StackLinkedListGeneric<String> convert(StackLinkedListGeneric<String> before){
        StackLinkedListGeneric<String> after = new StackLinkedListGeneric<String>();
        StackLinkedListGeneric<String> operator = new StackLinkedListGeneric<String>();
        after.stackInit();
        operator.stackInit();
        //1 * 2 + 3 ===>  1 2 * 3 +
        //1 * (2 + 3) ===>  1 2 3 + *

        outer:while(!before.stackIsEmpty()){
            final String REGEX = "[0-9]+";
            String next = before.stackPop();
            if(next.matches(REGEX)) {   //next is numeric
                after.stackPush(next);
                continue;
            } else {
                switch(next) {
                    case "(":
                        operator.stackPush(next);
                        continue;
                    case ")":
                        inner:while(!operator.stackIsEmpty()) {
                            String op = operator.stackPop();
                            if(op == "(") {
                                continue outer;
                            } else {
                                after.stackPush(op);
                                continue inner;
                            }
                        }
                        continue;
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        if(!operator.stackIsEmpty() && compOperator(next, operator.stackPeek()) < 1) {
                            after.stackPush(operator.stackPop());
                            operator.stackPush(next);
                        } else {
                            operator.stackPush(next);
                        }
                }
            }
        }
        while(!operator.stackIsEmpty()) {
            after.stackPush(operator.stackPop());
        }

        return after;
    }


    public static int compOperator(String op1, String op2) {
        //if op1 is greater than op2 : returns > 0
        //if op2 is greater than op1 : returns < 0
        //if op1 and op2 are equal : returns 0

        String[] ops = {op1, op2};
        int[] ranks = new int[ops.length];
        for(int i = 0; i < ops.length-1; i++) {
            if(ops[i] == "(") {
                ranks[i] = 1;
                continue;
            } else if(ops[i] == "+" || ops[i] == "-") {
                ranks[i] = 3;
                continue;
            } else if (ops[i] == "*" || ops[i] == "/") {
                ranks[i] = 5;
                continue;
            } else {
                ranks[i] = 0;
                continue;
            }
        }

        if(ranks[0] > ranks[1]) {
            return 1;
        } else if (ranks[0] == ranks[1]) {
            return 0;
        } else if (ranks[0] < ranks[1]) {
            return -1;
        } else {
            return -2;
        }
    }
}
