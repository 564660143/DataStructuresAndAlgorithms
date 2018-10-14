package sort.insert;

import org.junit.Test ;
import utils.ArrayUtil ;

public class InsertTest {
	
	@Test
	public void testBasic(){
		int[] arr = ArrayUtil.generateArray(100, 0, 100);
		new InsertSort().sort(arr);
		ArrayUtil.printArray(arr);
	}
	
	
	
}
