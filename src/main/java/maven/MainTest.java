package maven;

public class MainTest {

	public static void main(String[] args) {
		// ���ֲ��Գ������
		// �����ļ��е�ѹ���ͽ�ѹ����
		//WinRar winRar = new WinRar("D:/eclipse/configuration", "D:/eclipse/javatest");
		//winRar.zip();	//��Ϊѹ����ѹ��Ȩ�����⣬��ǳ
		//winRar.printlnSource();
		
		PoiExcel excel = new PoiExcel("hello.xls","D:/eclipse/javatest");
		excel.writeText();
		
		//JavaMail2 javaMail = new JavaMail2();
		//javaMail.sendJavaMail();
		
		//POI��ȡEXCEL�ļ�����
		//ExcelReader excelReader = new ExcelReader("D:/eclipse/javatest/Ԥ����4.xls");
		
		CollectionTest cTest = new CollectionTest();
		cTest.printMap();
		cTest.printList();
		cTest.printSet();
		
		

	}

}
