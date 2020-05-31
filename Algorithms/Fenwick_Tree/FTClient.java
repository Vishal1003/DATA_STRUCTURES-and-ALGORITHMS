package Fenwick_Tree;

public class FTClient {

	public static void main(String[] args) {
		
		FenwickTree tree = new FenwickTree();
		int[] input = {1, 2, 3, 4, 5, 6, 7};
		
		int ft[] = tree.createTree(input);
		
		System.out.println(tree.getSum(ft, 5)); // 21 

	}

}
