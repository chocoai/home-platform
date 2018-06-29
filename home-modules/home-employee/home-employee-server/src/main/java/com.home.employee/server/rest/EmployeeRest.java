package com.home.employee.server.rest;

import com.home.common.core.vo.ResultVo;
import com.home.employee.common.dto.EmployeeDto;
import com.home.employee.server.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工相关接口
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-06-29 16:17
 **/
@Api(tags = {"员工相关操作"})
@RestController
@RequestMapping("/employee")
public class EmployeeRest {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    @ApiOperation(value = "添加、修改员工信息",notes = "根据主键Id来判断为修改、添加")
    public ResultVo save(@RequestBody EmployeeDto param){
        employeeService.save(param);
        return ResultVo.ok();
    }



}
