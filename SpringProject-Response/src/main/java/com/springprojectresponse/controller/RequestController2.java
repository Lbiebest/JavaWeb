package com.springprojectresponse.controller;

import com.springprojectresponse.pojo.Address;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RequestController2 {

    @RequestMapping("/hello")
    public String hello() {
        String hello = "hello world";
        System.out.println(hello);
        return hello;
    }

    @RequestMapping("/getAddress")
    public Address getAddress() {
        Address address = new Address();
        address.setProvince("浙江");
        address.setCity("杭州");

        System.out.println(address);
        return address;
    }

    @RequestMapping("/listAddress")
    public ArrayList<Address> listAddress() {
        List<Address> list = new ArrayList<>();

        Address address = new Address();
        address.setProvince("浙江");
        address.setCity("杭州");

        Address address1 = new Address();
        address1.setProvince("浙江");
        address1.setCity("杭州");

        list.add(address);
        list.add(address1);

        System.out.println(list);
        return (ArrayList<Address>) list;
    }


}
