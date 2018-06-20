package com.baidupanapi;

import com.alibaba.fastjson.JSONObject;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * BaiduPanService 测试类
 * Created by ShayneLee on 2018/6/20
 */
public class BaiduPanServiceTest {

    public static void main(String[] args) throws Exception {

        BaiduPanService baiduPanService = new BaiduPanService("username", "password", null);
        CloseableHttpResponse chresQuota = baiduPanService.quota(null);
        CloseableHttpResponse chresListFiles = baiduPanService.listFiles("/",null,null,null,null,null);
        System.out.println("获得配额信息: \n" + getResponseEntity(chresQuota));
        System.out.println("获取根目录下的文件列表：\n" + getResponseEntity(chresListFiles));


        Map<String,Object> keyValueMap = new HashMap<>();
        Map<String,String> headers = new HashMap<>();
        headers.put("Range","bytes=0-99");
        keyValueMap.put("headers",headers);
        /*
         * 下载文件
         */
        FileOutputStream saveFile = new FileOutputStream(new File("C:/testPan/logo1.jpg")); // 保存路径
        baiduPanService.download("/myowns/testPan/logo1.jpg",keyValueMap).getEntity().writeTo(saveFile);
    }

    public static JSONObject getResponseEntity(CloseableHttpResponse httpResponse) {
        HttpEntity httpEntity = httpResponse.getEntity();
        StringBuilder entityStringBuilder = new StringBuilder();
        JSONObject resultJsonObject = null;
        BufferedReader bufferedReader = null;
        if (httpEntity != null) {
            try {
                bufferedReader = new BufferedReader
                        (new InputStreamReader(httpEntity.getContent(), "UTF-8"), 8 * 1024);
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    entityStringBuilder.append(line + "\n");
                }
                //利用从HttpEntity中得到的String生成JsonObject
                resultJsonObject = JSONObject.parseObject(entityStringBuilder.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return  resultJsonObject;
        }
        return null;
    }
}
