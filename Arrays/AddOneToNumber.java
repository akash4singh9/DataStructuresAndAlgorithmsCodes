public class AddOneToNumber {
    public int[] plusOne(int[] A) {

        Stack<Integer> stack = new Stack<Integer>();
        int carry = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            stack.push((A[i] + carry) % 10);
            carry = (A[i] + carry) / 10;
        }
        if (carry == 1)
            stack.push(carry);

        while (stack.peek() == 0)
            stack.pop();

        int[] array = new int[stack.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
        return array;
    }
}
