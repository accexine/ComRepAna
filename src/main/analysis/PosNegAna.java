package main.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.model.Comment;
import main.model.Repost;


public class PosNegAna<T> {
	
	public Map<T,Double> posnegresult = new HashMap<T,Double>();
	public List<T> allentry = new ArrayList<T>();
	
	public PosNegAna (List<T> list){
		this.allentry = list;
	}
	
	public void doAnalysis(){
		for(T t : this.allentry){
			if( t instanceof Comment){
				Comment m = (Comment)t;
				String text = m.getText();
				System.out.println(text);
			}
		}
	}
}
