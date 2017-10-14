package maven;

import java.io.InputStream;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

public class Compress {

	public static void main(String[] args) {
		
		System.out.println("开始测试XML文件解析功能");
		SAXReader reader = new SAXReader();
		Document document = null;
		try 
		{
			//绝对路径方式获取文件，如何使用相对路径获取文件？
			InputStream in = Compress.class.getResourceAsStream("../pom.xml");
			//document = reader.read(new File("web.xml"));
			document = reader.read(in);		
			//document = reader.read(new File("D:/workspaceMars/maven/src/main/resources/web.xml"));
		} 
		catch (DocumentException e) 
		{
			e.printStackTrace();
		}
        //获取根节点元素对象  
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
