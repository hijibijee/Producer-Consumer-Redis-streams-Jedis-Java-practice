import redis.clients.jedis.Jedis;
import redis.clients.jedis.StreamEntryID;

import java.util.HashMap;
import java.util.Map;

public class Producer {
    public static void main(String[] args) {
        Jedis redis = new Jedis();
        int msg_no = 1;

        while (msg_no < 100000) {
            String curr_msg = "Hello " + Integer.toString(msg_no);
            Map<String, String> hash = new HashMap<>();
            hash.put("curr_msg", curr_msg);

            System.out.println(redis.xadd("messages", StreamEntryID.NEW_ENTRY, hash));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            msg_no++;
        }
    }
}