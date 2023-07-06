package Thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadArr1 extends Thread{

	private Logger log = LoggerFactory.getLogger(ThreadArr1.class);
	private int[] arr;
	private int n;
	private int ep;
	private int sum;
	
	public ThreadArr1(int[] arr, int n, int ep) {
		this.arr = arr;
		this.n = n;
		this.ep = ep;
		this.sum = 0;
	}
	
	public int getSum() {
		return sum;
	}

	@Override
	public void run() {
		for(int i = n; i < ep; i++) {
			sum += arr[i];
		}
		log.info("Array Sum:" + sum);
	}

}
