package com.home.common.core.dto;

import lombok.Data;

/**
 * 删除数据
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-02 14:56
 **/
@Data
public class DeleteDto {
    /**
     * 需要删除的数据Id集合
     */
    private Long[] Ids;
}
