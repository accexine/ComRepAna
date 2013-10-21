package main.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.model.Comment;
import main.model.Repost;


public class PosNegAna<T> {
	
	/**
	 * 返回评论或转发的分析结果
	 * @param list
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public Map<T,Double> doAnalysis(List<T> list) throws NoSuchMethodException, SecurityException{
		Map<T,Double> result = new HashMap<T,Double>();
		for(T t : list){
			System.out.println(t.getClass().getMethod("getText"));
//			System.out.println
		}
		return result;
	}
	
	
}
