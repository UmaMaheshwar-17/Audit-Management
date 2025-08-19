package utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class dataProviders {

	//DataProvider 1
	
	@DataProvider(name = "LoginData")
	public Object[][] getData() throws IOException {
	    String path = ".\\testData\\Book1.xlsx";

	    ExcelUtility xlutil = new ExcelUtility(path);

	    int totalrows = xlutil.getRowCount("Sheet1");
	    int totalcols = 2; // Hardcoded since your sheet has only 2 columns

	    List<Object[]> validData = new ArrayList<>();

	    for (int i = 1; i <= totalrows; i++) {
	        boolean isValidRow = true;
	        String[] rowData = new String[totalcols];

	        for (int j = 0; j < totalcols; j++) {
	            String cellData = xlutil.getCellData("Sheet1", i, j);
	            if (cellData == null || cellData.trim().isEmpty()) {
	                isValidRow = false;
	                break;
	            }
	            rowData[j] = cellData;
	        }

	        if (isValidRow) {
	            validData.add(rowData);
	        }
	    }

	    // Convert list to 2D array
	    Object[][] data = new Object[validData.size()][totalcols];
	    for (int i = 0; i < validData.size(); i++) {
	        data[i] = validData.get(i);
	    }

	    System.out.println("Valid rows found: " + data.length);
	    return data;
	}



	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
}