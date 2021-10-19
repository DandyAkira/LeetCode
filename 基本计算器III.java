import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Calculator {
    public int calculate(String s) {
        int[] result = JS(s,0);
        return result[0];
    }

    public static int[] JS(String s, int begin){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[2];
        char presign = '+';
        int len = s.length();
        int num = 0;
        for(int i=begin; i<len; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + Integer.parseInt(String.valueOf(c));
            }
            if(c == '('){
                int[] numNext = JS(s, i+1);
                num = numNext[0];
                i = numNext[1];
            }
            if(i == len-1 || !Character.isDigit(c) && c!= '('){
                switch (presign){
                    case '+': stack.push(num); break;
                    case '-': stack.push(-num); break;
                    case '*': stack.push(stack.pop()*num); break;
                    case '/': stack.push(stack.pop()/num); break;
                }
                if(c == ')'){
                    result[1] = i;
                    break;
                }
                presign = c;
                num = 0;
            }
        }
        while(!stack.isEmpty()){
            result[0] += stack.pop();
        }
        return result;
    }
}
