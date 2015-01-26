/*---------------------------------------------------------------------------*/

/**

 * @(#)$Id: TestSolutionForMerge.java 9561 20 Jan 2015 09:19:19 $

 * @(#) Implementation file of class TestSolutionForMerge.

 * @author SearchNLP

 *  (c)  SUNTEC CORPORATION  2015

 * All Rights Reserved.

 */

/*---------------------------------------------------------------------------*/
package net.suntec.cooljunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;

public class TestSolutionForMergeKLists {
	//测试K=0
	@Test public void mergeKListsNull(){
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		ListNode result = SolutionForMergeKLists.mergeKLists(lists);
		assertNull(result);
	}
	
	//测试K=1
	@Test public void mergeKListONE(){
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		lists.add(list);
		ListNode result = SolutionForMergeKLists.mergeKLists(lists);
		assertEquals(list, result);
	}
	
	//测试K>=2
	@Test public void mergeKListTwo(){
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		ListNode listOne = new ListNode(1);
		listOne.next = new ListNode(6);
		listOne.next.next = new ListNode(16);
		ListNode listTwo = new ListNode(2);
		listTwo.next = new ListNode(3);
		listTwo.next.next = new ListNode(4);
		listTwo.next.next.next = new ListNode(17);
		//ListNode listThree = null;
		ListNode listThree = new ListNode(5);
		lists.add(listOne);
		lists.add(listThree);
		lists.add(listTwo);
		ListNode listPre = new ListNode(1);
		listPre.next = new ListNode(2);
		listPre.next.next = new ListNode(3);
		listPre.next.next.next = new ListNode(4);
		listPre.next.next.next.next = new ListNode(5);
		listPre.next.next.next.next.next = new ListNode(6);
		listPre.next.next.next.next.next.next = new ListNode(16);
		listPre.next.next.next.next.next.next.next = new ListNode(17);
		
//		listPre.next.next.next.next = new ListNode(6);
//		listPre.next.next.next.next.next = new ListNode(16);
//		listPre.next.next.next.next.next.next = new ListNode(17);
		
		ListNode result = SolutionForMergeKLists.mergeKLists(lists);
		ListNode tempPre = listPre;
		ListNode tempRes = result;
		while(null!=tempPre&&null!=tempRes){
			assertEquals(tempPre.val, tempRes.val);
			tempPre = tempPre.next;
			tempRes = tempRes.next;	
		}	
	}
	
	

}
