package com.ds.java.binarytree;

import java.util.ArrayList;
import java.util.List;

public class _L_872_Leaf_similar_Tree {

	public static void main(String[] args) {
		TreeNode l4 = new TreeNode(7);
		TreeNode r4 = new TreeNode(4);
		TreeNode r3 = new TreeNode(2, l4, r4);
		TreeNode l3 = new TreeNode(6);
		TreeNode l2 = new TreeNode(5, l3, r3);
		TreeNode t9 = new TreeNode(9);
		TreeNode t8 = new TreeNode(8);
		TreeNode r2 = new TreeNode(1, t9, t8);
		TreeNode treeNode1 = new TreeNode(3, l2, r2);
		leafSimilar(treeNode1, treeNode1);
	}
	
	 public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
		
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		dfs(l1, root1);
		dfs(l2, root2);
		 
		return l1.equals(l2);
	 }
	 
	 public static void dfs(List<Integer> leafList,TreeNode root) {
		 
		 if(root==null) {
			 return;
		 }
		 
		 if(root.left==null &&root.right==null) {
			 leafList.add(root.val);
		 }
		 
		 dfs(leafList,root.left);
		 dfs(leafList,root.right);
	 }
	 
}
