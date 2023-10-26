package cn.jiyun.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class OrderNum implements Serializable {
    private Long id;
    private String dept;
    private String time;
    private String doctor;
    private Double money;
    private String user;
}
