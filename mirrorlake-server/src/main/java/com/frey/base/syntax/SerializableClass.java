package com.frey.base.syntax;

import java.io.Serializable;

/**
 * Created by Frey on 2017/11/4.
 */
public class SerializableClass implements Serializable{
    public transient String content = "I don't think i can be serialized";
    public String name = "SerializableClass";
    public static String staticVariable = "value1";

    public String getStaticVariable() {
        return staticVariable;
    }

    public void setStaticVariable(String staticVariable) {
        this.staticVariable = staticVariable;
    }





}
