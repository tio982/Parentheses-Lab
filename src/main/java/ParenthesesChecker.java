import java.util.ArrayDeque;
import java.util.Deque;

public class ParenthesesChecker {

    public static void main(String[] args) {
        String testString = "{{(())}}";

        if(checkParentheses(testString) == true)
            System.out.println("Valid");
        else System.out.println("Invalid");

    }

    static boolean checkParentheses(String testString) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for(int i = 0; i < testString.length(); i++) {

            char x = testString.charAt(i);

            if (x == '(' || x == '[' || x == '{'){
                stack.push(x);
                continue;
            }
            if(stack.isEmpty())
                return false;

            char check;
            switch (x) {
                case ')':
                    check = stack.pop();

                    if(check == '{' || check == '[')
                        return false;
                    break;


                case '}':
                    check = stack.pop();
                    if(check == '(' || check == '[')
                        return false;
                    break;


                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;

            }



        }
        return (stack.isEmpty());

    }

}

