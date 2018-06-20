## 百度网盘API JAVA版

### baidupanapi_java 

-------------------

### 代码来源 
https://github.com/xm0625/BaiduPanApi-Java/

(因作者不再维护，copy代码新启项目。如有侵权，联系删除)


### 项目简介
项目基于latyas(懒)(latyas@gmail.com)的baidupcsapi项目(python).去除项目名称中的PCS改为baidupan,完成原作者改名的愿望

### 原项目
https://github.com/ly0/baidupcsapi/

### 文档
http://baidupcsapi.readthedocs.org/

### 开发环境
IDEA maven

## 正文

--------

### 运行demo
导入工程        
打开项目的 src/main/test/com/baidupanapi/BaiduPanServiceTest.java

### 一些简单的例子

```$xslt
        BaiduPanService baiduPanService = new BaiduPanService("username", "password", null);
        CloseableHttpResponse chresQuota = baiduPanService.quota(null);
        CloseableHttpResponse chresListFiles = baiduPanService.listFiles("/",null,null,null,null,null);
        System.out.println("获得配额信息: \n" + getResponseEntity(chresQuota));
        System.out.println("获取根目录下的文件列表：\n" + getResponseEntity(chresListFiles));

```

### 下载

```$xslt
        FileOutputStream saveFile = new FileOutputStream(new File("C:/testPan/logo1.jpg")); // 保存路径
        baiduPanService.download("/myowns/testPan/logo1.jpg",keyValueMap).getEntity().writeTo(saveFile);
        
```
