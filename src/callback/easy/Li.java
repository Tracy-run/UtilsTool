package callback.easy;


public class Li {

	
	public void answerQuestion(CallBack callback,String question){
		System.out.println("小王的问题是：" + question);
		
		//处理逻辑
		String result = "答案是。。。。，，，，。。";
		
		callback.solve(result);
	}
}
