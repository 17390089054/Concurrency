���м���
    ҵ�� ����࣬��������
����VS����
    ���б�̼򵥣����б������
    ���������Ƶ���½�������������࣬�������ܱ��
�������ѣ���������ִ�й��̸߶���ϣ�
    ��ο������ȣ��и�����
    ��η���������̣߳��ල�߳�ִ�й���
����ģʽ
    --����ģʽ��Master-Slave��
    --Wokerģʽ��Worker-Worker��

Java�������
    --Thread/Runnable/Thread�����
    --Executor
    --Fork-Join���
    
�߳���ThreadGroup
    --�̵߳ļ���
    --���νṹ�����߳�����԰���С�߳��飬ִ�в���
    --����ͨ��enumerate�����������ڵ��̣߳�ִ�в���
    --�ܹ���Ч�������̣߳����ǹ���Ч�ʵ�
    --��������ִ�й��̸߶����
    --�ظ������̣߳��ر��̲߳������޷������߳�
Executor
      ��JDK5��ʼ�ṩExector FrameWork��java.util.concurrent.*��
          --��������Ĵ�����ִ���ߵĴ���
          --�߳��ظ����ã�new �̴߳��ۺܴ�
        �����̳߳�
            --Ԥ��ö��Thread���ɵ�������
            --���ִ�кܶ��С������
            --���񴴽���ִ�й��̽���
            --����Ա��������̳߳�ִ���������
        ��Ҫ�ࣺExectutorService��ThreadPoolExecutor��Future
            --Executor.newCachedThreadPool/newFixedThreadPool �����̳߳�
            --ExecutorService�̳߳ط���
            --Callable������߼������߳��ࣩ
            --Future���ؽ��
Fork-Join
       Java7�ṩ��һ�ֲ��п�ܣ��ֽ⡢�����ϲ������α�̣�
        �ʺ������������񲻺�ȷ���ĳ��ϣ���С�����ȷ����
        
            �ؼ���
                --ForkJoinPool �����
                --RecursiveAction
                --RecursiveTask
                �˽�Fork-Join��Executor������
                ��������ֽ�����
                ��ϤFork-Join��ܣ��ṩ���߳�ִ��Ч��
    
    �������ݽṹ
            ���õ����ݽṹ���̲߳���ȫ�� 
            --ArrayList��HashMap��HashSet��ͬ����
            --����߳�ͬʱ��д�����ܻ��׳��쳣���������
            ��ͳVector��Hashtable��ͬ���������ܹ���
            �������ݽṹ��������Ӻ�ɾ��
                ������ʽ���ϣ�������Ϊ�ջ�����ʱ���ȴ�
                ��������ʽ���ϣ�������Ϊ�ջ�����ʱ�����ȴ�������null���쳣
            
               List
                    ��Vector ͬ����ȫ��д�����
                    ��ArrayList ����ȫ
                    ��Collections.synchronizedList(List list) ����synchronized��Ч�ʲ�
                    ��CopyOnWriteArrayList ����д�٣����ڸ��ƻ��ƣ�������
                Set
                    ��HashSet ����ȫ
                    ��Collections.synchronizedSet(Set set) ����synchronized��Ч�ʲ�
                    ��CopyOnWriteArraySet(����CopyOnWriteArrayListʵ��) ����д�٣�������
                Map
                    ��Hashtable ͬ����ȫ��д�����
                    ��HashMap ����ȫ
                    ��Collections.synchronizedMap(Map map) ����synchronized��Ч�ʲ�
                    ��ConcurrentHashMap ����д�٣�������
                Queue & Deque�����У�JDK1.5�����
                     ��ConcurrentLinkedQueue ������
                     ��ArrayBlockingQueue/LinkedBlockingQueue ����
                �˽����ݽṹ������д������
                ����ҵ���ص㣬ʹ����ȷ�Ĳ������ݽṹ
    �߳�Э��
             Thread/Executor/Fork-Join
                ���߳����������У�����
                 ���߳�֮��ȱ��Э��
            synchronizedͬ��
              ���޶�ֻ��һ���̲߳��ܽ���ؼ�
                ���򵥴ֱ���������ʧ�е��
            Lock
                Lock����ʵ��ͬ����Ч��
                    ��ʵ�ָ����ӵ��ٽ����ṹ
                    ��tryLock��������Ԥ�����Ƿ����
                    ����������д�Ĳ������������һ��д
                    �����ܸ���
                ReentrantLock�࣬������Ļ�����
                ReentrantReadWriteLock�࣬������Ķ�д��
                lock��unlock����
            Semaphore
                    �ź�������1965��Dijkstra�����
                    �ź�������������һ��������
                    ����������0������ʹ�ã�����0����ʹ��
                    �������ö������������������10������
                    Semaphore   
                        ��acquire��ȡ
                        ��release�ͷ�
                    ��Lock����һ�������Կ��ƶ��ͬʱ���ʹؼ���
            Latch
                �ȴ�������һ��ͬ��������
                ����ͬ��ִ�������һ�����߶���߳�
                �������������ٽ������߹�����Դ
                CountDownLacth
                ��countDown()������1
                ��await() �ȴ�latch���0
            Barrier
                ���ϵ㣬Ҳ��һ��ͬ��������                �������߳���ĳһ�����Ͻ���ͬ��
                CyclicBarrirer
                    �����캯������Ҫͬ�����߳�����
                    ��await�ȴ������̣߳��ﵽ�����󣬾ͷ���
            Phaser
                 ����ִ�в�����׶�����ͬ��������
                  ��ÿһ���׶ν�����λ�ö��߳̽���ͬ�����������ⲽ���ٽ�����һ��
                  Phaser
                    ��arrive()
                    ��arriveAndAwaitAdvance()
            Exchanger
                �����ڲ����߳��л��ཻ����Ϣ
                ������2���߳��ж���ͬ���㣬�������̶߳�����ͬ���㣬���ǽ������ݽṹ
                Exchanger
                    ��exchange(),�߳�˫�����ཻ������
                    ������������˫���
            java.util.concurrent���ṩ�˺ܶಢ����̵Ŀ���Э����
            ����ҵ���ص㣬ʹ����ȷ���̲߳�������Э��
            ��ʱ����
                Thread/Executor/Fork-Join���߳�
                    ������ִ��
                    ����ܵ���
                ��ʱִ��
                    ���̶�ĳһ��ʱ�������
                    ����ĳһ������
                �򵥶�ʱ������
                    �����üƻ�����Ҳ������ָ��ʱ�俪ʼִ��ĳһ������
                    ��TimerTask��װ����
                    ��Timer�� ��ʱ��
                Executor+��ʱ������
                ScheduledExecutorService
                    ����ʱ����
                    ����������
                Quartz
                    ��Quartz��һ����Ϊ���Ƶ�������ȿ��
                    �����������Timer��ɢ���������
                    �����ܸ���ǿ��
                        Timerִ��������������м�ĳһ�����쳣������������ִֹ��
                        Quartzִ��������������м�ĳһ�����쳣����Ӱ����һ��ִ��
                    �˽ⶨʱ���������
                    ����ҵ���ص㣬ʹ�ú��ʵĶ�ʱ������