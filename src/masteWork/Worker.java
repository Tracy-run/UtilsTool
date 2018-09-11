package masteWork;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

//对master的处理  执行完任务装进容器中  核心worker可以有子类worker
public class Worker implements Runnable{

	private ConcurrentLinkedQueue<Task> workQueue;
	private ConcurrentHashMap<String, Object> resultMap;
	
	public void setWorkerQueue(ConcurrentLinkedQueue<Task> workQueue){
		this.workQueue = workQueue;
	}
	public void setResultMap(ConcurrentHashMap<String, Object> resultMap){
		this.resultMap = resultMap;
	}
	
	@Override
	public void run() {
		while(true){
			Task input = this.workQueue.poll();
			if(input == null) break;
			
			//做业务处理
			Object output = headle(input);
			//将每个处理结果装到master的篮子
			this.resultMap.put(Integer.toString(input.getId()), output);
		}
	}
	
	//核心处理
	private Object headle(Task input) {
		Object outPut = null;
		try {
			//表示对数据源task的处理耗时 每个任务需要0.5s 
			Thread.sleep(500);
			
			outPut = input.getPrice();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return outPut;
	}
	
	
}
