package cn.piao888.threadmq.Service;

import cn.piao888.threadmq.thread.DisposeThread;
import cn.piao888.threadmq.utils.threadutils.Recv;

public class DisposeServiceImpl {
    public void starts(){
        Integer i=0;
       while(i<5){
            DisposeThread disposeThread=new DisposeThread(new Recv());
            Thread thread=new Thread(disposeThread,Integer.toString(i));
            thread.start();
            i++;
        }
        System.out.println("开启成功");
    }

    public static void main(String[] args) {
        DisposeServiceImpl disposeService=new DisposeServiceImpl();
        disposeService.starts();
    }
}
