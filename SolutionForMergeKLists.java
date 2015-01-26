/*---------------------------------------------------------------------------*/

/**

 * @(#)$Id: SolutionForMerge.java 9561 19 Jan 2015 19:47:45 $

 * @(#) Implementation file of class SolutionForMerge.

 * @author SearchNLP

 *  (c)  SUNTEC CORPORATION  2015

 * All Rights Reserved.

 */

/*---------------------------------------------------------------------------*/
package net.suntec.cooljunit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionForMergeKLists {
	public static ListNode mergeKLists(ArrayList<ListNode> lists){
		
		if(0==lists.size()) return null; //判空
		
		Comparator<ListNode> ascendOrder = new Comparator<ListNode>(){
			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				int value1 = o1.val;
				int value2 = o2.val;
				if(value1>value2) return 1; //从小到大
				else if(value1==value2) return 0;
				else return -1;
			}
			
		};
		
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),ascendOrder);
		
		//K个链表的第一个结点入队列
		for(ListNode list:lists){
			if(null!=list)
				pq.add(list);
		}
		
		ListNode head = new ListNode(0);
		ListNode p = head;
		
		while(pq.size()>0){
			ListNode temp = pq.poll();
			p.next = temp;
			if(null!=temp.next)
				pq.add(temp.next);
			p = p.next;
		}
		return head.next;
	}

}
