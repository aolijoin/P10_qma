package cn.jiyun.controller;

import cn.jiyun.entity.Hospital;
import cn.jiyun.result.PageResult;
import cn.jiyun.service.HospitalService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("hospital")
public class HospitalController {
    @Resource
    private HospitalService hospitalService;

    @RequestMapping("getPage")
    public PageResult getPage(Integer page, Integer size, @RequestBody Hospital hospital) {

        return hospitalService.getPage(page, size, hospital);
    }

}
