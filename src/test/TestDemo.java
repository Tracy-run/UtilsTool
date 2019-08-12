package test;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestDemo extends Thread {

	public static void main1(String[] args) throws Exception {

		// BufferedReader in
		// PrintWriter out

		Properties prop = new Properties();
		prop.load(new FileInputStream("xxxx.txt"));

		Object obj = prop.get("xxx");
		String value = prop.getProperty("xx");

		//1. className;
		Class className = Class.forName("xxx.class");
		className.newInstance();

		//2
		Object str = new String();
		str.getClass();
		
		//3 类名.class
		Class  clas = String.class;
	}
	
	public static void main(String[] args) throws Throwable {
		 int j=0;
		 new HashMap<>();
		 new ArrayList<>();
		 new Stack<>();
		 new HashSet<>();
		 System.gc();
		 for(int i=0;i<1000;i++) {
			 j=j++;
		 }
		 System.out.println(j);
		 
		 
//		 HashMap<String, String> maps = new HashMap<>();
//		 String value = null;
//		 
//		 List<HashMap<String, String>> lsit = new ArrayList<>();
//		 lsit.stream().map();
		 
		 List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//		 List<Integer> result = list.stream().filter().collect(toList());
		 
		 List<Integer> list1 = Arrays.asList(0, 1, 2, 3);
//		 int count = list1.stream().reduce(0, (acc, item) -> acc + item).intValue();
		 
		 
		 ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);
		 newScheduledThreadPool.submit(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
			}
		 });
		 newScheduledThreadPool.schedule(new Runnable() {
			public void run() {
				
			}
		 }, 1,TimeUnit.DAYS);
		 
		 
		 ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		 newFixedThreadPool.execute(new Runnable() {
			@Override
			public void run() {
				//实现业务逻辑
			}
		});
		 
		 ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		 newCachedThreadPool.submit(new Runnable() {
			
			@Override
			public void run() {
				
			}
		});
		
		 ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		 newSingleThreadExecutor.submit(new Runnable() {
			@Override
			public void run() {
				
			}
		});
	
	}
	
	
}
