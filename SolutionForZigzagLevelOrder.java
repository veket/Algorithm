/*---------------------------------------------------------------------------*/

/**

 * @(#)$Id: Solution.java 9561 19 Jan 2015 16:43:10 $

 * @(#) Implementation file of class Solution.

 * @author SearchNLP

 *  (c)  SUNTEC CORPORATION  2015

 * All Rights Reserved.

 */

/*---------------------------------------------------------------------------*/
package net.suntec.cooljunit;

import java.util.ArrayList;
import java.util.LinkedList;

public class SolutionForZigzagLevelOrder {

	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (null == root)
			return res;

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		boolean flag = true;
		while (!queue.isEmpty()) {
			ArrayList<Integer> list = new ArrayList<Integer>();

			if (flag) {
				// 顺序
				TreeNode last = queue.getLast();
				TreeNode node = null;
				do {
					node = queue.getFirst();
					list.add(node.val);

					if (null != node.left)
						queue.addLast(node.left);
					if (null != node.right)
						queue.addLast(node.right);

					queue.removeFirst();
					if (queue.isEmpty())
						break;

				} while (node != last);
			} else {
				// 逆序
				TreeNode first = queue.getFirst();
				TreeNode node = null;
				do {
					node = queue.getLast();
					list.add(node.val);

					if (null != node.right)
						queue.addFirst(node.right);
					if (null != node.left)
						queue.addFirst(node.left);

					queue.removeLast();
					if (queue.isEmpty())
						break;
				} while (node != first);
			}
			flag = !flag;
			res.add(list);
		}

		return res;
	}
}
