package executor;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class MyRejected implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("自定义处理");
		
		System.out.println(r.toString());
		System.out.println(executor.getQueue().size());
		
	}

	public static void main(String[] args) {
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}, new Date(),1000);
	}
}
