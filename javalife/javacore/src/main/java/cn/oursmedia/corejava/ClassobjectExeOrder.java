package cn.oursmedia.corejava;

public class ClassobjectExeOrder {

    static {
        step(1);
    }

    public static int step_1 = step(2);
    public int step_6 = step(6);

    public ClassobjectExeOrder() {
        step(8);
    }

    {
        step(7);
    }

    // Just for demonstration purposes:
    public static int step(int step) {
        System.out.println("Step " + step);
        return step;
    }
}

