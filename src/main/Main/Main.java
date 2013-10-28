package main.Main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import main.analysis.PosNegAna;
import main.dao.ConnectionMySQL;
import main.dao.GetData;
import main.dao.MySQLDao;
import main.model.Comment;
import main.model.Repost;
import main.model.Status;

public class Main {
	public static void main(String[] args){
		try {
			List<Status> statuses = GetData.getAllStatus();
			for(Status s : statuses){
				List<Comment> comments = GetData.getComments(s.getMid());
				PosNegAna analysis = new PosNegAna();
				Map<String,Double> result = analysis.doAnalysis(comments);
				Iterator iterator = result.keySet().iterator();
				while(iterator.hasNext()){
					String id = (String) iterator.next();
					double score = result.get(id);
					MySQLDao.updateScore(new String("comments"), id, score);
				}
				List<Repost> reposts = GetData.getReposts(s.getMid());
				result = analysis.doAnalysis(reposts);
				iterator = result.keySet().iterator();
				while(iterator.hasNext()){
					String id = (String) iterator.next();
					double score = result.get(id);
					MySQLDao.updateScore(new String("reposts"), id, score);
				}
				System.out.println(s.getMid()+"success!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
