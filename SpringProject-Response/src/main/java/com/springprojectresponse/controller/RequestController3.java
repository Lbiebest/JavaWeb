package com.springprojectresponse.controller;

import com.springprojectresponse.Result;
import com.springprojectresponse.pojo.Address;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RequestController3 {

    @RequestMapping("/helloReturnResult")
    public Result helloReturnResult() {
        String hello = "hello world";
        System.out.println(hello);
        //        return new Result(true, "success", hello);
        return Result.success(hello);
    }

    @RequestMapping("/getAddressReturnResult")
    public Result<Address> getAddressReturnResult() {
        Address address = new Address();
        address.setProvince("浙江");
        address.setCity("杭州");

        System.out.println(address);
        return Result.success(address);
    }

    @RequestMapping("/listAddressReturnResult")
    public Result<List<Address>> listAddressReturnResult() {
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
        return Result.success(list);
    }
}
