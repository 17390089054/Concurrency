并行计算
    业务： 任务多，数据量大
串行VS并行
    串行编程简单，并行编程困难
    单个计算核频率下降，计算核数增多，整体性能变高
并行困难（任务分配和执行过程高度耦合）
    如何控制粒度，切割任务
    如何分配任务给线程，监督线程执行过程
并行模式
    --主从模式（Master-Slave）
    --Woker模式（Worker-Worker）

Java并发编程
    --Thread/Runnable/Thread组管理
    --Executor
    --Fork-Join框架
    
线程组ThreadGroup
    --线程的集合
    --树形结构，大线程组可以包括小线程组，执行操作
    --可以通过enumerate方法遍历组内的线程，执行操作
    --能够有效管理多个线程，但是管理效率低
    --任务分配和执行过程高度耦合
    --重复创建线程，关闭线程操作，无法重用线程
Executor
      从JDK5开始提供Exector FrameWork（java.util.concurrent.*）
          --分离任务的创建和执行者的创建
          --线程重复利用（new 线程代价很大）
        共享线程池
            --预设好多个Thread。可弹性增加
            --多次执行很多很小的任务
            --任务创建和执行过程解耦
            --程序员无需关心线程池执行任务过程
        主要类：ExectutorService，ThreadPoolExecutor，Future
            --Executor.newCachedThreadPool/newFixedThreadPool 创建线程池
            --ExecutorService线程池服务
            --Callable具体的逻辑对象（线程类）
            --Future返回结果
Fork-Join
       Java7提供另一种并行框架：分解、治理、合并（分治编程）
        适合用于整体任务不好确定的场合（最小任务可确定）
        
            关键类
                --ForkJoinPool 任务池
                --RecursiveAction
                --RecursiveTask
                了解Fork-Join和Executor的区别
                控制任务分解粒度
                熟悉Fork-Join框架，提供多线程执行效率
    
    并发数据结构
            常用的数据结构是线程不安全的 
            --ArrayList，HashMap，HashSet非同步的
            --多个线程同时读写，可能会抛出异常或错误数据
            传统Vector，Hashtable等同步集合性能过差
            并发数据结构：数据添加和删除
                —阻塞式集合：当集合为空或者满时，等待
                —非阻塞式集合：当集合为空或者满时，不等待，返回null或异常
            
               List
                    —Vector 同步安全，写多读少
                    —ArrayList 不安全
                    —Collections.synchronizedList(List list) 基于synchronized，效率差
                    —CopyOnWriteArrayList 读多写少，基于复制机制，非阻塞
                Set
                    —HashSet 不安全
                    —Collections.synchronizedSet(Set set) 基于synchronized，效率差
                    —CopyOnWriteArraySet(基于CopyOnWriteArrayList实现) 读多写少，非阻塞
                Map
                    —Hashtable 同步安全，写多读少
                    —HashMap 不安全
                    —Collections.synchronizedMap(Map map) 基于synchronized，效率差
                    —ConcurrentHashMap 读多写少，非阻塞
                Queue & Deque（队列，JDK1.5提出）
                     —ConcurrentLinkedQueue 非阻塞
                     —ArrayBlockingQueue/LinkedBlockingQueue 阻塞
                了解数据结构并发读写的问题
                根据业务特点，使用正确的并发数据结构
    线程协作
             Thread/Executor/Fork-Join
                —线程启动，运行，结束
                 —线程之间缺少协作
            synchronized同步
              —限定只有一个线程才能进入关键
                —简单粗暴，性能损失有点大
            Lock
                Lock可以实现同步的效果
                    —实现更复杂的临界区结构
                    —tryLock方法可以预判锁是否空闲
                    —允许分离读写的操作，多个读，一个写
                    —性能更好
                ReentrantLock类，可重入的互斥锁
                ReentrantReadWriteLock类，可重入的读写锁
                lock和unlock函数
            Semaphore
                    信号量，由1965年Dijkstra提出的
                    信号量：本质上是一个计算器
                    计数器大于0，可以使用，等于0不能使用
                    可以设置多个并发量，例如限制10个访问
                    Semaphore   
                        —acquire获取
                        —release释放
                    比Lock更进一步，可以控制多个同时访问关键区
            Latch
                等待锁，是一个同步辅助类
                用来同步执行任务的一个或者多个线程
                不是用来保护临界区或者共享资源
                CountDownLacth
                —countDown()计数减1
                —await() 等待latch变成0
            Barrier
                集合点，也是一个同步辅助类                允许多个线程在某一个点上进行同步
                CyclicBarrirer
                    —构造函数是需要同步的线程数量
                    —await等待其他线程，达到数量后，就放行
            Phaser
                 允许执行并发多阶段任务，同步辅助类
                  在每一个阶段结束的位置对线程进行同步，都到达这步，再进行下一步
                  Phaser
                    —arrive()
                    —arriveAndAwaitAdvance()
            Exchanger
                允许在并发线程中互相交换消息
                允许在2个线程中定义同步点，当两个线程都到达同步点，他们交换数据结构
                Exchanger
                    —exchange(),线程双方互相交互数据
                    —交换数据是双向的
            java.util.concurrent包提供了很多并发编程的控制协作类
            根据业务特点，使用正确的线程并发控制协作
            定时任务：
                Thread/Executor/Fork-Join多线程
                    —立刻执行
                    —框架调度
                定时执行
                    —固定某一个时间点运行
                    —以某一个周期
                简单定时器机制
                    —设置计划任务，也就是在指定时间开始执行某一个任务
                    —TimerTask封装任务
                    —Timer类 定时器
                Executor+定时器机制
                ScheduledExecutorService
                    —定时任务
                    —周期任务
                Quartz
                    —Quartz是一个较为完善的任务调度框架
                    —解决程序中Timer零散管理的问题
                    —功能更加强大
                        Timer执行周期任务，如果中间某一次有异常，整个任务终止执行
                        Quartz执行周期任务，如果中间某一次有异常，不影响下一次执行
                    了解定时任务的作用
                    根据业务特点，使用合适的定时任务器