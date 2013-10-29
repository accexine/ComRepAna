package main.Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import main.dao.GetData;
import main.model.Comment;
import main.model.Repost;
import main.model.Status;

public class GetScoreIntoFiles {
	/**
	 * 将数据库中评论和转发表中所有的得分存为csv文件。
	 * some results/
	 * @param args
	 */
	public static void main(String[] args){
		try {
			List<Status> statuses = GetData.getAllStatus();
			System.out.println(statuses.size());
			for(Status s : statuses){
				List<Comment> comments = GetData.getComments(s.getMid());
				List<Repost> reposts = GetData.getReposts(s.getMid());
				File file = new File("some results/comments_score_results.txt");
				FileWriter fw = new FileWriter(file,true);
				for(Comment c : comments){
					String line = c.getId()+","+c.getMid()+","+c.getCreated_at()+","+c.getScore();
					fw.write(line+"\r\n");
				}
				System.out.println("comments write files success!");
				fw.close();
				file = new File("some results/reposts_score_results.txt");
				fw = new FileWriter(file,true);
				for(Repost r : reposts){
					String line = r.getId()+","+r.getMid()+","+r.getCreated_at()+","+r.getScore();
					fw.write(line+"\r\n");
				}
				System.out.println("reposts write files success!");
				fw.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
