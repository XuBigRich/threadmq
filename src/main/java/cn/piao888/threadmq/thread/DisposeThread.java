package cn.piao888.threadmq.thread;

import cn.piao888.threadmq.utils.threadutils.HandlerDataSource;
import cn.piao888.threadmq.utils.threadutils.Recv;

public class DisposeThread implements Runnable {
    private Recv recv;
    public DisposeThread(Recv recv){
        this.recv = recv;
    }
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());
            HandlerDataSource.putDataSource(Thread.currentThread().getName());
//            recv.oldMethod();
            recv.newMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
