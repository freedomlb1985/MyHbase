package com.frey.jvm;

/**
 * Created by Frey on 2017/10/31.
 */
public class JVMMain {
    public static void main(String [] args) {
        classNewInstanceOrder();
    }

    /**
     * 父类 > 子类 静态代码块 > 非静态代码块 > 构造函数
     *  1，父类中的static代码块，当前类的static
     *  2，顺序执行父类的普通代码块
     *  3，父类的构造函数
     *  4，子类普通代码块
     *  5，子类（当前类）的构造函数，按顺序执行。
     *  6，子类方法的执行，
     */
    private static void classNewInstanceOrder() {
        Son son = new Son();
        son.function();
        Son.functionStatic();
    }
}
