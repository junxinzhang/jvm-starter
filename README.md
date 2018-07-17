# 在单个线程下，无论是由于帧栈太大还是虚拟机容量太小，当内存无法分配的时候，虚拟机抛出的都是StackOverflowError异常

# 引用计数算法：给对象中添加一个引用计数器，每当有一个地方引用它时，计数器的值+1；当引用失效时，计数器值-1；任何时刻计数器数值为0的对象就是不可能再被使用的。--无法解决对象之间相互循环引用的问题。

# 垃圾收集算法
- 标记 - 清除算法
- 复制算法
- 标记 - 整理算法
- 分代收集算法

# 垃圾收集器
## Serial收集器：单线程的收集器，收集时必须暂停其它线程(stop the world)
## ParNew收集器：Serial收集器的多线程版本
## Parallel Scavenge收集器：：达到一个可控制的吞吐量
## Serial Old收集器：Serial收集器的老年代版本，单线程，使用*标记-整理*算法
## Parallel Old收集器：Parallel Scavenge收集器的老年代版本，多线程，使用*标记-整理*算法
## CMS(Concurrent Mark Sweep)收集器：获取最短回收停顿时间为目标的收集器，使用*标记-清除*算法
- 初始标记(CMS initial mark)
- 并发标记(CMS concurrent mark)
- 重新标记(CMS remark)
- 并发清除(CMS concurrent sweep)
## G1收集器：使用*标记-整理*算法，精确控制停顿，