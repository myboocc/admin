package com.spartan.front.admin.controller;

import com.alibaba.fastjson.JSON;
import com.front.operator.bean.FareRepertory;
import com.front.operator.bean.Purchaser;
import com.spartan.front.admin.dto.FareRepertoryQuery;
import com.spartan.front.admin.dto.FareRepertoryResponse;
import com.spartan.front.admin.utils.ResultVOUtil;
import com.spartan.front.admin.vo.ResultVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/fareRepertory")
public class FareRepertoryController {
	

	@PostMapping("/list")
    public ResultVO<Map<String,String>> list(FareRepertoryQuery fareRepertoryQuery){
        System.out.println(JSON.toJSON(fareRepertoryQuery));
        FareRepertoryResponse response = new FareRepertoryResponse();
        List<FareRepertory> items = Arrays.asList(
                new FareRepertory("AKK", "KCS", "KS", "M", "12333", "KD", "2014-11-25", "2016-05-02 11:22:11", "2016-05-02 11:22:11", "5"),
                new FareRepertory("AKK", "KCS", "KS", "M", "12333", "KD", "2014-11-25", "2016-05-02 11:22:11", "2016-05-02 11:22:11", "5"),
                new FareRepertory("AKK", "KCS", "KS", "M", "12333", "KD", "2014-11-25", "2016-05-02 11:22:11", "2016-05-02 11:22:11", "5"),
                new FareRepertory("AKK", "KCS", "KS", "M", "12333", "KD", "2014-11-25", "2016-05-02 11:22:11", "2016-05-02 11:22:11", "5"),
                new FareRepertory("AKK", "KCS", "KS", "M", "12333", "KD", "2014-11-25", "2016-05-02 11:22:11", "2016-05-02 11:22:11", "5"),
                new FareRepertory("AKK", "KCS", "KS", "M", "12333", "KD", "2014-11-25", "2016-05-02 11:22:11", "2016-05-02 11:22:11", "5"),
                new FareRepertory("AKK", "KCS", "KS", "M", "12333", "KD", "2014-11-25", "2016-05-02 11:22:11", "2016-05-02 11:22:11", "5"),
                new FareRepertory("AKK", "KCS", "KS", "M", "12333", "KD", "2014-11-25", "2016-05-02 11:22:11", "2016-05-02 11:22:11", "5"),
                new FareRepertory("AKK", "KCS", "KS", "M", "12333", "KD", "2014-11-25", "2016-05-02 11:22:11", "2016-05-02 11:22:11", "5"),
                new FareRepertory("AKK", "KCS", "KS", "M", "12333", "KD", "2014-11-25", "2016-05-02 11:22:11", "2016-05-02 11:22:11", "5"),
                new FareRepertory("AKK", "KCS", "KS", "M", "12333", "KD", "2014-11-25", "2016-05-02 11:22:11", "2016-05-02 11:22:11", "5"),
                new FareRepertory("AKK", "KCS", "KS", "M", "12333", "KD", "2014-11-25", "2016-05-02 11:22:11", "2016-05-02 11:22:11", "5"),
                new FareRepertory("AKK", "KCS", "KS", "M", "12333", "KD", "2014-11-25", "2016-05-02 11:22:11", "2016-05-02 11:22:11", "5")
        );

        response.setItems(items);
        response.setTotal(items.size());

        return ResultVOUtil.success(response);
    }

	
}
