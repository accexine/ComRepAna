package main.analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SupportAna {
	public static HashMap<String, Float> degreehastab = new HashMap<String, Float>();
	public static HashMap<String, Float> sephastab = new HashMap<String, Float>();
	public static HashMap<String, Float> neghastab = new HashMap<String, Float>();
	public static HashMap<String, Float> poshastab = new HashMap<String, Float>();
	public static float weight;
	public static int poscnt;
	public static int negcnt;
	public static ArrayList<Float> senweight = new ArrayList<Float>();
	public static float totalweight;
	public static int par;	
	public static float score=0;
	public static double doAna(String text) throws IOException{
		if(degreehastab.isEmpty()) dictinit();
		return SuppAnalysis(text);
	}
	public static double SuppAnalysis(String text) throws UnsupportedEncodingException{
		weight=1;
		poscnt=0;
		negcnt=0;
		senweight.clear();
		totalweight=0;
		par=0;
		String[] commentary = text.split(" ");
		for(String term : commentary){
			if(term.equals("?")||term.equals("？")) {
				score=-1;
				return score;
			}

			if(degreehastab.containsKey(term))  {
				weight=weight*degreehastab.get(term);
			}
			else if(poshastab.containsKey(term)) {poscnt+=1;}
			else if(neghastab.containsKey(term)) {negcnt+=1;}
			else if(sephastab.containsKey(term)){
				if(poscnt>0){
					senweight.add(poscnt*weight);
					par++;
				}if(negcnt>0){
					senweight.add(-1*negcnt*weight);					
					par++;
				}
				weight=1;
				poscnt=0;
				negcnt=0;
			}
		
			if(poscnt>0){
				senweight.add(poscnt*weight);
				par++;
				weight=1;
				poscnt=0;
				negcnt=0;
			}
			if(negcnt>0){
				senweight.add(-1*negcnt*weight);
				par++;
				weight=1;
				poscnt=0;
				negcnt=0;
			}		
		}
		for(float w : senweight){
			totalweight=totalweight+w;
		}
		if(par>0) return (float)(totalweight/par);
		else return totalweight;
	}
	public static void dictinit() throws IOException{
		String dict = "dict/";
		String line=null;
		File file = new File(dict+"degree.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		while((line = reader.readLine())!=null){
			String[] lineAry = line.split("\t");
			float value=Float.parseFloat(lineAry[1]);
			degreehastab.put(lineAry[0], value);
		}
		reader.close();
		file=new File(dict+"sep.txt");
		reader=new BufferedReader(new FileReader(file));
		while((line=reader.readLine())!=null){
			sephastab.put(line.trim(), Float.valueOf(1));
		}
		reader.close();
		file=new File(dict+"negative.txt");
		reader=new BufferedReader(new FileReader(file));
		while((line=reader.readLine())!=null){
			neghastab.put(line.trim(), Float.valueOf(1));
		}
		reader.close();
		file=new File(dict+"positive.txt");
		reader=new BufferedReader(new FileReader(file));
		while((line=reader.readLine())!=null){
			poshastab.put(line.trim(), Float.valueOf(1));
		}
		reader.close();
	}
	
}
