package cn.jiyun.controller;

import cn.jiyun.entity.OrderNum;
import cn.jiyun.result.Result;
import cn.jiyun.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @RequestMapping("insert")
    public Result insert(@RequestBody OrderNum orderNum) {
        log.info("orderNum:{}", orderNum.toString());
        return orderService.insert(orderNum);
    }

    @RequestMapping("download")
    public void download(HttpServletResponse res) throws IOException {
        orderService.download(res);
    }
}
