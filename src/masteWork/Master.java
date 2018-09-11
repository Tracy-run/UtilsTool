package masteWork;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {

	//1.应该有一个装任务的集合
	 private ConcurrentLinkedQueue<Task> workQueue =  new ConcurrentLinkedQueue<Task>();
	//2. 使用hashmap取装所有worker的对象
	 private HashMap<String, Thread> workers = new HashMap<String,Thread>();
	 //3.使用容器装每一个worker并非执行任务的结果集  
	 private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<String, Object>();
	 
	 //4.构造方法
	 public Master(Worker worker,int workerCount){
		 worker.setWorkerQueue(this.workQueue);
		 worker.setResultMap(this.resultMap);
		 
		 for(int i =0;i<workerCount;i++){
			 //key是id  value是线程对象
			 workers.put("子节点" + Integer.toString(i),new Thread(worker));
		 }
	 }
	 
	 //5.提交方法
	 public void submit(Task task){
		 this.workQueue.add(task);
	 }
	 
	 //6.执行的方法
	 public void excute(){
		 for(Map.Entry<String, Thread> me :workers.entrySet()){
			me.getValue().start();
		 }
	 }
	 
	 //8.判断线程是否停止
	public boolean isComplete() {
		for(Map.Entry<String, Thread> me :workers.entrySet()){
			if(me.getValue().getState() != Thread.State.TERMINATED){
				return false;
			}
		 }
		return true;
	}

	//9. master返回给客户端的信息
	public int getResult() {
		int ret = 0;
		for(Map.Entry<String, Object> me :resultMap.entrySet()){
			ret += (Integer)me.getValue();
		}
		return ret;
	}
	 
	/*
	 * 整体布局的
				 					=>	worker
	任务(接受返回结果集)  =>  master  =>	worker
									=>	worker	
	*/
	
	 
}
