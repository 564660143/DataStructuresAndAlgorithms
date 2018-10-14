package sort.selection;

import org.junit.Test ;
import utils.ArrayUtil ;

public class SelectionTest {
	
	@Test
	public void testBasic(){
		int[] arr = ArrayUtil.generateArray(100, 0, 100);
		new SelectionSort().sort(arr);
		ArrayUtil.printArray(arr);
	}
	
	
	
}
