package com.aidangordon.api.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleResult {
    private String parameter;
    private String result;

    public String getParameter() {
        return parameter;
    }

    public String getResult() {
        return result;
    }

    public String getWhatever(){
        return "lol";
    }

    public List<Object> getStuff(){
        List<Object> stuffs = new ArrayList<Object>();
        stuffs.add("hi");
        stuffs.add("there");
        stuffs.add("I come from a list");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("and here", "is a map example");
        map.put("list", new ArrayList<String>());
        stuffs.add(map);
        return stuffs;
    }

    public SampleResult(String parameter, String result) {
        this.parameter = parameter;
        this.result = result;
    }
}
