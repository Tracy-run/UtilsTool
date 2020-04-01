package test;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.Scanner;
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
	
	public static void main2(String[] args) throws Throwable {
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
		 
		 Scanner scan = new Scanner(System.in);
		 int nextInt = scan.nextInt();
		 String nextLine = scan.nextLine();
		 
		 
	
	}
	
	
	
	
	
	public static void main23(String [] args){
        
        char [] str = new char[]{'a','b','c','d','e'};
        helper(0, str);
    }

    public static void helper(int index, char [] str) {
        if (str == null || index >= 5) {
            return;
        }
        System.out.print(str[index]);
        helper(index + 1, str);
         
        System.out.print("#");
         
        System.out.print("*");
        System.out.print(str[index]);
    }
        
    
    public static ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
	
    public static void mai111n(String [] args){
	    SimpleDateFormat format = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss");
    	System.out.println("start:" + format.format(new Date()));
		for(int i=0;i<10000;i++){
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			 newCachedThreadPool.submit(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		System.out.println("end:" + format.format(new Date()));
	}
    
    public static void main(String [] args){
    	test(null);
    }
    
    public static void test(String temp){
        String [] temps = "111100111110011".split(" ");
        
        
        
        System.out.println();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
