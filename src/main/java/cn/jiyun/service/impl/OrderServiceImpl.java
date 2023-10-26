package cn.jiyun.service.impl;

import cn.jiyun.entity.Hospital;
import cn.jiyun.entity.OrderNum;
import cn.jiyun.mapper.HospitalMapper;
import cn.jiyun.mapper.OrderMapper;
import cn.jiyun.result.Result;
import cn.jiyun.service.OrderService;
import com.baomidou.mybatisplus.extension.api.R;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private HospitalMapper hospitalMapper;

    //    @Transactional
    @Override
    public Result insert(OrderNum orderNum) {
        System.out.println("insert(OrderNum orderNum): " + orderNum);
        try {
            orderMapper.insert(orderNum);
            List<Hospital> hospitals = hospitalMapper.selectList(null);

            for (Hospital hospital : hospitals) {
                if (hospital.getDept().equals(orderNum.getDept())) {
                    hospital.setNum(hospital.getNum() - 1);
                    hospitalMapper.updateById(hospital);
                }
            }
            return Result.success();
        } catch (Exception e) {
            return Result.error("操作错误");
        }
    }

    @Override
    public void download(HttpServletResponse res) throws IOException {
        List<OrderNum> orderNums = orderMapper.selectList(null);
        String[] title = {"订单号", "就诊科室", "就诊时间", "就诊医生", "挂号费", "就诊人"};
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet();
        XSSFRow head = sheet.createRow(0);
        for (int i = 0; i < title.length; i++) {
            head.createCell(i).setCellValue(title[i]);
        }

        for (int i = 0; i < orderNums.size(); i++) {
            XSSFRow row = sheet.createRow(i + 1);
            OrderNum orderNum = orderNums.get(i);
            row.createCell(0).setCellValue(orderNum.getId());
            row.createCell(1).setCellValue(orderNum.getDept());
            row.createCell(2).setCellValue(orderNum.getDoctor());
            row.createCell(3).setCellValue(orderNum.getTime());
            row.createCell(4).setCellValue(orderNum.getMoney());
            row.createCell(5).setCellValue(orderNum.getUser());
        }
        res.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("挂号信息.xlsx", "UTF-8"));
        res.setHeader("Connection", "close");
        res.setHeader("Content-Type", "application/octet-stream");
        wb.write(res.getOutputStream());
    }
}
