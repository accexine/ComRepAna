package test.analysis;

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
	public void testPosNegAna() throws ClassNotFoundException, SQLException, DocumentException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		GetData getdata = new GetData();
		List<Status> allStatus = getdata.getAllStatus();
		for(Status s : allStatus){
			List<Comment> comments = getdata.getComments(s.getMid());
			PosNegAna<Comment> commentana = new PosNegAna<Comment>();
			commentana.doAnalysis(comments);
		}
		for(Status s : allStatus){
			List<Repost> reposts = getdata.getReposts(s.getMid());
			PosNegAna<Repost> repostana = new PosNegAna<Repost>();
			repostana.doAnalysis(reposts);
		}
	}
}
