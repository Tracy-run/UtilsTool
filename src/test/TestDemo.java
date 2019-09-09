package test;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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
	
	
	
	
	
public static void main(String [] args){
        
        //Scanner scan = new Scanner(System.in);
        
        int size = 7; //scan.nextInt();
        String member = "3 4 1 5 6 2 7";//scan.nextLine();
        String [] arr = member.split(" ");
        
        for(int i=0;i<size;i++){
            int temp = Integer.valueOf(arr[i]);
            System.out.print(left(arr,temp,i));
            System.out.println(right(arr,temp,i));
        }
        
    }
    
	public static String left(String [] arr,int temp, int n){
	    String str = "";
	    h:for(int a = 0;a< n;a++){
	        if(n == 0){
	            str += (-1 + " ");
	            break;
	        }
	        int tt = a;
	        while(tt <= n){
		        if(tt <= n){
		          if(Integer.valueOf(arr[n-tt]) <temp){
		              str+= (n-tt) + (" ");
		              break h;
		          }
		        }
		        tt++;
	        }
	    }
	    if(str.equals("") || str == null){
	    	System.out.print("");
	    }
	    return str .equals("") ? "-1 ": str;
	}	
	
	public static String right(String [] arr,int temp, int n){
	    String sb = "";
	    h:for(int a = n;a< arr.length;a++){
	        if(n == arr.length){
	            sb+=(-1 + "");
	            break;
	        }
	        int tt = a;
	        while(tt >= n){
		        if(tt >= n && tt<arr.length){
		          if(Integer.valueOf(arr[tt]) <temp){
		              sb+= (tt) + (" ");
		              break h;
		          }
		        }
		        tt++;
	        }
	    }
	    return sb.equals("")? "-1": sb;
	}
	
	
	
	
	
	
	
	
	
}
