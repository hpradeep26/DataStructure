package com.ds.java.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class _L_104_MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		TreeNode l2 = new TreeNode(5);
		TreeNode l1 = new TreeNode(4,l2,null);
		TreeNode r2 = new TreeNode(7);
		TreeNode r1 = new TreeNode(6,null,r2);
		TreeNode treeNode = new TreeNode(1, l1, r1);
		System.out.println(maxDepth(treeNode));
	}
	
	public static int maxDepth(TreeNode root) {
		
		if(root==null) {
			return 0;
		}
		int level = 0;
		Queue<TreeNode> node = new LinkedList<>();
		
		node.add(root);
		
		while(!node.isEmpty()) {
			int size = node.size();
			level++;
			for(int i =0;i<size;i++) {
				TreeNode pollNode = node.poll();
				if(pollNode.left!=null) node.add(pollNode.left);
				if(pollNode.right!=null) node.add(pollNode.right);
			}
		}
		
		return level;
		
	}
}
