package com.shiyuanfunc.sharding.baseon.mastersalve.test;

import com.shiyuanfunc.sharding.baseon.mastersalve.mapper.OrderInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MUSI
 * @Date 2022/7/26 11:31 PM
 * @Description
 * @Version
 **/
@RestController
@RequestMapping(path = "/test")
@RequiredArgsConstructor
public class TestController {

    private final OrderInfoMapper orderInfoMapper;

    @GetMapping(path = "/get")
    public Object get(Long orderId){
        return orderInfoMapper.selectByPrimaryKey(orderId);
    }

}
