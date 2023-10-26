package cn.jiyun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Hospital implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String doctor;
    private String dept;
    private String time;
    private Integer num;
}
