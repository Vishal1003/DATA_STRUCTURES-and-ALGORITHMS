package Fenwick_Tree;

public class FenwickTree {

	public int[] createTree(int[] input) {
		
		int ft[] = new int[input.length + 1];
		for (int i = 1; i <= input.length; i++) {
			updateFT(ft, input[i - 1], i);
		}
		
		return ft;
	}

	public void updateFT(int ft[], int val, int idx) {

		while (idx < ft.length) {
			ft[idx] += val;
			idx = getNext(idx);
		}
	}

	private int getNext(int idx) {
		return idx + (idx & -idx);
	}

	private int getParent(int idx) {
		return idx - (idx & -idx);
	}

	public int getSum(int ft[], int idx) {

		idx += 1;
		int sum = 0;

		while (idx > 0) {
			sum += ft[idx];
			idx = getParent(idx);
		}

		return sum;

	}

}
