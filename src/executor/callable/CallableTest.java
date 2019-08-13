package executor.callable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

	private static int poolsize = 5;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Date time1 = new Date();
		ExecutorService ThreadPool = Executors.newFixedThreadPool(poolsize);
		List<Future> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Callable call = new callTest(i + "");
			Future future = ThreadPool.submit(call);
			
			list.add(future);
		}
		
		ThreadPool.shutdown();
		
		for (Future ture:list) {
			System.out.println(">>> " + ture.get().toString());
		}
		
		Date time2 = new Date();
		System.out.println("线程运行结束；总耗时：" + (time2.getTime() - time1.getTime()));
	}
	
}




class callTest implements Callable<Object>{
	
	private String num;
	callTest(String Num){
		this.num = Num;
	}
	
	@Override
	public Object call() throws Exception {
		System.out.println("线程 " + num + "开始执行");
		Date time1 = new Date();
		Thread.sleep(1000);
		Date time2 = new Date();
		System.out.println("线程 " + num + "运行  结束");
		return "线程 "+num+ " 耗时：" + (time2.getTime()-time1.getTime());
	}
	
	
	
}
 
