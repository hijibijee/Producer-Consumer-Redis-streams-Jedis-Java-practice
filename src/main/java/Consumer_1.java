import redis.clients.jedis.Jedis;
import redis.clients.jedis.StreamEntry;
import redis.clients.jedis.StreamEntryID;

import java.util.*;

public class Consumer_1 {
    public static void main(String[] args) {
        Jedis redis = new Jedis();

        Map<byte[], byte[]> streams = new HashMap<>();
        streams.put("messages".getBytes(), "0".getBytes());

        int i = 0;

        StreamEntryID lastID = new StreamEntryID(System.currentTimeMillis(), 0);
        Map.Entry<String, StreamEntryID> query = null;
        while(i < 10){
            query = new AbstractMap.SimpleEntry("messages", lastID);
            List<Map.Entry<String, List<StreamEntry>>> resp = redis.xread(1, 0L, query);

            List<String> response = new ArrayList<>();
            if (resp.size() > 0) {
                lastID = resp.get(0).getValue().get(0).getID();
                for (StreamEntry se : resp.get(0).getValue()) {
                    response.add(se.getFields().get("curr_msg"));
                }

                System.out.println("Consumer - 1 says: " + response.get(0));
                i++;
            }
        }
    }
}
