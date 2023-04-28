import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    // function to check if brackets are balanced
    static boolean areBracketsBalanced(String expr) {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack
                = new ArrayDeque<>();

        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        // Check Empty Stack
        return (stack.isEmpty());
    }

    public static void main(String[] args) {

        // Scanner definition
        Scanner scn = new Scanner(System.in);

        // input is a string ( one word )
        // read by next() function
        String expr = scn.nextLine();

        // Function call
        if (areBracketsBalanced(expr))
            System.out.println("The entered String has Balanced Brackets");
        else
            System.out.println("The entered Strings do not contain Balanced Brackets");
    }
}