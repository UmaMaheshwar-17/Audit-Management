package AuditFeedback;

import org.testng.annotations.Factory;
import utilities.ExcelUtility;

public class testFactory {

    @Factory
    public Object[] runAllRowsFromExcel() {
        
        String excelPath = System.getProperty("user.dir") + "/testdata/FeedBack1.xlsx";  
        String sheet = "Sheet1";
        
        ExcelUtility.setExcelPath(excelPath);  

        int rowCount = ExcelUtility.getRowCount(sheet)+1;
        Object[] tests = new Object[rowCount - 1]; 

        for (int i = 1; i < rowCount; i++) {
            String email = ExcelUtility.getCellData(sheet, i, 0);
            String password = ExcelUtility.getCellData(sheet, i, 1);
            String auditName = ExcelUtility.getCellData(sheet, i, 2);
            tests[i - 1] = new fullAuditFeedback(email, password, auditName);
        }

        return tests;
    }
}
