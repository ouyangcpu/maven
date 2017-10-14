package maven;

import java.io.InputStream;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

public class Compress {

	public static void main(String[] args) {
		
		System.out.println("��ʼ����XML�ļ���������");
		SAXReader reader = new SAXReader();
		Document document = null;
		try 
		{
			//����·����ʽ��ȡ�ļ������ʹ�����·����ȡ�ļ���
			InputStream in = Compress.class.getResourceAsStream("../pom.xml");
			//document = reader.read(new File("web.xml"));
			document = reader.read(in);		
			//document = reader.read(new File("D:/workspaceMars/maven/src/main/resources/web.xml"));
		} 
		catch (DocumentException e) 
		{
			e.printStackTrace();
		}
        //��ȡ���ڵ�Ԫ�ض���  
        Element root = document.getRootElement();
		System.out.println(root);
		@SuppressWarnings("unchecked")
		List<Attribute> nodes = root.attributes();
		for(Attribute attribute : nodes)
		{
			System.out.println(attribute.getName()+" "+attribute.getStringValue());
		}

	}

}
