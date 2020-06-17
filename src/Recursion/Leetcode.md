## 1. Range Sum of BST

Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
The binary search tree is guaranteed to have unique values.

Example 1:
Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32

##### SOLUTION

	class Solution {
	    public int rangeSumBST(TreeNode root, int L, int R) {
	        if(root == null){
	            return 0;
	        }  
	        if(root.val > R){
	            return rangeSumBST(root.left, L, R);
	        }
	        if(root.val < L){
	            return rangeSumBST(root.right, L, R);
	        }
	        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
	    }
	 }

## 2. Longest Univalue Path
Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

The length of path between two nodes is represented by the number of edges between them.

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	class Solution {
	    int ans;
	    public int longestUnivaluePath(TreeNode root) {
		ans = 0;
		arrowLength(root);
		return ans;
	    }
	    public int arrowLength(TreeNode node) {
		if (node == null) return 0;
		int left = arrowLength(node.left)
		int right = arrowLength(node.right);
		int arrowLeft = 0, arrowRight = 0;
		if (node.left != null && node.left.val == node.val) {
		    arrowLeft += left + 1;
		}
		if (node.right != null && node.right.val == node.val) {
		    arrowRight += right + 1;
		}
		ans = Math.max(ans, arrowLeft + arrowRight);
		return Math.max(arrowLeft, arrowRight);
	    }
	}




