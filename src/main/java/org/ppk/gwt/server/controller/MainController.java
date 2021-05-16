package org.ppk.gwt.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @RequestMapping(value = "/main/test", method = RequestMethod.PUT)
    @ResponseBody
    Map<String, String> test(@RequestBody String data) {
        Map<String, String> response = new HashMap<>();
        response.put("data", data);
        return response;
    }

}
