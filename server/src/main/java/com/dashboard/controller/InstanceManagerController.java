package com.dashboard.controller;

import com.dashboard.domain.ResponseMessage;
import com.dashboard.services.InstanceManagerServices;
import com.dashboard.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class InstanceManagerController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    InstanceManagerServices instanceManagerServices;

    @RequestMapping(method = RequestMethod.POST, value="/instance/reserve")
    public ResponseMessage reserve(@RequestBody HashMap<String, Object> data) {
        log.info("Instance reserve API is called");
        ResponseMessage response = new ResponseMessage();

        int responseCode =  instanceManagerServices.reserve(data);

        response.setErrorCode(responseCode);

        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value="/instance/release", consumes = "application/json")
    public ResponseMessage release(@RequestBody HashMap<String, String> data) {
        log.info("Instance release API is called");
        ResponseMessage response = new ResponseMessage();

        int responseCode =  instanceManagerServices.release(data);

        response.setErrorCode(responseCode);

        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value="/instance/test")
    public ResponseMessage test() {
        log.info("Instance reserve API is called");
        ResponseMessage response = new ResponseMessage();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("id", 1);
        data.put("userName", "sdthai");
        data.put("imageType", "Ubuntu");

        int responseCode =  instanceManagerServices.reserve(data);

        response.setErrorCode(responseCode);

        return response;
    }
}
