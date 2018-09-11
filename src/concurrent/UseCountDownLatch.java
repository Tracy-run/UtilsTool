package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class UseCountDownLatch implements Callable<VerifyError>{

	public static void main(String[] args) {
		
		final CountDownLatch countdown = new CountDownLatch(3);
		countdown.countDown();
		
		CyclicBarrier barrr = new CyclicBarrier(3);
	}

	@Override
	public VerifyError call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
