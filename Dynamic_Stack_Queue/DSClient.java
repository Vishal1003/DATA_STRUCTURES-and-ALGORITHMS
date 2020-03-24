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
//		DynamicStack helper = new DynamicStack();
//		actualReverse(ds, helper);
//		ds.display();

		int[] arr = { 50, 30, 20, 60, 45, 40, 70, 65 };
		nextGreaterElement(arr);

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

//	nextGreater Element in array
	public static void nextGreaterElement(int[] arr) throws Exception {

		DynamicStack s = new DynamicStack();

		for (int i = 0; i < arr.length; i++) {

			while (!s.isEmpty() && s.peek() < arr[i]) {
				System.out.println(s.pop() + "->" + arr[i]);
			}

			s.push(arr[i]);
		}

		while (!s.isEmpty()) {
			System.out.println(s.pop() + "-> -1");
		}

	}

//	nextGreater Element Index wise
	public static int[] nextGreaterIndex(int[] arr) throws Exception {

		int[] ans = new int[arr.length];
		DynamicStack s = new DynamicStack();

		for (int i = 0; i < arr.length; i++) {

			while (!s.isEmpty() && s.peek() < arr[i]) {
				ans[s.peek()] = arr[i];
			}

			s.push(arr[i]);

		}

		while (!s.isEmpty()) {
			ans[s.pop()] = -1;
		}

		return ans;

	}

	
}
