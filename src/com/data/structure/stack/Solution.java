package com.data.structure.stack;

/**
 * @author zhangjin
 * @date 2019-11-19 11:09
 */


class Solution {

    public boolean isValid(String s) {


        ArrayStack<Character> stack = new ArrayStack<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('{' == c || '[' == c || '(' == c) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if ('}' == c && '{' == stack.pop()) {
                    continue;
                } else if (']' == c && '[' == stack.pop()) {
                    continue;
                } else if (')' == c && '(' == stack.pop()) {
                    continue;
                }

                return false;


            }

        }


        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "((())}";
        Solution solution = new Solution();
        boolean valid = solution.isValid(str);
        System.out.println(valid);

        str = "({[]})";
        valid = solution.isValid(str);
        System.out.println(valid);


    }


}