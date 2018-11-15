package futuretask;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

public class FutureTaskForMultiCompute {
    
    public static void main(String[] args) {
        
        FutureTaskForMultiCompute inst=new FutureTaskForMultiCompute();
        // 创建任务集合
        List<FutureTask<Integer>> taskList = new ArrayList<FutureTask<Integer>>();
        // 创建线程池
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            // 传入Callable对象创建FutureTask对象
            FutureTask<Integer> ft = new FutureTask<Integer>(inst.new ComputeTask(i, ""+i));
            taskList.add(ft);
            // 提交给线程池执行任务，也可以通过exec.invokeAll(taskList)一次性提交所有任务;
            exec.submit(ft);
        }
        
        System.out.println("所有计算任务提交完毕, 主线程接着干其他事情！");

        // 开始统计各计算线程计算结果
        Integer totalResult = 0;
        for (FutureTask<Integer> ft : taskList) {
            try {
                //FutureTask的get方法会自动阻塞,直到获取计算结果为止
                totalResult = totalResult + ft.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        // 关闭线程池
        exec.shutdown();
        System.out.println("多任务计算后的总结果是:" + totalResult);

    }

    private class ComputeTask implements Callable<Integer> {

        private Integer result = 0;
        private String taskName = "";
        
        public ComputeTask(Integer iniResult, String taskName){
            result = iniResult;
            this.taskName = taskName;
            System.out.println("生成子线程计算任务: "+taskName);
        }
        
        public String getTaskName(){
            return this.taskName;
        }
        
        @Override
        public Integer call() throws Exception {
            // TODO Auto-generated method stub

            for (int i = 0; i < 100; i++) {
                result =+ i;
            }
            // 休眠5秒钟，观察主线程行为，预期的结果是主线程会继续执行，到要取得FutureTask的结果是等待直至完成。
            Thread.sleep(5000);
            System.out.println("子线程计算任务: "+taskName+" 执行完成!");
            return result;
        }
    }
    
    
    
    
    
//    ###################################################
//   假设有一个带key的连接池，当key存在时，即直接返回key对应的对象；当key不存在时，则创建连接链接
    private Map<String, Connection> connectionPool = new HashMap<String, Connection>();
    private ReentrantLock lock = new ReentrantLock();
    
    public Connection getConnection(String key){
        try{
            lock.lock();
            if(connectionPool.containsKey(key)){
                return connectionPool.get(key);
            }
            else{
                //创建 Connection
                Connection conn = createConnection();
                connectionPool.put(key, conn);
                return conn;
            }
        }
        finally{
            lock.unlock();
        }
    }
    
    //创建Connection
    private Connection createConnection(){
        return null;
    }
    
    
//    ###################################################
//    通过加锁确保高并发环境下的线程安全，也确保了connection只创建一次，然而确牺牲了性能
//    改用ConcurrentHash的情况下，几乎可以避免加锁的操作，性能大大提高，
//    但是在高并发的情况下有可能出现Connection被创建多次的现象。这时最需要解决的问题就是当key不存在时，
//    创建Connection的动作能放在connectionPool之后执行，这正是FutureTask发挥作用的时机
//    
private ConcurrentHashMap<String,FutureTask<Connection>> connectionPool1 = new ConcurrentHashMap<String, FutureTask<Connection>>();
    
    public Connection getConnection1(String key) throws Exception{
        FutureTask<Connection> connectionTask = connectionPool1.get(key);
        if(connectionTask!=null){
            return connectionTask.get();
        }
        else{
            Callable<Connection> callable = new Callable<Connection>(){
                @Override
                public Connection call() throws Exception {
                    return createConnection1();
                }
            };
            FutureTask<Connection> newTask = new FutureTask<Connection>(callable);
            connectionTask = connectionPool1.putIfAbsent(key, newTask);
            if(connectionTask==null){
                connectionTask = newTask;
                connectionTask.run();
            }
            return connectionTask.get();
        }
    }
    
    //创建Connection
    private Connection createConnection1(){
        return null;
    }
    
//    ###################################################
}
