package practice;

import org.testng.annotations.Test;

import com.Vtiger.GenericsUtils.BaseClassUtility;
import com.Vtiger.POM.ToolQAPage;

public class Tooltip extends BaseClassUtility {
	
	@Test
	public void tooltip() throws Throwable {
		String url = flib.getJsonKeyValue("url1");
		ToolQAPage tqa = new ToolQAPage(driver);
		tqa.mousehoverbutton();
		
	}

}

