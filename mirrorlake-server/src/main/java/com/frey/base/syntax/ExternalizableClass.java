package com.frey.base.syntax;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by Frey on 2017/11/4.
 */
public class ExternalizableClass implements Externalizable {

    public transient String content = "是的，我将会被序列化，不管我是否被transient关键字修饰";
    public String name = "ExternalizableClass";
    public ExternalizableClass() {

    }
    public void writeExternal(ObjectOutput out) throws IOException {
//        out.writeObject(content);
//        out.writeObject(name);
        out.writeObject(this);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        ExternalizableClass obj = (ExternalizableClass)in.readObject();
        this.content = obj.content;
        this.name = obj.name;
    }
}
