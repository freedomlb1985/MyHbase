package com.frey.jvm;

/**
 * Created by Frey on 2017/11/1.
 */
public class Son extends Father{
    public static String v = "son static variable1";
    public static String v2 = null;
    static {
        System.out.println("son static block code.");
        System.out.println(v);
//        System.out.println(v2);
    }

    {
        System.out.println("son common block code. this code block is before the static block which init v2.");
        System.out.println("but you can see the v2 value: ( " + v2 + " ) is not null, before the static block is executed before common block");
    }

    static {
        v2 = "son static variable2";
    }

    public Son() {
        System.out.println("son step2.structure");
        System.out.println(v);
    }

    public static void functionStatic() {
        System.out.println("son static function");
        System.out.println(v);
    }

    public void function() {
        System.out.println("son common function");
        System.out.println(v);
        super.function();
    }


}
