package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution solution = new Solution();
        Solution solution1 = new Solution();
        Solution.InnerClass iner1 = solution.new InnerClass();
        Solution.InnerClass iner2 = solution.new InnerClass();
        Solution.InnerClass iner3 = solution1.new InnerClass();
        Solution.InnerClass iner4 = solution1.new InnerClass();
        solution.innerClasses[0] = iner1;
        solution.innerClasses[1] = iner2;
        solution1.innerClasses[0] = iner3;
        solution1.innerClasses[1] = iner4;
        Solution[] mass = new Solution[]{solution,solution1};

        return mass;
    }

    public static void main(String[] args) {

    }
}
