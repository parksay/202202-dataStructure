package tree;

import customDataStructure.StackCustom;

public class Converter {

    public static StackCustom<String> infixToPostfix(StackCustom<String> before){
        StackCustom<String> after = new StackCustom<>();
        StackCustom<String> operator = new StackCustom<>();

        final String REGEX = "[0-9]+";
        outer:while(!before.empty()){
            String next = before.pop();
            if(next.matches(REGEX)) {   //next is numeric
                after.push(next);
                continue;
            } else {
                switch(next) {
                    case "(":
                        operator.push(next);
                        continue;
                    case ")":
                        inner:while(!operator.empty()) {
                            String op = operator.pop();
                            if(op == "(") {
                                continue outer;
                            } else {
                                after.push(op);
                                continue inner;
                            }
                        }
                        continue;
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        if(!operator.empty() && compOperator(next, operator.peek()) < 1) {
                            after.push(operator.pop());
                            operator.push(next);
                        } else {
                            operator.push(next);
                        }
                }
            }
        }
        while(!operator.empty()) {
            after.push(operator.pop());
        }

        return after;
    }


    public static int compOperator(String op1, String op2) {
        //if op1 is greater than op2 : returns > 0
        //if op1 is less than op2 : returns < 0
        //if op1 and op2 are equal : returns 0

        String[] ops = {op1, op2};
        int[] ranks = new int[ops.length];
        for(int i = 0; i < ops.length; i++) {
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


    public static StackCustom<String> reverseStack(StackCustom<String> before) {
        StackCustom<String> after = new StackCustom<>();
        while(!before.empty()) {
            after.push(before.pop());
        }
        return after;
    }
}
