package com.leetcode.sources.experimentals;

public class CircularReference {

    public static void main(String[] args) {
        InnerClassOne innerClassOne = new InnerClassOne();
        InnerClassTwo innerClassTwo = new InnerClassTwo();

        innerClassOne.setInnerClassTwo(innerClassTwo);
        innerClassTwo.setInnerClassOne(innerClassOne);

        innerClassOne.hello();
    }


    public static class InnerClassOne {
        private InnerClassTwo innerClassTwo;

        public void setInnerClassTwo(InnerClassTwo innerClassTwo) {
            this.innerClassTwo = innerClassTwo;
        }

        public String hello() {
            return innerClassTwo.hello();
        }

        public InnerClassOne() {
        }
    }

    public static class InnerClassTwo {
        private InnerClassOne innerClassOne;

        public void setInnerClassOne(InnerClassOne innerClassOne) {
            this.innerClassOne = innerClassOne;
        }

        public String hello() {
            return innerClassOne.hello();
        }

        public InnerClassTwo() {
        }
    }
}
