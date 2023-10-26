package cn.jiyun.service.impl;

import cn.jiyun.entity.Hospital;
import cn.jiyun.mapper.HospitalMapper;
import cn.jiyun.result.PageResult;
import cn.jiyun.service.HospitalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {
    @Resource
    private HospitalMapper hospitalMapper;


    @Override
    public PageResult getPage(Integer page, Integer size, Hospital hospital) {
        PageHelper.startPage(page, size);
        List<Hospital> list = hospitalMapper.findHosp(hospital);
        PageInfo pageInfo = new PageInfo(list);

        return new PageResult(pageInfo.getTotal(), pageInfo.getList());

    }
}
