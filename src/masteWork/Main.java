package masteWork;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		//创建10个线程进行工作
		Master master = new Master(new Worker(),10) ;
		Random r = new Random();
		for(int i =0;i<100;i++){
			Task t = new Task();
			t.setId(i);
			t.setName("任务" + i);
			t.setPrice(r.nextInt(1000));
			master.submit(t);//提交任务
		}
		master.excute(); //执行任务
		
		long start = System.currentTimeMillis();
		while(true){
			if(master.isComplete()){
				long end = System.currentTimeMillis() - start;
				int result = master.getResult();
				System.out.println("最终结果 " + result + " 耗时 " + end);
				break;
			}
		}
	}
}
