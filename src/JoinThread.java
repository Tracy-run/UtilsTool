public class JoinThread extends Thread {
	public static volatile int n = 0;

	public void run() {
		for (int i = 0; i < 10; i++)
			try {
				n = n + 1;
				sleep(3); // 为了使运行结果更随机，延迟3毫秒

			} catch (Exception e) {
			}
	}

	public static void main1(String[] args) throws Exception {
		// 建立100个线程
		Thread threads[] = new Thread[100];
		int a = 100;
		for (int i = 0; i < a; i++)
			// 建立100个线程
			threads[i] = new JoinThread();
		for (int i = 0; i < threads.length; i++)
			// 运行刚才建立的100个线程
			threads[i].start();
		for (int i = 0; i < threads.length; i++)
			// 100个线程都执行完后继续
			threads[i].join(); // 每次100个线程 执行10组
		System.out.println(" n= " + JoinThread.n);
	}
	
	
	public static void main(String[] args) throws Throwable {
		 int j=0;
		 for(int i=0;i<1000;i++) {
		 j=j++;
		 }
		 System.out.println(j);
		}
	
	
	
}