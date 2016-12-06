package com.dashboard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dashboard.domain.*;
import com.dashboard.services.AdminServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    AdminServices adminServices;

    @RequestMapping(method = RequestMethod.POST, value="/admin/usermanage", consumes = "application/json")
    public ResponseMessage usermanage() {
        log.info("UserManage API is called");
        ResponseMessage response = new ResponseMessage();

        List<User> userList = new ArrayList<>();
        userList =  adminServices.usermanage();

        Map<String, Object> datas = new HashMap<>();
        datas.put("data", userList);
        response.setData(datas);
        response.setErrorCode(0);
        response.setResponseMsg(null);

        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value="/admin/billing", consumes = "application/json")
    public ResponseMessage billing(@RequestBody HashMap<String, String> data) {
        log.info("Billing API is called");
        ResponseMessage response = new ResponseMessage();

        List<Billing> billingList = new ArrayList<>();
        billingList = adminServices.billing();
        List<Processor> processorList = adminServices.getProcessor();
        List<Memory> memoryList = adminServices.getMemory();
        List<Storage> storageList = adminServices.getStorage();

        Map<String, Object> datas = new HashMap<>();
        datas.put("data", billingList);
        datas.put("processorList", processorList);
        datas.put("memoryList", memoryList);
        datas.put("storageList", storageList);
        response.setData(datas);
        response.setErrorCode(0);
        response.setResponseMsg(null);

        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value="/admin/addbillingconfig", consumes = "application/json")
    public ResponseMessage addbillconfig(@RequestBody HashMap<String, String> data) {
        log.info("Billing API is called");
        ResponseMessage response = new ResponseMessage();

        adminServices.addbillconfig(data);
        List<Billconfig> billconfigList = new ArrayList<>();
        billconfigList = adminServices.billConfig();
        List<Processor> processorList = adminServices.getProcessor();
        List<Memory> memoryList = adminServices.getMemory();
        List<Storage> storageList = adminServices.getStorage();


        Map<String, Object> datas = new HashMap<>();
        datas.put("data", billconfigList);
        datas.put("processorList", processorList);
        datas.put("memoryList", memoryList);
        datas.put("storageList", storageList);
        response.setData(datas);
        response.setErrorCode(0);
        response.setResponseMsg(null);

        return response;
    }


    @RequestMapping(method = RequestMethod.POST, value="/admin/billconfig", consumes = "application/json")
    public ResponseMessage billconfig(@RequestBody HashMap<String, String> data) {
        log.info("BillConfig API is called");
        ResponseMessage response = new ResponseMessage();

        List<Billconfig> billconfigList = new ArrayList<>();
        billconfigList = adminServices.billConfig();

        Map<String, Object> datas = new HashMap<>();
        datas.put("data", billconfigList);
        response.setData(datas);
        response.setErrorCode(0);
        response.setResponseMsg(null);

        return response;
    }

//    @RequestMapping(method = RequestMethod.GET, value="/user/test", produces = "application/json")
//    public ResponseMessage testAPI() {
//        log.info("User Test API is called");
//        ResponseMessage response = new ResponseMessage();
//
//        response.setResponseMsg("Test goes through");
//        response.setErrorCode(0);
//        response.setData(null);
//
//        return response;
//    }




}
