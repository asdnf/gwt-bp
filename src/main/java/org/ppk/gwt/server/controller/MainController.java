package org.ppk.gwt.server.controller;

import org.ppk.gwt.server.dao.DataObjectRepository;
import org.ppk.gwt.server.entity.DataObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    DataObjectRepository dataObjectRepository;

    @RequestMapping(value = "/main/test", method = RequestMethod.PUT)
    @ResponseBody
    ResponseEntity<Map<String, String>> test(@RequestBody String data) {
        Map<String, String> response = new HashMap<>();
        response.put("data", data);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/main/dataobject", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<DataObject>> getDataObjects() {
        ArrayList<DataObject> response = new ArrayList<>();
        dataObjectRepository.findAll().forEach(response::add);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/main/dataobject", method = RequestMethod.PUT)
    @ResponseBody
    ResponseEntity<Void> putDataObjects(@RequestBody DataObject dataObject) {
        dataObject.setId(null);
        dataObjectRepository.save(dataObject);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/main/dataobject", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Void> postDataObjects(@RequestBody DataObject dataObject) {
        dataObjectRepository.save(dataObject);
        return ResponseEntity.ok().build();
    }

}
