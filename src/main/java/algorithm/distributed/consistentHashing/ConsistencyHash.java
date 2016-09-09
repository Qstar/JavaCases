package algorithm.distributed.consistentHashing;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * 一致性Hash算法实验
 * 算法说明：
 * 一致性哈希算法是分布式系统中常用的算法。比如，一个分布式的存储系统，要将数据存储到具体的节点上，
 * 如果采用普通的hash方法，将数据映射到具体的节点上，如key%N，key是数据的key，N是机器节点数，
 * 如果有一个机器加入或退出这个集群，则所有的数据映射都无效了，如果是持久化存储则要做数据迁移，
 * 如果是分布式缓存，则其他缓存就失效了。
 * 一致性Hash算法将 value 映射到一个 32 为的 key 值，也即是 0~2^32-1 次方的数值空间；
 * 我们可以将这个空间想象成一个首( 0 )尾( 2^32-1 )相接的圆环。 我们可以将这个空间想象成一个首( 0 )尾( 2^32-1 )相接的圆环。
 * 因为在Java中没有什么map可以满足环状结构，这里找一个排序的，0开头，2^32-1做尾。
 */
public class ConsistencyHash {
    private TreeMap<Long, Object> nodes = null;
    //真实服务器节点信息
    private List<Object> shards = new ArrayList<>();
    //设置虚拟节点数目
    private int VIRTUAL_NUM = 4;

    public static void main(String[] args){
        Random ran = new Random();
        ConsistencyHash hash = new ConsistencyHash();
        hash.init();
        hash.printMap();
        //循环50次，是为了取50个数来测试效果，当然也可以用其他任何的数据来测试
        for (int i = 0; i < 50; i++) {
            System.out.println(hash.getShardInfo(hash.hash(hash.computeMd5("key_" + String.valueOf(i)),
                    ran.nextInt(hash.VIRTUAL_NUM))));
        }
    }

    /**
     * 初始化一致环
     * 在对server节点初始化的时候，为了避免节点过少数据分布不均匀，都会初始化一些虚拟节点。
     * 具体方法与计算hash值的方式类同，一般采用根据权重虚拟出来一些key值
     */
    public void init(){
        shards.add("192.168.0.0-服务器0");
        shards.add("192.168.0.1-服务器1");
        shards.add("192.168.0.2-服务器2");
        shards.add("192.168.0.3-服务器3");
        shards.add("192.168.0.4-服务器4");

        nodes = new TreeMap<Long, Object>();
        for (int i = 0; i < shards.size(); i++) {
            Object shardInfo = shards.get(i);
            for (int j = 0; j < VIRTUAL_NUM; j++) {
                nodes.put(hash(computeMd5("SHARD-" + i + "-NODE-" + j), j), shardInfo);
            }
        }
    }

    /**
     * 根据key的hash值取得服务器节点信息
     *
     * @param hash
     * @return
     */
    public Object getShardInfo(long hash){
        Long key = hash;
        SortedMap<Long, Object> tailMap = nodes.tailMap(key);
        if (tailMap.isEmpty()) {
            key = nodes.firstKey();
        } else {
            key = tailMap.firstKey();
        }
        return nodes.get(key);
    }

    /**
     * 打印圆环节点数据
     */
    public void printMap(){
        System.out.println(nodes);
    }

    /**
     * 根据2^32把节点分布到圆环上面。
     *
     * @param digest
     * @param nTime
     * @return
     */
    public long hash(byte[] digest, int nTime){
        long rv = ((long) (digest[3 + nTime * 4] & 0xFF) << 24)
                | ((long) (digest[2 + nTime * 4] & 0xFF) << 16)
                | ((long) (digest[1 + nTime * 4] & 0xFF) << 8)
                | (digest[nTime * 4] & 0xFF);

        return rv & 0xffffffffL; /* Truncate to 32-bits */
    }

    /**
     * Get the md5 of the given key.
     * 计算MD5值
     */
    public byte[] computeMd5(String k){
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 not supported", e);
        }
        md5.reset();
        byte[] keyBytes = null;
        try {
            keyBytes = k.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unknown string :" + k, e);
        }

        md5.update(keyBytes);
        return md5.digest();
    }

}