package test.dao;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import main.dao.GetData;
import main.model.Comment;
import main.model.Repost;
import main.model.Status;

import org.dom4j.DocumentException;
import org.junit.Test;

public class TestGetData {

	@Test
	public void testgetComments() throws ClassNotFoundException, SQLException, DocumentException {
		GetData getdata = new GetData();
		List<Comment> comments = getdata.getComments("3604581294714902");
		assertNotNull(comments);
		
		
	}
	
	@Test
	public void testgetReposts() throws ClassNotFoundException, SQLException, DocumentException {
		GetData getdata = new GetData();
		List<Repost> comments = getdata.getReposts("3604581294714902");
		assertNotNull(comments);
		
		
	}
	
	@Test
	public void testgetStatus() throws ClassNotFoundException, SQLException, DocumentException {
		GetData getdata = new GetData();
		Status status = getdata.getStatus("3604581294714902");
		System.out.println(status.getCreated_at());
		assertNotNull(status);
	}

}
