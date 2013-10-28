package main.analysis;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.huaban.analysis.jieba.JiebaSegmenter.SegMode;


public class PosNegAna<T> {
	public JiebaSegmenter segmenter;
	
	public PosNegAna(){
		if(segmenter == null) segmenter = new JiebaSegmenter();
	}
	
	/**
	 * 返回评论或转发的分析结果
	 * @param list
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public Map<String,Double> doAnalysis(List<T> list) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Map<String,Double> result = new HashMap<String,Double>();
		for(T t : list){
			String text = (String) t.getClass().getMethod("getText").invoke(t, null);
			System.out.println(text);
			text = parse(filter(text));
			System.out.println(text);
		}
		return result;
	}
	
	/**
	 * 分词
	 * @param text
	 */
	public String parse(String text){
		if(text.length()==0){
			return text;
		}
		List<SegToken> tokens = segmenter.process(text, SegMode.INDEX);
		String result = "";
		for(SegToken s : tokens){
			result+=s.token+" ";
		}
		result = result.substring(0,result.length()-1);
		return result;
	}
	
	public String filter(String text){
		if(text.contains("//")){
			int end = text.indexOf("//");
			text = text.substring(0,end);
		}
		if(text.contains("回复")){
			int start = text.indexOf(":")+1;
			text = text.substring(start,text.length());
		}
		return text;
	}
}
