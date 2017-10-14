package maven;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * @author ouyangcpu 使用poi操作excel文档，进行读写操作
 */
public class PoiExcel {

	HSSFWorkbook wb = null;
	HSSFSheet wbsheet = null;
	HSSFRow row = null;
	HSSFCell cell = null;
	HSSFCellStyle cellStyle = null;
	File despath = null;
	FileOutputStream fos = null;
	File result = null;

	/**
	 * @param name
	 *            文件名
	 * @param filepath
	 *            文件路径
	 */
	public PoiExcel(String name, String filepath)
	{
		despath = new File(filepath);
		if (despath.exists())
		{
			System.out.println("文件夹存在，将创建文件");
			result = new File(filepath + "/" + name);
			if (result.exists())
			{
				System.out.println("文件已经存在，将删除文件，再新建文件");
				result.delete();
				try
				{
					result.createNewFile();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else
			{
				try
				{
					result.createNewFile();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} else
		{
			System.out.println("文件夹不存在，将创建文件夹");
			despath.mkdir();
			result = new File(filepath + "/" + name);
			if (result.exists())
			{
				System.out.println("文件已经存在，新文件将覆盖原来的文件");

			}
		}

	}

	/**
	 * 写随机内容到Excel文件中
	 */
	@SuppressWarnings("deprecation")
	public void writeText()
	{
		wb = new HSSFWorkbook();
		wbsheet = wb.createSheet("hellosheet");
		HSSFSheet wbsheet2 = wb.createSheet("第二个");
		cellStyle = wb.createCellStyle();
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setFillForegroundColor(HSSFColor.GOLD.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		row = wbsheet.createRow(0);
		cell = row.createCell(0);
		for (int i = 1; i < 10; i++)
		{
			HSSFRow rowi = wbsheet.createRow(i);
			for (int j = 0; j < 10; j++)
			{
				HSSFCell cellj = rowi.createCell(j);
				cellj.setCellStyle(cellStyle);
				cellj.setCellValue("cellvale" + j);
			}
		}

		cell.setCellValue("测试excel文件");

		try
		{
			fos = new FileOutputStream(result);

		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try
		{
			wb.write(fos);
			fos.flush();
			fos.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
