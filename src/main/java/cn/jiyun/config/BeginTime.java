package cn.jiyun.config;

import cn.jiyun.entity.Hospital;
import cn.jiyun.mapper.HospitalMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class BeginTime {

    @Resource
    private HospitalMapper hospitalMapper;

    @Scheduled(cron = "0/300 * * * * ?")
    public void print() {
        List<Hospital> hospitals = hospitalMapper.selectList(null);
        for (Hospital hospital : hospitals) {
            if ("内科".equals(hospital.getDept())){
                System.out.println(hospital);
            }
        }

    }
}
