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
 *三大集合遍历方式
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
    	LOGGER.info("实例化集合对象");
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
    	LOGGER.info("初始化MAP完毕");
    	
    	for (int i = 0; i < listOrSet.length; i++)
		{
		    arrayList.add(listOrSet[i]);
		    hashSet.add(listOrSet[i]);
		}
    	LOGGER.info("初始化LIST和SET完毕");

    }
    
    public void printMap()
    {
    	//用四种方式遍历MAP集合
    	Set<String> keyset = hashMap.keySet(); //此处用到了多态，父类接口动态绑定子类实例
    	for(String key : keyset)
    	{
    		System.out.println(hashMap.get(key));
    	}
    	LOGGER.info("增强FOR循环KEY");
    	Collection<String> valueset =  hashMap.values(); //此处用到了多态，父类接口动态绑定子类实例
    	for (String value : valueset)
		{
    		System.out.println(value);
		}
    	LOGGER.info("增强FOR循环VALUE");
    	
    	Iterator<Entry<String, String>> iterator = hashMap.entrySet().iterator();
    	while (iterator.hasNext())
		{
			Entry<String,String> entry = iterator.next();
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
    	
    }
    
    public void printSet()
    {
    	//遍历SET的方式比LIST少一种，有3种
    	Iterator<String> iterator = hashSet.iterator();
    	while (iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
    	LOGGER.info("迭代器遍历Set");
    }
	
    public void printList()
    {
    	//有专门的LISTITERATOR遍历LIST，所以遍历LIST的方式总共有4种
    	Iterator<String> iterator = arrayList.iterator();
    	while (iterator.hasNext())
		{
    		System.out.println(iterator.next());
		}
    	LOGGER.info("迭代器遍历List");
    	
    }
	
	

}
