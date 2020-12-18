package bak.me;

import java.lang.ref.WeakReference;

public class MyEntry extends WeakReference<String> {

    /**
     * value 是强引用
     */
    private Object value;

    // key属性 在父类里，是弱引用

    MyEntry(String k, Object v) {
        super(k);
        value = v;
    }

    public Object getValue () {
        return this.value;
    }

    public String getKey (){
        // 弱引用可能拿到空
        return super.get();
    }

}
