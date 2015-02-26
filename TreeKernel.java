
/*---------------------------------------------------------------------------*/

/**

 * @(#)$Id: TreeKernel.java 9561 2015-2-10 下午12:10:21 $

 * @(#) Implementation file of class TreeKernel.

 * @author SearchNLP

 *  (c)  SUNTEC CORPORATION  2015

 * All Rights Reserved.

 */

/*---------------------------------------------------------------------------*/
package net.suntec.cooljunit;

/**
 * 计算两棵树的相似性
 * References: Collins, Michael; Duffy, Nigel (2001). "Convolution kernels for natural language". Advances in Neural Information Processing Systems.
 *              
 */
public class TreeKernel {	
	private static double scaleFactor = 0.2; //0<scaleFactor<=1
	
	public static float calc(Tree tr1, Tree tr2){
		//get the normalize the kernel
		float score = 0.0f;
		if(null==tr1||null==tr2) return score;
		float tr1Score = getScore(tr1, tr1, 1);
		float tr2Score = getScore(tr2, tr2, 1);
		return (float) (getScore(tr1, tr2,1)/Math.sqrt(tr1Score*tr2Score));
		
	}
	
	public static float getScore(Tree tr1, Tree tr2, int depth){
		float score = 0.0f;
		float modify = getDepthModify(depth);
		if(modify == 0)
			return score;
		
		//the productions at n1 and n2 are different
		if(!isSame_production(tr1, tr2)) 
			return score;
		//the productions at n1 and n2 are the same, and n1 and n2 are pre-terminals
		if(isSame_production(tr1, tr2)&&is_preTerminals(tr1, tr2))
			return score+=scaleFactor;
		
		//the productions at n1 and n2 are the same and n1 and n2 are not pre-terminals
		score = 1.0f;	
		for(int i = 0; i< tr1.getLeftChildren().size(); ++i)
			for(int j = 0; j< tr2.getLeftChildren().size(); ++j)
				score = score*(1+getScore(tr1.getLeftChildren().get(i), tr2.getLeftChildren().get(j), depth+1));
		
		for(int i = 0; i< tr1.getRightChildren().size(); ++i)
			for(int j = 0; j< tr2.getRightChildren().size(); ++j)
				score = score*(1+getScore(tr1.getRightChildren().get(i), tr2.getRightChildren().get(j), depth+1));
		
		return (float) (score*scaleFactor);
	}
	
	public static boolean isSame_production(Tree tr1, Tree tr2){
		boolean flag = false;
		if(tr1.getSize()<1||tr2.getSize()<1)
			return flag;
		else if((tr1.getTag().equals(tr2.getTag())))
			//	&&tr1.getRightChildren().get(0).getTag().equals(tr2.getRightChildren().get(0).getTag())))
			flag = true;
		return flag;
	}
	
	public static boolean is_preTerminals(Tree tr1, Tree tr2){
		boolean flag = false;
		if((tr1.getLeftChildren().isEmpty()&&tr1.getRightChildren().isEmpty())
				&&(tr2.getLeftChildren().isEmpty()&&tr2.getRightChildren().isEmpty()))
			flag = true;
		
		return flag;		
	}
	
	/**
	 * 深度修正参数
	 * @param depth
	 * @return
	 */	
	public static float getDepthModify(int depth){
		if(depth == 1)
			return 1;
		else if(depth == 2)
			return 0.8f;
		else if(depth == 3)
			return 0.6f;
		else if(depth == 4)
			return 0.4f;
		else if(depth == 5)
			return 0.2f;
		else return 0;
	}

}
