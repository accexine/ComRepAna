package test.analysis;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Test;

import main.analysis.SupportAna;
public class TestSupportAna {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSupport() throws IOException {
		String text = "真 TMD 的 假";
		Double d = SupportAna.doAna(text);
		System.out.println(d);
	}

}
