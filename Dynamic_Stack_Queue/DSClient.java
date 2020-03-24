package Dynamic_Stack_Queue;

public class DSClient {

	public static void main(String[] args) throws Exception {

		DynamicStack ds = new DynamicStack();
		ds.push(10);
		ds.push(20);
		ds.push(30);
		ds.push(40);
		ds.push(50);
		ds.push(60);
		ds.push(70);
//		ds.display();
		
		
		displayReverse(ds);

	}

	public static void displayReverse(DynamicStack s) throws Exception {

		if (s.size() == 0) {
			return;
		}

		int temp = s.pop();

		displayReverse(s);

		System.out.println(temp);
		s.push(temp);

	}

}
