package com.home.employee.server.service;

import com.home.employee.common.dto.EmployeeCardDto;
import com.home.employee.server.domain.EmployeeCard;

/**
 * 员工证件信息表 业务处理接口
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 18:07:28
 */
public interface EmployeeCardService{

    /**
     * 添加、修改身份证信息
     * @param param EmployeeCardDto
     */
    void saveOrUpdateEmployeeCard(EmployeeCardDto param);
}