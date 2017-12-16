package maven;

import redis.clients.jedis.Jedis;

public class RedisTest {

	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("127.0.0.1",6379);
		jedis.set("name", "ouyang");
		System.out.println("redis ´æ´¢µÄ×Ö·û´®Îª: "+ jedis.get("name"));

	}

}
