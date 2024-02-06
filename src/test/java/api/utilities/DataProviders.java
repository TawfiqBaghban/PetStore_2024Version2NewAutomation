package api.utilities;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

//	Data Provider is a TestNG annotation, which is used to get the entire data from excel sheet, store it in 
//	two dimensional arrays and then pass it to test methods. the following method will provide the entire data from excel sheet.
	
	@DataProvider(name="Data")	//	@DataProvider is defined with (@) annotation sign, (Data)is the name of DataProvider.
	public String[][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//Userdata.xlsx";
		XLUtility xl=new XLUtility(path);	// creating object of XLUtility class and passing (path) as a constructor parameter.
	
		int rownum=xl.getRowCount("Sheet1");		//	getting total number of rows.
		int colcount=xl.getCellCount("Sheet1",1);	//	getting total number of columns.
		
		String apidata[][]=new String[rownum][colcount];	// creating two dimensional array with same size of rows and columns.
		
		for(int i=1;i<=rownum;i++)						//	Starting count from 1, because rows starts from 1
		{		
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]= xl.getCellData("Sheet1",i, j);  
			}
		}	
		return apidata;
	}
/*	using System.setProperty("location of excel sheet") we specify the path/ location of excel sheet and assign
 	it to a variable (path).
 -	we create object of XLUtility class and pass the (path) as a constructor parameter, then by using XLUtility class methods
 	we read each row and column and assign them in different variables. Since we want to store the entire data from excel sheet 
 	into two dimensional array, so the number rows and columns from excel sheet should be the same as number of rows and column
 	in the two dimensional array, so we create two dimensional array of String type and pass the variables (rownum & colcount)
 	if the size of excel sheet increases it will automatically increase size of the array.
 -	the for loop statement will traverse in each row and column and assign it into our two dimensional array (apidata) 
 	and then return the data.
 
 */
//	Using the following method, the DataProvider will only pass/ provide the data from rows.
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//Userdata.xlsx";
		XLUtility xl=new XLUtility(path);
	
		int rownum=xl.getRowCount("Sheet1");	//	getting total number of rows.	
			
		String apidata[]=new String[rownum];
		
		for(int i=1;i<=rownum;i++)
		{		
			apidata[i-1]= xl.getCellData("Sheet1",i, 1);  
			
		}	
		return apidata;
	}
/*	using System.setProperty("location of excel sheet") we specify the path/ location of excel sheet and assign
 	it to a variable (path).
 -	we create object of XLUtility class and pass the (path) as a constructor parameter, then by using XLUtility class method
 	getRowCount() method we read each row and assign it to a variable. 
 	Since we want to store the rows data from excel sheet, so we create one dimensional array, so the number rows 
 	from excel sheet should be the same as number of rows in the array.
 	in the one dimensional array, so we create one dimensional array of String type and pass the variables (rownum)
 	if the size of excel sheet increases it will automatically increase size of the array.
 -	the for loop statement will traverse in each row and assign it into our one dimensional array (apidata) 
 	and then return the data.
 
*/
}
