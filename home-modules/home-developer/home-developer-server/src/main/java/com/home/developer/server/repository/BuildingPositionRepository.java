package com.home.developer.server.repository;

import com.home.developer.server.domain.BuildingPosition;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 楼盘职位
 *
 * @author Roger
 * @email 190642964@qq.com
 * @create 2018-7-2 9:51:36
 */
public interface BuildingPositionRepository extends JpaRepository<BuildingPosition, Long> {

    /**
     * 根据主键Id 和 删除标志 获取数据
     *
     * @param Id         主键Id
     * @param deleteFlag 删除标志
     * @return Building
     */
    BuildingPosition findByIdAndDeleteFlag(Long Id, Boolean deleteFlag);
}