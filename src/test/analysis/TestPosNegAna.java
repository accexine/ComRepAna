package test.analysis;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import main.analysis.PosNegAna;
import main.dao.GetData;
import main.model.Comment;
import main.model.Repost;
import main.model.Status;

import org.dom4j.DocumentException;
import org.junit.Test;

public class TestPosNegAna {
	
	@Test
	public void testPosNegAna() throws ClassNotFoundException, SQLException, DocumentException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException{
		List<Status> allStatus = GetData.getAllStatus();
		for(Status s : allStatus){
			List<Comment> comments = GetData.getComments(s.getMid());
			PosNegAna<Comment> commentana = new PosNegAna<Comment>();
			commentana.doAnalysis(comments);
		}
		for(Status s : allStatus){
			List<Repost> reposts = GetData.getReposts(s.getMid());
			PosNegAna<Repost> repostana = new PosNegAna<Repost>();
			repostana.doAnalysis(reposts);
		}
	}
}
