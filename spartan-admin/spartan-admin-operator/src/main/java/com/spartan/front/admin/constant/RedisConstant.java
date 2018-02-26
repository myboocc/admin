/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.spartan.front.admin.constant;

/**
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-08-21 15:03
 */
public interface RedisConstant {
    String TOKEN_PREFIX = "token_"; //token前缀

    Integer EXPIRE = 7200; //默认过期时间设置为2小时
}
