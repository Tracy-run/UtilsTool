package callback.easy;

public class Test111 {

	public static void main1(String[] args) {
		Li li = new Li();
		Wang wang = new Wang(li);
		wang.askQuestion("1+1=?");
	}
	
	
}
