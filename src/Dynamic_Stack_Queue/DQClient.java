package Dynamic_Stack_Queue;

public class DQClient {

	public static void main(String[] args) throws Exception {

		DynamicQueue dq = new DynamicQueue();

		dq.enqueue(10);
		dq.enqueue(20);
		dq.enqueue(30);
		dq.enqueue(40);
		dq.enqueue(50);
		System.out.println(dq.dequeue());
		System.out.println(dq.dequeue());
		dq.enqueue(60);
		dq.enqueue(70);
		dq.enqueue(80);

		dq.display();

	}

//	display reverse of queue
	public static void dispReverse(DynamicQueue q, int count) throws Exception {
		if (count == q.size()) {
			return;
		}

		int temp = q.dequeue();
		q.enqueue(temp);

		dispReverse(q, count + 1);

		System.out.println(temp);

	}

//	actual reverse of queue
	public static void actualReverse(DynamicQueue q) throws Exception {
		if (q.isEmpty()) {
			return;
		}

		int temp = q.dequeue();

		actualReverse(q);

		q.enqueue(temp);

	}

//	first negative integer in every window of size k
	public static void firstNegativeInteger(int[] arr, int k) throws Exception {

		DynamicQueue q = new DynamicQueue();

		for (int i = 0; i < k; i++) {

			if (arr[i] < 0) {
				q.enqueue(i);
			}
		}

		for (int i = k; i < arr.length; i++) {
			if (q.isEmpty())
				System.out.println("0");

			else
				System.out.println(arr[q.getFront()]);

			if (!q.isEmpty() && q.getFront() <= i - k)
				q.dequeue();

			if (arr[i] < 0)
				q.enqueue(i);

		}

		if (q.isEmpty())
			System.out.println("0");
		else
			System.out.println(arr[q.getFront()]);

	}

}
