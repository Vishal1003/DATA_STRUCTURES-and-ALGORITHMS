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

//		displayReverse(ds);
		DynamicStack helper = new DynamicStack();
		actualReverse(ds, helper);
		ds.display();

	}

//	display reverse of the Stack
	public static void displayReverse(DynamicStack s) throws Exception {

		if (s.size() == 0) {
			return;
		}

		int temp = s.pop();
		displayReverse(s);

		System.out.println(temp);
		s.push(temp);

	}

//	reverse the original stack
	public static void actualReverse(DynamicStack s, DynamicStack helper) throws Exception {

		if (s.size() == 0) {

			if (helper.size() == 0) {
				return;
			}
			int temph = helper.pop();
			actualReverse(s, helper);

			s.push(temph);
			return;
		}

		int temp = s.pop();
		helper.push(temp);
		
		actualReverse(s, helper);
		return;

	}
	
	

}
