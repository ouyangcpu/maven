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
 * @author ouyangcpu ʹ��poi����excel�ĵ������ж�д����
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
	 *            �ļ���
	 * @param filepath
	 *            �ļ�·��
	 */
	public PoiExcel(String name, String filepath)
	{
		despath = new File(filepath);
		if (despath.exists())
		{
			System.out.println("�ļ��д��ڣ��������ļ�");
			result = new File(filepath + "/" + name);
			if (result.exists())
			{
				System.out.println("�ļ��Ѿ����ڣ���ɾ���ļ������½��ļ�");
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
			System.out.println("�ļ��в����ڣ��������ļ���");
			despath.mkdir();
			result = new File(filepath + "/" + name);
			if (result.exists())
			{
				System.out.println("�ļ��Ѿ����ڣ����ļ�������ԭ�����ļ�");

			}
		}

	}

	/**
	 * д������ݵ�Excel�ļ���
	 */
	@SuppressWarnings("deprecation")
	public void writeText()
	{
		wb = new HSSFWorkbook();
		wbsheet = wb.createSheet("hellosheet");
		HSSFSheet wbsheet2 = wb.createSheet("�ڶ���");
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

		cell.setCellValue("����excel�ļ�");

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
