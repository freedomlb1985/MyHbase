package com.frey.base.syntax;

/**
 * Created by Frey on 2017/11/4.
 */
public class EqualsAndHashcode {

    public static void main(String[] args) {
        ExternalizableClass e1 = new ExternalizableClass();
        ExternalizableClass e2 = new ExternalizableClass();
        System.out.println(e1.equals(e2));
        System.out.println(e1 == e2);
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
        System.out.println("########################################################################################");
        String a = "test";
        String b = "test";
        String oa = new String("test");
        String ob = new String("test");
        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println("###############################################################################");
        System.out.println(oa.equals(ob));
        System.out.println(oa == ob);
        System.out.println(oa.hashCode());
        System.out.println(ob.hashCode());
        Test t = new Test();
        System.out.println("############################### Sring, StringBuffer, StringBuilder ################################################");
        String s = "hello world";
        StringBuffer sb = new StringBuffer();
        sb.append("world");
        sb.insert(0, "hello ");
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("hello world");
        System.out.println(s);
        System.out.println(sb.toString());
        System.out.println(sBuilder.toString());

        System.out.println("###############################################################################");
        System.out.printf("%d-%d-%d-%f-%f-%c-%c-%b%n", t.v1, t.v2, t.v3,t.v4,t.v5, t.v6, t.v7, t.v8); //0-0-0-0.000000-0.000000- - -false
        System.out.printf("%d-%d-%d-%f-%f-%d-%c-%b", t.v1, t.v2, t.v3,t.v4,t.v5, t.v6, t.v7, t.v8); //0-0-0-0.000000-0.000000-0- -false
    }

    static class Test {
        int v1;
        short v2;
        long v3;
        float v4;
        double v5;
        byte v6;
        char v7;
        boolean v8;
    }
}
