package job1;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;

public class TestMain {
	
	@Test
	public void RangeToList4Test(){
		List<String> IPs = Main.getListFromRange("192.168.0.1", "192.168.0.3");
		assertEquals(IPs.size(), 3);
		assertEquals(IPs.contains("192.168.0.1"), true);
		assertEquals(IPs.contains("192.168.0.2"), true);
		assertEquals(IPs.contains("192.168.0.3"), true);
	}
	
	@Test
	public void RangeToList3Test(){
		List<String> IPs = Main.getListFromRange("192.168.0.1", "192.168.1.3");
		assertEquals(IPs.size(), 258);
		assertEquals(IPs.contains("192.168.0.255"), true);
		assertEquals(IPs.contains("192.168.0.2"), true);
		assertEquals(IPs.contains("192.168.1.2"), true);
		assertEquals(IPs.contains("192.168.1.3"), true);
	}

}
