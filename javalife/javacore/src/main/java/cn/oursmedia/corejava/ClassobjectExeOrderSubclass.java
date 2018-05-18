package cn.oursmedia.corejava;

public class ClassobjectExeOrderSubclass extends ClassobjectExeOrder {

    {
        step(9);
    }

    public static int step_3 = step(3);
    public int step_10 = step(10);

    static {
        step(4);
    }

    public ClassobjectExeOrderSubclass() {
        step(11);
    }

    public static void main(String[] args) {
        step(5);
        new ClassobjectExeOrderSubclass();
        step(12);
    }
}

