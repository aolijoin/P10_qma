package cn.jiyun.service;

import cn.jiyun.entity.Hospital;
import cn.jiyun.result.PageResult;

public interface HospitalService {
    PageResult getPage(Integer page, Integer size, Hospital hospital);
}
