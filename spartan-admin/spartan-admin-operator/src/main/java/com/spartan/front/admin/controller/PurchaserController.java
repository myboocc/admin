package com.spartan.front.admin.controller;

import com.alibaba.fastjson.JSON;
import com.front.operator.bean.Purchaser;
import com.front.operator.bean.User;
import com.spartan.front.admin.constant.RedisConstant;
import com.spartan.front.admin.utils.CookieUtil;
import com.spartan.front.admin.utils.ResultVOUtil;
import com.spartan.front.admin.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/api/purchaser")
public class PurchaserController {
	

	@PostMapping("/save")
    public ResultVO<Map<String,String>> save(Purchaser purchaser, String purchaserS){
        System.out.println(purchaserS);
        System.out.println(JSON.toJSON(purchaser));
        return null;
    }

	
}
