package com.dashboard.controller;

import com.dashboard.domain.Instance;
import com.dashboard.domain.ResponseMessage;
import com.dashboard.services.InstanceManagerServices;
import com.dashboard.services.UserServices;
import com.dashboard.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class InstanceManagerController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    InstanceManagerServices instanceManagerServices;

    @RequestMapping(method = RequestMethod.POST, value="/instance/reserve", consumes = "application/json")
    public ResponseMessage reserve(@RequestBody HashMap<String, Object> data) {
        log.info("Instance reserve API is called");
        ResponseMessage response = new ResponseMessage();

        int responseCode = instanceManagerServices.reserve(data);

        response.setErrorCode(responseCode);
        if (responseCode == 0) {
            response.setResponseMsg(Constants.INSTANCE_CREATED_SUCCESS);
        } else {
            response.setResponseMsg(Constants.INSTANCE_CREATED_FAIL);
        }

        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value="/instance/release", consumes = "application/json")
    public ResponseMessage release(@RequestBody HashMap<String, Object> data) {
        log.info("Instance release API is called");
        ResponseMessage response = new ResponseMessage();

        int responseCode =  instanceManagerServices.release(data);

        response.setErrorCode(responseCode);
        if (responseCode == 0) {
            response.setResponseMsg(Constants.INSTANCE_DELETED_SUCCESS);
        } else {
            response.setResponseMsg(Constants.INSTANCE_DELETED_FAIL);
        }

        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value="/instance/resume", consumes = "application/json")
    public ResponseMessage resume(@RequestBody HashMap<String, Object> data) {
        log.info("Instance suspend API is called");
        ResponseMessage response = new ResponseMessage();

        int responseCode =  instanceManagerServices.resume(data);

        response.setErrorCode(responseCode);
        if (responseCode == 0) {
            response.setResponseMsg(Constants.INSTANCE_RESUME_SUCCESS);
        } else {
            response.setResponseMsg(Constants.INSTANCE_RESUME_FAIL);
        }

        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value="/instance/suspend", consumes = "application/json")
    public ResponseMessage suspend(@RequestBody HashMap<String, Object> data) {
        log.info("Instance suspend API is called");
        ResponseMessage response = new ResponseMessage();

        int responseCode =  instanceManagerServices.suspend(data);

        response.setErrorCode(responseCode);
        if (responseCode == 0) {
            response.setResponseMsg(Constants.INSTANCE_SUSPEND_SUCCESS);
        } else {
            response.setResponseMsg(Constants.INSTANCE_SUSPEND_FAIL);
        }

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

    @RequestMapping(method = RequestMethod.GET, value="/instance/list")
    public ResponseMessage getAllInstances(@RequestParam(value = "userName", defaultValue = "") String userName) {
        log.info("Instance list API is called");
        ResponseMessage response = new ResponseMessage();

        List<Instance> instances = instanceManagerServices.getInstanceList(userName);
        Map<String, Object> data = new HashMap<>();
        data.put("data", instances);
        response.setData(data);
        response.setErrorCode(0);
        response.setResponseMsg(null);

        return response;

    }
}
