package com.home.employee.server.service.impl;

import com.home.common.core.exception.HomeCustomException;
import com.home.common.core.exception.enums.HomeCustomExceptionCode;
import com.home.common.core.exception.enums.developer.DeveloperExceptionCode;
import com.home.common.core.exception.enums.employee.EmployeeExceptionCode;
import com.home.common.core.vo.ResultVo;
import com.home.developer.client.DeveloperClient;
import com.home.developer.common.dto.BuildingPositionDto;
import com.home.developer.common.dto.DeveloperDto;
import com.home.employee.common.dto.EmployeeCardDto;
import com.home.employee.common.dto.EmployeeDto;
import com.home.employee.common.dto.EmployeePositionDto;
import com.home.employee.server.domain.Employee;
import com.home.employee.server.domain.EmployeeBuildingPosition;
import com.home.employee.server.repository.EmployeeRepository;
import com.home.employee.server.service.EmployeeCardService;
import com.home.employee.server.service.EmployeeService;

import com.home.employee.server.service.EmployeeSourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

/**
 * 员工信息表 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 18:07:28
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeSourceService employeeSourceService;
    @Autowired
    private EmployeeCardService employeeCardService;
    @Autowired(required = false)
    private DeveloperClient developerClient;

    @Override
    @Transactional(rollbackFor = {HomeCustomException.class, Exception.class})
    public void save(EmployeeDto param) {
        if (param.getId() == null) {
            // 验证 开发商是否合法
            ResultVo<DeveloperDto> developerDtoResultVo = developerClient.findDeveloper(param.getDeveloperId());
            DeveloperDto developerDto = (DeveloperDto) ResultVo.verifyResponse(developerDtoResultVo);
            if (null == developerDto) {
                throw new HomeCustomException(DeveloperExceptionCode.DEVELOPER_UN_EXISTED.getCode(), DeveloperExceptionCode.DEVELOPER_UN_EXISTED.getMessage());
            }

            // 添加员工
            Employee save = new Employee();
            BeanUtils.copyProperties(param, save);
            save.setCertificationStatus(false);
            save.setCreateTime(new Date());
            save.setUpdateTime(save.getCreateTime());
            save.setDeleteFlag(false);
            Employee employee = employeeRepository.save(save);
            if (null == employee || employee.getId() == null) {
                throw new HomeCustomException(EmployeeExceptionCode.SAVE_EMPLOYEE_FAIL.getCode(), EmployeeExceptionCode.SAVE_EMPLOYEE_FAIL.getMessage());
            }

            // 添加员工来源信息
            employeeSourceService.saveEmployeeSource(param.getDeveloperId(), param.getOperationAreaId(), param.getBuildingId(), param.getDistributionId(), employee.getId());

            // 添加员工证件信息
            EmployeeCardDto employeeCardDto = param.getEmployeeCard();
            employeeCardDto.setEmployeeId(employee.getId());
            employeeCardService.saveOrUpdateEmployeeCard(employeeCardDto);

        } else {
            // 修改员工
            Optional<Employee> employeeOptional = employeeRepository.findById(param.getId());
            if (!employeeOptional.isPresent()) {
                throw new HomeCustomException(HomeCustomExceptionCode.UN_EXIST.getCode(), HomeCustomExceptionCode.UN_EXIST.getMessage());
            }

            int row = employeeRepository.modifyEmployeeByPrimaryKey(param.getEmployeeName(), param.getMobile(), param.getEmail(), param.getHeadImage(), param.getEmployeePassword(), param.getMaritalStatus(), param.getId());
            if (row <= 0) {
                throw new HomeCustomException(HomeCustomExceptionCode.MODIFY_FAIL.getCode(), HomeCustomExceptionCode.MODIFY_FAIL.getMessage());
            }
        }
    }

}