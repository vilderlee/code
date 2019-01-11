package com.vilderlee.dataStructure.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 功能描述:
 *
 * @package com.vilderlee.stack
 * @auther vilderlee
 * @date 2018-12-11 21:24
 */
public class IsValid {
    public boolean isValid(String s) {

        Map<Character,Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                char top = stack.empty() ? 'a' : stack.pop();
                if (map.get(c)!=top){
                    return false;
                }
            }
        }

       return stack.empty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("()"));
    }
}
