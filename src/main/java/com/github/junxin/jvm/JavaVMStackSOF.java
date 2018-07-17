package com.github.junxin.jvm;

/**
 * 虚拟机栈和本地方法栈OOM测试
 *
 * @Author zhangjx
 * @Date 2018/7/17.14:28
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();

        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length : " + oom.stackLength);
            e.printStackTrace();
            throw e;
        }
    }
}
