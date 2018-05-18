package cn.oursmedia.corejava;


import static cn.oursmedia.corejava.ClassobjectExeOrder.step;

public class ClassobjectExeOrderSubclassTest {
    public static void main(String[] args) {
        step(5);
        new ClassobjectExeOrderSubclass();
        step(12);
    }
}