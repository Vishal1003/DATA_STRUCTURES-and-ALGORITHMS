package Queue;

public class QueueClient {

	public static void main(String[] args) throws Exception {

		Queue q = new Queue(4);

		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

		q.enqueue(50);
		q.enqueue(60);
		q.display();

		q.dequeue();
		q.dequeue();

		q.dequeue();
		q.display();
	}

}
