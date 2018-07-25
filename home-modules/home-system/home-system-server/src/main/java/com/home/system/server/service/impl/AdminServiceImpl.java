package com.home.system.server.service.impl;

import com.home.common.core.constant.HomeConstant;
import com.home.common.core.exception.HomeCustomException;
import com.home.common.core.exception.enums.system.SystemExceptionCode;
import com.home.common.core.vo.ResultVo;
import com.home.system.common.vo.AdminVo;
import com.home.system.common.vo.RoleVo;
import com.home.system.server.domain.Admin;
import com.home.system.server.repository.AdminRepository;
import com.home.system.server.repository.specification.BaseSpecification;
import com.home.system.server.service.AdminService;
import com.home.system.server.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 管理员 业务处理实现
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-9 18:37:14
 */
@Service
public class AdminServiceImpl implements AdminService {

    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public ResultVo<AdminVo> findAdminByPrimaryKey(Long primaryKey) {
        Optional<Admin> adminOptional = adminRepository.findById(primaryKey);
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            AdminVo adminVo = new AdminVo();
            BeanUtils.copyProperties(admin, adminVo);
            return ResultVo.ok(adminVo);
        }
        return ResultVo.dataEmpty();
    }

    @Override
    public ResultVo<AdminVo> findAdminByAccount(String account) {
        Admin admin = adminRepository.findAdminByAccount(account);
        if (null == admin) {
            return ResultVo.dataEmpty();
        }
        AdminVo adminVo = new AdminVo();
        BeanUtils.copyProperties(admin, adminVo);

        List<RoleVo> roleVos = roleService.findRoleByAdminId(admin.getId());
        adminVo.setRoleVoList(roleVos);
        return ResultVo.ok(adminVo);
    }

    @Override
    public ResultVo<Page<AdminVo>> page(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        Page<Admin> admins = adminRepository.findAll(BaseSpecification.getRestriction(), pageable);
        return ResultVo.ok(admins);
    }

    @Override
    public void save(AdminVo param) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(param, admin);
        admin.setCreateTime(new Date());
        admin.setUpdateTime(admin.getCreateTime());
        admin.setDeleteFlag(Boolean.FALSE);
        admin.setPassword(ENCODER.encode(param.getPassword()));

        adminRepository.save(admin);
    }

    @Override
    public void modify(AdminVo param) {
        Optional<Admin> adminOptional = adminRepository.findById(param.getId());
        if (!adminOptional.isPresent()) {
            throw new HomeCustomException(SystemExceptionCode.ADMIN_NON_EXISTENT.getCode(), SystemExceptionCode.ADMIN_NON_EXISTENT.getMessage());
        }

        Admin admin = new Admin();
        BeanUtils.copyProperties(param, admin);
        admin.setCreateTime(adminOptional.get().getCreateTime());
        admin.setUpdateTime(new Date());
        admin.setDeleteFlag(Boolean.FALSE);

        if (HomeConstant.NO_MODIFY_PASSWORD.equals(param.getPassword())){
            admin.setPassword(adminOptional.get().getPassword());
        }else {
            admin.setPassword(ENCODER.encode(param.getPassword()));
        }

        adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(Long... primaryKeys) {
        List<Admin> admins = new ArrayList<>();
        Admin admin = null;
        for (Long primaryKey : primaryKeys) {
            Optional<Admin> adminOptional = adminRepository.findById(primaryKey);
            if (!adminOptional.isPresent()) {
                throw new HomeCustomException(SystemExceptionCode.ADMIN_NON_EXISTENT.getCode(), SystemExceptionCode.ADMIN_NON_EXISTENT.getMessage());
            }

            admin = adminOptional.get();
            admin.setUpdateTime(new Date());
            admin.setDeleteFlag(Boolean.TRUE);
            admins.add(admin);
        }
        adminRepository.saveAll(admins);
    }
}