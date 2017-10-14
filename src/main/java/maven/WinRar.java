package maven;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class WinRar {
	
	private File source;
	private File zip;
	
	WinRar(String source,String zip)
	{
		this.source =  new File(source);
		this.zip = new File(zip);
	}
	
	public void zip()
	{
		System.out.println("Դ�ļ��� "+source+" Ŀ���ļ���"+zip);
		
		BufferedOutputStream bos = null;
		ZipOutputStream out = null;
		
		try 
		{
			out = new ZipOutputStream(new FileOutputStream(zip));
			bos = new BufferedOutputStream (out);
			compress(out,bos,source,source.getName());
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				bos.close();
				out.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		}
	}
	

	public void compress(ZipOutputStream out, BufferedOutputStream bos, File source, String name)
	{
		//�ж��Ƿ����ļ���
		if(source.isDirectory())
		{
			File[] list = source.listFiles();
			//�ǿ��ļ��У��ݹ���÷�����ѭ��ѹ��
			if(list.length>0)
			{
				for(File file : list)
				{
					compress(out,bos,file,name+"/"+file.getName());
				}
			}
			//���ļ���
			else
			{
                //System.out.println(name+"/");
                try {
					out.putNextEntry(  new ZipEntry(name+"/") );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//�ļ�
		else
		{
			try {
				out.putNextEntry(new ZipEntry(name));
				FileInputStream fis = new FileInputStream(source);
				BufferedInputStream bis = new BufferedInputStream(fis);
				int flag;
				if((flag=bis.read())!=-1)
				{
					out.write(flag);
				}
				bis.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	//��ӡ��Դ�ļ���·���µ��ļ���ʹ�õݹ�
	public void printlnSource()
	{
		if(source.isDirectory())
		{
			File[] list = source.listFiles();
			if(list.length>0)
			{
				for(File file : list)
				{
					System.out.println("��һ�����"+file.getName());
					listFile(file);
				}
			}
			else
			{
				System.out.println("��һ��������Ǹ����ļ���");
			}
			
		}
		else
		{
			System.out.println("��һ��������Ǹ��ļ�"+source.getName());
		}
	}

	public void listFile(File file)
	{
		if(file.isDirectory())
		{
			File[] list = file.listFiles();
			if(list.length>0)
			{
				for(File file2 : list)
				{
					System.out.println("�ڶ��εݹ����"+file2.getName());
					listFile(file2);
				}
			}
			else
			{
				System.out.println("�ڶ��εݹ�������Ǹ����ļ���");
			}
			
		}
		else
		{
			System.out.println("�ڶ��εݹ�������Ǹ��ļ�"+file.getName());
		}
		
	}
	public static void main(String[] args) {
		

	}

}
