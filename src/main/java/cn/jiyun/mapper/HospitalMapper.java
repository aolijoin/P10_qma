package cn.jiyun.mapper;

import cn.jiyun.entity.Hospital;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HospitalMapper extends BaseMapper<Hospital> {
    @Select("<script> select * from qma.hospital h where 1=1 " +
            "<if test='dept!=null and dept!=\"\"'> and h.dept=#{dept}  </if>" +
            "<if test='doctor!=null and doctor!=\"\"'> and h.doctor like  concat('%',#{doctor},'%')  </if>" +
            " </script>")
    List<Hospital> findHosp(Hospital hospital);
}
