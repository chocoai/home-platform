package com.home.developer.server.repository;

import com.home.developer.server.domain.ApplyCooperationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 分销商申请合作审核记录
*
* @author Roger
* @email 190642964@qq.com
* @create 2018-7-2 9:51:36
*/
public interface ApplyCooperationRecordRepository extends JpaRepository<ApplyCooperationRecord,Long> {

}