package com.home.developer.client;

import com.home.common.core.vo.ResultVo;
import com.home.developer.common.dto.BuildingDto;
import com.home.developer.common.dto.BuildingPositionDto;
import com.home.developer.common.dto.DeveloperDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 开发商客户端
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-02 16:23
 **/
@FeignClient(
        name = "developer",
        fallback = DeveloperClient.DeveloperClientFallback.class
)
public interface DeveloperClient {

    /**
     * Developer 服务访问前缀
     */
    String DEVELOPER_SERVER_PREFIX = "/developer";

    /**
     * 获取开发商详情
     *
     * @param primaryKey 主键Id
     * @return ResultVo<DeveloperDto>
     */
    @GetMapping(DEVELOPER_SERVER_PREFIX + "/{primaryKey}")
    ResultVo<DeveloperDto> findDeveloper(@PathVariable Long primaryKey);

    /**
     * 获取楼盘详情
     *
     * @param primaryKey 主键Id
     * @return ResultVo<BuildingDto>
     */
    @GetMapping(DEVELOPER_SERVER_PREFIX + "/building/{primaryKey}")
    ResultVo<BuildingDto> building(@PathVariable Long primaryKey);

    /**
     * 获取楼盘岗位详情
     *
     * @param primaryKey 主键Id
     * @return ResultVo<BuildingPositionDto>
     */
    @GetMapping(DEVELOPER_SERVER_PREFIX + "/building/position/{primaryKey}")
    ResultVo<BuildingPositionDto> buildingPosition(@PathVariable Long primaryKey);

    class DeveloperClientFallback implements DeveloperClient {
        @Override
        public ResultVo<DeveloperDto> findDeveloper(Long primaryKey) {
            return ResultVo.hystrix();
        }

        @Override
        public ResultVo<BuildingDto> building(Long primaryKey) {
            return ResultVo.hystrix();
        }

        @Override
        public ResultVo<BuildingPositionDto> buildingPosition(Long primaryKey) {
            return ResultVo.hystrix();
        }
    }
}
