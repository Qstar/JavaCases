package Redis;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisListJava {
    public static void main(String[] args) {
        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //store data in redis list
        jedis.lpush("tutorial-list", "Redis");
        jedis.lpush("tutorial-list", "Mongodb");
        jedis.lpush("tutorial-list", "Mysql");
        // Get the stored data and print it
        List<String> list = jedis.lrange("tutorial-list", 0, 5);
        for (String aList : list) {
            System.out.println("Stored string in redis:: " + aList);
        }
    }
}
