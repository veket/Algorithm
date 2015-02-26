/*---------------------------------------------------------------------------*/

/**

 * @(#)$Id: TestTreeKernel.java 9561 2015-2-15 上午09:57:57 $

 * @(#) Implementation file of class TestTreeKernel.

 * @author SearchNLP

 *  (c)  SUNTEC CORPORATION  2015

 * All Rights Reserved.

 */

/*---------------------------------------------------------------------------*/
package net.suntec.cooljunit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author veket
 *
 */
public class TestTreeKernel {
	//空树时
	@Test public void calcTreeNull(){
		float target = 0.0f;
		Tree tr1 = null;
		Tree tr2 = null;
		float result = TreeKernel.calc(tr1, tr2);
		assertEquals(target, result, 10e-6);
	}
	//相同树时
	@Test public void calcTreeDeep(){
		float target = 1.0f;
		Tree tr1 = new Tree(1, "", "S");
		Tree tr2 = new Tree(1, "", "S");
		Tree tr3 = new Tree(2, "", "NP");
		Tree tr4 = new Tree(3, "", "VP");
		Tree tr5 = new Tree(4, "", "N");
		Tree tr6 = new Tree(5, "", "V");
		Tree tr7 = new Tree(6, "", "D");
		Tree tr8 = new Tree(7, "", "NP");
		tr8.addLeftChild(tr7);
		tr8.addRightChild(tr5);
		tr4.addLeftChild(tr6);
		tr4.addRightChild(tr8);
		tr3.addLeftChild(tr5);
		tr1.addLeftChild(tr3);
		tr2.addLeftChild(tr3);
		tr1.addRightChild(tr4);
		tr2.addRightChild(tr4);
			
		float result = TreeKernel.calc(tr1, tr2);
		assertEquals(target, result, 10e-6);	
	}
	//待添加

}
