package maven;

public class MainTest {

	public static void main(String[] args) {
		// 各种测试程序入口
		// 测试文件夹的压缩和解压功能
		//WinRar winRar = new WinRar("D:/eclipse/configuration", "D:/eclipse/javatest");
		//winRar.zip();	//因为压缩解压缩权限问题，搁浅
		//winRar.printlnSource();
		
		PoiExcel excel = new PoiExcel("hello.xls","D:/eclipse/javatest");
		excel.writeText();
		
		//JavaMail2 javaMail = new JavaMail2();
		//javaMail.sendJavaMail();
		
		//POI读取EXCEL文件内容
		//ExcelReader excelReader = new ExcelReader("D:/eclipse/javatest/预售米4.xls");
		
		CollectionTest cTest = new CollectionTest();
		cTest.printMap();
		cTest.printList();
		cTest.printSet();
		
		

	}

}
