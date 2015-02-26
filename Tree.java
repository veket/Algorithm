/*---------------------------------------------------------------------------*/

/**

 * @(#)$Id: Tree.java 9561 2015-2-10 下午01:35:44 $

 * @(#) Implementation file of class Tree.

 * @author SearchNLP

 *  (c)  SUNTEC CORPORATION  2015

 * All Rights Reserved.

 */

/*---------------------------------------------------------------------------*/
package net.suntec.cooljunit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author veket
 *
 */
public class Tree {
	private int id; //tree fragment id
	private String word;
	private String tag;
	private int size = 1;
	private int depth = 1;
	private List<Tree> leftChildren;
	private List<Tree> rightChildren;
	private Tree parent = null;
	
	public Tree(int num){
		id = num;
		leftChildren = new ArrayList<Tree>();
		rightChildren = new ArrayList<Tree>();
	}
	
	public Tree(int num, String str){
		id = num;
		word = str;
		leftChildren = new ArrayList<Tree>();
		rightChildren = new ArrayList<Tree>();
	}
	
	public Tree(int num, String str1, String str2){
		id = num;
		word = str1;
		tag = str2;
		leftChildren = new ArrayList<Tree>();
		rightChildren = new ArrayList<Tree>();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @param depth the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * @return the leftChildren
	 */
	public List<Tree> getLeftChildren() {
		return leftChildren;
	}

	/**
	 * @param leftChildren the leftChildren to set
	 */
	public void setLeftChildren(List<Tree> leftChildren) {
		this.leftChildren = leftChildren;
	}

	/**
	 * @return the rightChildren
	 */
	public List<Tree> getRightChildren() {
		return rightChildren;
	}

	/**
	 * @param rightChildren the rightChildren to set
	 */
	public void setRightChildren(List<Tree> rightChildren) {
		this.rightChildren = rightChildren;
	}

	/**
	 * @return the parent
	 */
	public Tree getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Tree parent) {
		this.parent = parent;
	}
	
	public void addLeftChild(Tree ch) {
		int id = ch.id;
		int i=0;
		if(null!=leftChildren){
			for(;i<leftChildren.size();i++){
				int cid = leftChildren.get(i).id;
				if(cid>id)
					break;
			}		
		}
		leftChildren.add(i, ch); //按id升序插入
		ch.setParent(this);
		updatesize(ch.size);
	}
	
	public void addRightChild(Tree ch)    {
		rightChildren.add(ch);
		ch.setParent(this);
		updatesize(ch.size);
	}
	/**
	 * 更新树大小
	 * @param size
	 */
	private void updatesize(int size) {
		this.size+=size;
		if(parent!=null){
			parent.updatesize(size);
		}


	}
}
