package controller;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Dhao
 * @date 2018/11/1 15:26
 */
@Controller
public class TestController {


        @RequestMapping(value = "/togo", method = RequestMethod.GET)
        public String toGo() {
            return "index";
        }

        /**
         *
         * @param shengji   前台传来的省份信息
         * @throws Exception
         */
        @ResponseBody
        @RequestMapping(value = "/index", method = RequestMethod.POST)
        public List<String> index(String shengji, Model model) throws Exception {

        /*
            1   创建http 请求客户端
        */
            CloseableHttpClient htp = HttpClients.createDefault();
        /*
            2   绑定http请求Post 请求路径
         */
            HttpPost post = new HttpPost("http://xzqh.mca.gov.cn/selectJson");

        /*
            3   创建键值对参数集合
         */
            List<NameValuePair> list = new ArrayList<NameValuePair>();
        /*
            4   放入传输的参数信息
         */
            list.add(new BasicNameValuePair("shengji", shengji));
        /*
            5   向Post请求对象中放入请求参数
         */
            post.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
        /*
            6   发送请求,返回响应对象
         */
            CloseableHttpResponse response = htp.execute(post);
        /*
            7   获取相应的实体对象
         */
            HttpEntity entity = response.getEntity();
        /*
            8   将响应内容读取到输入流中
         */
            InputStream content = entity.getContent();
        /*
            9   放入缓冲区中
         */
            BufferedReader reader = new BufferedReader(new InputStreamReader(content));
            String text = "";
            String con = "";
            while ((text = reader.readLine()) != null) {
                con += text;
            }
            System.out.println(con);

        /*
            解析返回的数据
         */
            List<HashMap> list2 = JSONObject.parseArray(con, HashMap.class);

        /*
            创建List集合接收地址
         */
            List<String> citys = new ArrayList<>();

        /*
            遍历地址到新集合中
         */
            for(HashMap<String,String> hashMap:list2){
                //  System.out.println(hashMap);
                citys.add(hashMap.get("diji"));
            }

            System.out.println(citys);

            return citys;

        }



}
