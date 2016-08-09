package concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTest {

	public static void main(String[] args) {
		Map map = new ConcurrentHashMap<>();
		Lock lock = new ReentrantLock();
	}

}
