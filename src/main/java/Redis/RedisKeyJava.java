package Redis;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class RedisKeyJava {
    public static void main(String[] args) {
        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server successfully");
        //store data in redis list
        // Get the stored data and print it
        List<String> list = new ArrayList(jedis.keys("*"));
        for (String key : list) {
            System.out.println("List of stored keys:: " + key);
        }
    }
}