package cn.jiyun.service;

import cn.jiyun.entity.OrderNum;
import cn.jiyun.result.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface OrderService {
    Result insert(OrderNum orderNum);

    void download(HttpServletResponse res) throws IOException;
}
