package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class PowerOperator extends Operator {
    public int priority() {
        return 3;
    }


        public Operand execute(Operand operandOne, Operand operandTwo) {

            int base = operandOne.getValue();
            int exponent = operandTwo.getValue();
            int result = 1;
            while(exponent !=0){
                result *= base;
                --exponent;
            }
            return new Operand( result);
        }

}
