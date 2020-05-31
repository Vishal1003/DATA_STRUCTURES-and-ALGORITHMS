package Dynamic_Stack_Queue;

import Stacks.Stack;

public class DynamicStack extends Stack {

	@Override
	public void push(int item) {
		if (isFull()) {

			int[] na = new int[this.data.length * 2];

			// copy
			for (int i = 0; i < this.data.length; i++) {
				na[i] = this.data[i];
			}

			// reference change
			this.data = na;

		}

		try {
			super.push(item);
		} catch (Exception e) {

		}

	}

}
