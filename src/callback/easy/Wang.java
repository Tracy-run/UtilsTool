package callback.easy;


public class Wang implements CallBack{

	@Override
	public void solve(String result) {
		System.out.println("这就是小李给的答案: " + result);
	}

	public Li li;

	public Wang(Li li){
		this.li = li;
	}
	
	public void askQuestion(final String question){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				li.answerQuestion(Wang.this, question);
			}
		}).start();
		
		play();
	}
	
	public void play(){
		System.out.println("我要去外太空了");
	}
}
