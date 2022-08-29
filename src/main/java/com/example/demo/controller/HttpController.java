package com.example.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Params;
import com.example.demo.utils.ReaderConfigPropertiesUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class HttpController {


    /**
     * 同步用户信息接口；
     */
    @Value("${user_file_url:''}")
    private String userFileUrl;

    /**
     * 同步组织信息接口；
     */
    @Value("${organization_file_url:''}")
    private String organizationFileUrl;

    @RequestMapping(value = "/syncinfo/cmdb" , method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    public String syncinfopost( String pageNo, String pageSize) {
        System.out.println("------------------syncinfo/cmdb------------------------");
        System.out.println(pageNo+"----------"+pageSize);
        System.out.println("------------------syncinfo/cmdb------------------------");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("returncode",1);
        List<JSONObject> syncIpAndHostNameList=new ArrayList<JSONObject>();
        JSONObject syncIpAndHostName=new JSONObject();
        syncIpAndHostName.put("sysName",pageNo+"子系统名称222"+pageNo);
        syncIpAndHostName.put("mainName",pageNo+"主系统名称222"+pageNo);
        syncIpAndHostName.put("ipAddress","10.100.203.101");
        syncIpAndHostName.put("hostName","服务器03");
        syncIpAndHostNameList.add(syncIpAndHostName);
        jsonObject.put("returnMsg",syncIpAndHostNameList);
        jsonObject.put("totalNum",1);
        return JSONObject.toJSONString(jsonObject);
    }


    @RequestMapping(value = "/syncUserInfo" , method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    public String syncUserInfo(String pageNo, String pageSize) {
        System.out.println("------------------syncUserinfo------------------------");
        System.out.println(JSONObject.toJSONString(pageNo));
        System.out.println(JSONObject.toJSONString(pageSize));
        System.out.println("------------------syncUserinfo------------------------");
        String readerConfigPropertiesMethod = ReaderConfigPropertiesUtils.readerConfigPropertiesMethod(userFileUrl);
        System.out.println(readerConfigPropertiesMethod);
        return readerConfigPropertiesMethod;
    }

    @RequestMapping(value = "/syncOrganizationInfo" , method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    public String syncOrganizationInfo(String pageNo, String pageSize) {
        System.out.println("------------------syncOrganizationInfo------------------------");
        System.out.println(JSONObject.toJSONString(pageNo));
        System.out.println(JSONObject.toJSONString(pageSize));
        System.out.println("------------------syncOrganizationInfo------------------------");
        String readerConfigPropertiesMethod = ReaderConfigPropertiesUtils.readerConfigPropertiesMethod(organizationFileUrl);
        System.out.println(readerConfigPropertiesMethod);
        return readerConfigPropertiesMethod;
    }



    @PostMapping("/hello")
    public String hello(@RequestBody String param) {
        System.out.println(param);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        return JSONObject.toJSONString(jsonObject);
    }

    @PostMapping("/hello/recoveredUrl")
    public String hellorecoveredUrl(@RequestBody Object param) {
        System.out.println(param);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        return JSONObject.toJSONString(jsonObject);
    }

    @PostMapping("/http/alarm/data")
    public String httpAlarmData(@RequestBody Object param) {

        System.out.println("------------------token/verify------------------------");
        System.out.println(JSONObject.toJSONString(param));
        System.out.println("------------------token/verify------------------------");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",200);
        return JSONObject.toJSONString(jsonObject);
    }


    @PostMapping("/http/xingye/alarm/data")
    public String xingyeHttpAlarmData(@RequestBody String param) {

        System.out.println("------------------------------------------");
        System.out.println(param);
        System.out.println("------------------------------------------");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code","c_200");
        jsonObject.put("data",1);
        jsonObject.put("success",true);
        jsonObject.put("message","操作成功");

        return JSONObject.toJSONString(jsonObject);
    }



    @GetMapping("/operator")
    public String operator(HttpServletRequest request) {
        String cookie = request.getHeader("Cookie");
        System.out.println("Cookie :"+cookie);
        String str="{" +
                "\"operators\": [{" +
                "\"changePassword\": false," +
                "\"currentPassword\": null," +
                "\"singleDomain\": null," +
                "\"create_time\": \"2020-08-05T01:27:08.621+0000\"," +
                "\"authTypeStr\": null," +
                "\"id\": 1," +
                "\"name\": \"ceshi002\"," +
                "\"fullName\": null," +
                "\"password\": \"\"," +
                "\"desc\": \"超级用户管理员\"," +
                "\"mail\": null," +
                "\"phone\": null," +
                "\"lastLoginTime\": 1596778614383," +
                "\"failCount\": null," +
                "\"lastPasswordChangeTime\": null," +
                "\"domainName\": null," +
                "\"defaultAcl\": 0," +
                "\"defaultManagedGroup\": 0," +
                "\"defaultManagedDefinedView\": 0," +
                "\"shortcutModuleId\": 0," +
                "\"authType\": 0," +
                "\"individualInfo\": null," +
                "\"userId\": null," +
                "\"creatorId\": null," +
                "\"operatorGroup\": {" +
                "\"id\": 1," +
                "\"groupName\": \"系统管理组\"," +
                "\"groupDesc\": \"具有系统管理员权限的组织\"," +
                "\"regionId\": null," +
                "\"parentId\": 0," +
                "\"level\": 1," +
                "\"opriority\": 1," +
                "\"path\": \"/1/\"," +
                "\"children\": null," +
                "\"stretch\": false," +
                "\"roles\": [{" +
                "\"id\": 1," +
                "\"roleName\": \"用户权限管理角色\"," +
                "\"desc\": \"权限管理员，可进行用户、组织、角色、权限的配置\"," +
                "\"regionId\": null," +
                "\"permissions\": [{" +
                "\"id\": 13," +
                "\"permissionName\": null," +
                "\"resType\": null," +
                "\"regionId\": null," +
                "\"operations\": null" +
                "}]," +
                "\"canModify\": null," +
                "\"canDelete\": null" +
                "}]" +
                "}," +
                "\"canModify\": true," +
                "\"canDelete\": false," +
                "\"regionId\": 0," +
                "\"first_name\": null," +
                "\"last_name\": null," +
                "\"userType\": 0," +
                "\"serviceId\": null," +
                "\"status\": 1" +
                "}]," +
                "    \"rowCount\":\"1\"" +
                "}";
        return str;
    }



    @PostMapping("/token/verify")
    public void  tokenVerify(@RequestBody Params params, HttpServletResponse response) {
        System.out.println("------------------token/verify------------------------");
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        System.out.println("token："+JSONObject.toJSONString(params));
        response.setHeader("id", "1");
        response.addHeader("userName", "ceshi002");
        System.out.println("------------------token/verify------------------------");
        System.out.println();
        System.out.println();
        return ;
    }


    @PostMapping("/token/generate")
    public Params tokenVerify(@RequestBody Params param) {
        System.out.println("------------------token/generate------------------------");
        param.setToken("this is token");
        System.out.println(JSONObject.toJSONString(param));
        System.out.println("------------------token/generate------------------------");
        System.out.println();
        System.out.println();
        return param;
    }

    @GetMapping("/kernelrs/operatorGroupTree")
    public String kernelrsOperatorGroupTree(HttpServletRequest request){
        String groupName = request.getParameter("groupName");
        System.out.println("------------------kernelrs/operatorGroupTree------------------------");
        System.out.println(groupName);
        System.out.println("------------------kernelrs/operatorGroupTree------------------------");
        System.out.println();
        System.out.println();
        String str="{" +
                "\"operatorGroups\": [{" +
                "\"path\": \"/50002/50033/\"," +
                "\"stretch\": false," +
                "\"groupName\": \"信息科技部\"," +
                "\"level\": 2," +
                "\"children\": [{" +
                "\"path\": \"/50002/50033/50034/\"," +
                "\"stretch\": false," +
                "\"groupName\": \"雅安分行\"," +
                "\"level\": 3," +
                "\"opriority\": 1," +
                "\"roles\": [{" +
                "\"permissions\": []," +
                "\"roleName\": \"测试角色\"," +
                "\"id\": 150002," +
                "\"desc\": \"\"" +
                "}]," +
                "\"operationIds\": [\"1\", \"8\", \"9\", \"10\"]," +
                "\"id\": 50034," +
                "\"parentId\": 50033" +
                "}, {" +
                "\"path\": \"/50002/50033/50034/\"," +
                "\"stretch\": false," +
                "\"groupName\": \"asd分行\"," +
                "\"level\": 3," +
                "\"children\": [{" +
                "\"path\": \"/50002/50033/50034/\"," +
                "\"stretch\": false," +
                "\"groupName\": \"aaaa分行\"," +
                "\"level\": 3," +
                "\"opriority\": 1," +
                "\"roles\": [{" +
                "\"permissions\": []," +
                "\"roleName\": \"测试角色\"," +
                "\"id\": 150002," +
                "\"desc\": \"\"" +
                "}]," +
                "\"children\": [{" +
                "\"path\": \"/50002/50033/50034/\"," +
                "\"stretch\": false," +
                "\"groupName\": \"bbbb分行\"," +
                "\"level\": 3," +
                "\"opriority\": 1," +
                "\"roles\": [{" +
                "\"permissions\": []," +
                "\"roleName\": \"测试角色\"," +
                "\"id\": 150002," +
                "\"desc\": \"\"" +
                "}]," +
                "\"operationIds\": [\"1\", \"8\", \"9\", \"10\"]," +
                "\"id\": 533333," +
                "\"parentId\": 50033" +
                "}]," +
                "\"operationIds\": [\"1\", \"8\", \"9\", \"10\"]," +
                "\"id\": 52222," +
                "\"parentId\": 50033" +
                "}]," +
                "\"opriority\": 1," +
                "\"roles\": [{" +
                "\"permissions\": []," +
                "\"roleName\": \"测试角色\"," +
                "\"id\": 150002," +
                "\"desc\": \"\"" +
                "}]," +
                "\"operationIds\": [\"1\", \"8\", \"9\", \"10\"]," +
                "\"id\": 51111," +
                "\"parentId\": 50033" +
                "}]," +
                "\"opriority\": 3," +
                "\"roles\": [{" +
                "\"permissions\": []," +
                "\"roleName\": \"测试角色\"," +
                "\"id\": 150002," +
                "\"desc\": \"\"" +
                "}]," +
                "\"operationIds\": [\"1\", \"8\", \"9\", \"10\"]," +
                "\"id\": 50031," +
                "\"parentId\": 50002" +
                "}, {" +
                "\"path\": \"/50002/50033/\"," +
                "\"stretch\": false," +
                "\"groupName\": \"信息科技部\"," +
                "\"level\": 2," +
                "\"opriority\": 3," +
                "\"roles\": [{" +
                "\"permissions\": []," +
                "\"roleName\": \"测试角色\"," +
                "\"id\": 150002," +
                "\"desc\": \"\"" +
                "}]," +
                "\"operationIds\": [\"1\", \"8\", \"9\", \"10\"]," +
                "\"id\": 50033," +
                "\"parentId\": 50002" +
                "}]," +
                "\"rowCount\": 2" +
                "}";
        return str;
    }
}
