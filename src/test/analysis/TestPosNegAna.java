package test.analysis;

import java.sql.SQLException;
import java.util.List;

import main.analysis.PosNegAna;
import main.dao.GetData;
import main.model.Comment;
import main.model.Status;

import org.dom4j.DocumentException;
import org.junit.Test;

public class TestPosNegAna {
	
	@Test
	public void testPosNegAna() throws ClassNotFoundException, SQLException, DocumentException{
		GetData getdata = new GetData();
		List<Status> allStatus = getdata.getAllStatus();
		for(Status s : allStatus){
			List<Comment> comments = getdata.getComments(s.getMid());
			PosNegAna<Comment> posnegana = new PosNegAna<Comment>(comments);
			posnegana.doAnalysis();
		}
	}
}
