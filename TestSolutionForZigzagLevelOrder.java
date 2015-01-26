/*---------------------------------------------------------------------------*/

/**

 * @(#)$Id: TestSolution.java 9561 19 Jan 2015 16:44:20 $

 * @(#) Implementation file of class TestSolution.

 * @author SearchNLP

 *  (c)  SUNTEC CORPORATION  2015

 * All Rights Reserved.

 */

/*---------------------------------------------------------------------------*/
package net.suntec.cooljunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class TestSolutionForZigzagLevelOrder {
	
	//测试空二叉树的zigzagLevelOrder
	@Test public void zigzagLevelOrderNull(){
		TreeNode root = null;
		ArrayList<ArrayList<Integer>> result = SolutionForZigzagLevelOrder.zigzagLevelOrder(root);
		assertTrue(result.isEmpty());		
	}
	
	//测试单节点二叉树的zigzagLevelOrder
	@Test public void zigzagLevelOrderRoot(){
		TreeNode root = new TreeNode(3);
		
		ArrayList<ArrayList<Integer>> target = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(3);
		target.add(temp);
		ArrayList<ArrayList<Integer>> result = SolutionForZigzagLevelOrder.zigzagLevelOrder(root);
		
		assertEquals(target,result);
	}
	
	//测试只有左/右子树的二叉树的zigzagLevelOrder
	@Test public void zigzagLevelOrderLeftOrRight(){
		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.left.left = new TreeNode(3);
//		root.left.left.left = new TreeNode(4);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
		
		ArrayList<ArrayList<Integer>> target = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp1 = new ArrayList<Integer>();
		temp1.add(1);
		target.add(temp1);
		ArrayList<Integer> temp2 = new ArrayList<Integer>();
		temp2.add(2);
		target.add(temp2);
		ArrayList<Integer> temp3 = new ArrayList<Integer>();
		temp3.add(3);
		target.add(temp3);
		ArrayList<Integer> temp4 = new ArrayList<Integer>();
		temp4.add(4);
		target.add(temp4);
		
		ArrayList<ArrayList<Integer>> result = SolutionForZigzagLevelOrder.zigzagLevelOrder(root);
		
		assertEquals(target, result);	
	}
	
	//测试普通二叉树的zigzagLevelOrder	
	@Test public void zigzagLevelOrderNormalOne(){
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		ArrayList<ArrayList<Integer>> target = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp1 = new ArrayList<Integer>();
		temp1.add(3);
		target.add(temp1);
		ArrayList<Integer> temp2 = new ArrayList<Integer>();
		temp2.add(20);
		temp2.add(9);
		target.add(temp2);
		ArrayList<Integer> temp3 = new ArrayList<Integer>();
		temp3.add(15);
		temp3.add(7);
		target.add(temp3);
		
		ArrayList<ArrayList<Integer>> result = SolutionForZigzagLevelOrder.zigzagLevelOrder(root);
		
		assertEquals(target, result);
	}
	
	//测试普通二叉树的zigzagLevelOrder	
	@Test public void zigzagLevelOrderNormalTwo(){
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.left.left = new TreeNode(4);
		root.right.left.right = new TreeNode(5);
		
		ArrayList<ArrayList<Integer>> target = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp1 = new ArrayList<Integer>();
		temp1.add(1);
		target.add(temp1);
		ArrayList<Integer> temp2 = new ArrayList<Integer>();
		temp2.add(2);
		target.add(temp2);
		ArrayList<Integer> temp3 = new ArrayList<Integer>();
		temp3.add(3);
		target.add(temp3);
		ArrayList<Integer> temp4 = new ArrayList<Integer>();
		temp4.add(5);
		temp4.add(4);
		target.add(temp4);
		
		ArrayList<ArrayList<Integer>> result = SolutionForZigzagLevelOrder.zigzagLevelOrder(root);
		
		assertEquals(target, result);
	}
	
}
