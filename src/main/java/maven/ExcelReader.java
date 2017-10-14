/**
 * 
 */
package maven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ouyangcpu poi读取excel文件
 */
public class ExcelReader {
	
	private final static Logger logger = LoggerFactory.getLogger(ExcelReader.class);
	
	POIFSFileSystem poifsFileSystem ;
	HSSFWorkbook hssfWorkbook;
	HSSFSheet hssfSheet;

	public ExcelReader(String filepath)
	{
		try
		{
			poifsFileSystem = new POIFSFileSystem(new FileInputStream(filepath));
			hssfWorkbook = new HSSFWorkbook(poifsFileSystem);
			hssfSheet = hssfWorkbook.getSheetAt(0);
			logger.info("提示性日志");
			logger.debug("DEBUG级别日志");
			logger.error("错误级别日志");
			readExcelHeader();
			readContent();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void readExcelHeader()
	{
		System.out.println("读excel文件的标题");
		HSSFRow row = hssfSheet.getRow(0);
		int length = row.getPhysicalNumberOfCells();
		for(int i=0;i<length;i++)
		{
			HSSFCell cell = row.getCell(i);
			System.out.print(cell.getStringCellValue()+" ");
		}
		System.out.println();
	}
	
	@SuppressWarnings("deprecation")
	public void readContent()
	{
		System.out.println("读excel文件的内容");
		boolean blank = false;
		int colnum = hssfSheet.getLastRowNum();
		for(int i=1;i<colnum;i++)
		{
			HSSFRow row = hssfSheet.getRow(i);
			int rowwidth = row.getPhysicalNumberOfCells();
			for(int j=0;j<rowwidth;j++)
			{
				HSSFCell cell = row.getCell(j);
				if (cell!=null){
					blank = true;
					if(cell.getCellType() == 0)
					{
						System.out.print(cell.getNumericCellValue()+" ");
					}
					else if(cell.getCellType() == 1)
					{
						System.out.print(cell.getStringCellValue()+" ");
					}
					else if(cell.getCellType() == 2)
					{
						System.out.print(cell.getCellFormula()+" ");
					}
					else if(cell.getCellType() == 3)
					{
						System.out.print(" ");
					}
					else if(cell.getCellType() == 4)
					{
						System.out.print(cell.getBooleanCellValue()+" ");
					}
				}
			}
			if(blank)
			{
				System.out.println();
				blank = false;
			}
			
		}
	}

}
