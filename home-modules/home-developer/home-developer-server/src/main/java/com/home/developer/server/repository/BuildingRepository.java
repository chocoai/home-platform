package com.home.developer.server.repository;

import com.home.developer.server.domain.Building;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 楼盘表
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
public interface BuildingRepository extends JpaRepository<Building, Long> {

    /**
     * 根据主键Id 和 删除标志 获取数据
     *
     * @param Id         主键Id
     * @param deleteFlag 删除标志
     * @return Building
     */
    Building findByIdAndDeleteFlag(Long Id, Boolean deleteFlag);
}