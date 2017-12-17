package com.frey.jvm;

/**
 * Created by Frey on 2017/10/31.
 */
public class Father {
    public static String v = "father static variable1";
    public static String v2 = null;
    static {
        System.out.println("father static block code");
        System.out.println(v);
//        System.out.println(v2);
    }

    {
        System.out.println("father common block code. this code block is before the static block which init v2.");
        System.out.println("but you can see the v2 value: ( " + v2 + " ) is not null, because the static block is executed before common block");
    }
    static {
        v2 = "father static variable2";
    }



    public Father() {
        System.out.println("father step2.structure");
        System.out.println(v);
    }

    public static void functionStatic() {
        System.out.println("father static function");
        System.out.println(v);
    }

    public void function() {
        System.out.println("father common function");
        System.out.println(v);
    }

}
