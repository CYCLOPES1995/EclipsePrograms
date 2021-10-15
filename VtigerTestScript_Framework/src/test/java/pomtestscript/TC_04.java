package pomtestscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.GenericsUtils.BaseClassUtility;
import com.Vtiger.POM.CreateNewLead;
import com.Vtiger.POM.HomePage;
import com.Vtiger.POM.LeadInfoPage;
import com.Vtiger.POM.LeadsPage;

public class TC_04 extends BaseClassUtility{
	@Test(groups = "")
	public void createlead() throws Throwable {
		
		String firstname = elib.getExcelData("sheet1", 4, 1);
		String lastname = elib.getExcelData("sheet1", 4, 2);
		String company = elib.getExcelData("sheet1", 4, 3);
		String title = elib.getExcelData("sheet1", 4, 4);
		String annualrevnue = elib.getExcelData("sheet1", 4, 5);
		String nmbrofemployees = elib.getExcelData("sheet1", 4, 6);
		String secondryemail = elib.getExcelData("sheet1", 4, 7);
		String phone = elib.getExcelData("sheet1", 4, 8);
		String mobile = elib.getExcelData("sheet1", 4, 9);
		String fax = elib.getExcelData("sheet1", 4, 10);
		String email = elib.getExcelData("sheet1", 4, 11);
		String website = elib.getExcelData("sheet1", 4, 12);
		String street = elib.getExcelData("sheet1", 4, 13);
		String pobox = elib.getExcelData("sheet1", 4, 14);
		String postalcode = elib.getExcelData("sheet1", 4, 15);
		String city = elib.getExcelData("sheet1", 4, 16);
		String country = elib.getExcelData("sheet1", 4, 17);
		String state = elib.getExcelData("sheet1", 4, 18);
		String description = elib.getExcelData("sheet1", 4, 19);
		
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();
		LeadsPage l = new LeadsPage(driver);
		l.getCreatenewleadlink().click();
		CreateNewLead cnl = new CreateNewLead(driver);
		cnl.readData(firstname, lastname, company, title, annualrevnue);
		cnl.readData1(nmbrofemployees, secondryemail, phone, mobile, fax);
		cnl.readData2(email, website, street, pobox, postalcode);
		cnl.readData3(city, country, state, description);
		LeadInfoPage lip = new LeadInfoPage(driver);
		String msgtext = lip.getleadinfo().getText();
		Assert.assertTrue(msgtext.contains(lastname),"lead not created");

	}

}
