package com.test.stack;

//import java.util.Stack;
//
//public class Solution {
//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<Character>() {
//        };
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '(' || c == '[' || c == '{') {
//                stack.push(c);
//            } else {
//                if (stack.isEmpty())
//                    return false;
//                char topStack = stack.pop();
//                if (c == ')' && topStack != '(') {
//                    return false;
//                }
//                if (c == '}' && topStack != '{') {
//                    return false;
//                }
//                if (c == ']' && topStack != '[') {
//                    return false;
//                }
//            }
//        }
//        return stack.isEmpty();
//    }
//}

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>() {
        };
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char topStack = stack.peek();
                boolean b = false;
                if (topStack == '(' && c == ')') {
                    stack.pop();
                    b = true;
                }
                if (topStack == '{' && c == '}') {
                    stack.pop();
                    b = true;
                }
                if (topStack == '[' && c == ']') {
                    stack.pop();
                    b = true;
                }
                if (!b) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
