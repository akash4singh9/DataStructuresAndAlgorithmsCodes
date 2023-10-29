public class EvaluateExpression {
    public boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*"))
            return true;
        return false;
    }

    public Integer evaluate(Integer a, Integer b, String s) {
        /*
            return ((b) operator (a))
        */
        if (s.equals("+"))
            return a + b; 
        else if (s.equals("-"))
            return b - a;
        else if (s.equals("/"))
            return b / a;
        else
            return a * b;
    }

    public int evalRPN(String[] array) {

        Stack<Integer> stack = new Stack<Integer>();
        int pos = 0;
        stack.push(Integer.valueOf(array[pos++]));
        if (array.length > 1)
            stack.push(Integer.valueOf(array[pos++]));

        while (pos < array.length) {
            if (isOperator(array[pos]))
                stack.push(evaluate(stack.pop(), stack.pop(), array[pos++]));
            else
                stack.push(Integer.valueOf(array[pos++]));
        }
        return stack.pop();
    }
}
