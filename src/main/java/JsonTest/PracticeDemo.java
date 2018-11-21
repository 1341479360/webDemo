package JsonTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Dhao
 * @date 2018/11/7 10:23
 */
public class PracticeDemo {

    public static void main(String[] args) {


            JSONObject jsonObject = new JSONObject();

            jsonObject.put("name", "dh");

            jsonObject.put("age", "18");

            jsonObject.put("sex", "man");


        /*
            创建Java对象
         */
        User user = new User();
        user.setId("1");
        user.setUsername("donghao");
        user.setPassword("username");
        user.setSex("2");
        System.out.println(user);

        /*
            1   Java对象-->Json字符串
         */
        String json = JSONObject.toJSONString(user);


        /*
            2   Json字符串-->Java对象
         */
        User userJson = (User)JSON.parseObject(json,User.class);

        System.out.println(json);
        System.out.println("user"+userJson);


    }
}
