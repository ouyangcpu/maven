package maven;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ouyangcpu
 *���󼯺ϱ�����ʽ
 */
public class CollectionTest {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(CollectionTest.class);
	private HashMap<String, String> hashMap;
	private ArrayList<String> arrayList;
	private HashSet<String> hashSet ;
	
    public CollectionTest()
    {
    	hashMap = new HashMap<String, String>();
    	arrayList = new ArrayList<String>();
    	hashSet = new HashSet<String>();
    	LOGGER.info("ʵ�������϶���");
    	initalCollection();
    }	
    
    private void initalCollection()
    {
    	String[] key = new String[]{"apple1","apple2","apple3","apple4","apple5","apple6","apple7","apple8","apple9","apple10"};
    	String[] value = {"apple11","apple12","apple13","apple14","apple15","apple16","apple17","apple18","apple19","apple20"};
    	String[] listOrSet = new String[3];
    	listOrSet[0] = "hello";
    	listOrSet[1] = "apple";
    	listOrSet[2] = "haha";
    	
    	for (int i = 0; i < 10; i++)
		{
    		hashMap.put(key[i], value[i]);
		}
    	LOGGER.info("��ʼ��MAP���");
    	
    	for (int i = 0; i < listOrSet.length; i++)
		{
		    arrayList.add(listOrSet[i]);
		    hashSet.add(listOrSet[i]);
		}
    	LOGGER.info("��ʼ��LIST��SET���");

    }
    
    public void printMap()
    {
    	//�����ַ�ʽ����MAP����
    	Set<String> keyset = hashMap.keySet(); //�˴��õ��˶�̬������ӿڶ�̬������ʵ��
    	for(String key : keyset)
    	{
    		System.out.println(hashMap.get(key));
    	}
    	LOGGER.info("��ǿFORѭ��KEY");
    	Collection<String> valueset =  hashMap.values(); //�˴��õ��˶�̬������ӿڶ�̬������ʵ��
    	for (String value : valueset)
		{
    		System.out.println(value);
		}
    	LOGGER.info("��ǿFORѭ��VALUE");
    	
    	Iterator<Entry<String, String>> iterator = hashMap.entrySet().iterator();
    	while (iterator.hasNext())
		{
			Entry<String,String> entry = iterator.next();
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
    	
    }
    
    public void printSet()
    {
    	//����SET�ķ�ʽ��LIST��һ�֣���3��
    	Iterator<String> iterator = hashSet.iterator();
    	while (iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
    	LOGGER.info("����������Set");
    }
	
    public void printList()
    {
    	//��ר�ŵ�LISTITERATOR����LIST�����Ա���LIST�ķ�ʽ�ܹ���4��
    	Iterator<String> iterator = arrayList.iterator();
    	while (iterator.hasNext())
		{
    		System.out.println(iterator.next());
		}
    	LOGGER.info("����������List");
    	
    }
	
	

}
