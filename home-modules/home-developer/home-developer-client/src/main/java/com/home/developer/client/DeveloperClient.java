package com.home.developer.client;

import com.home.common.core.vo.ResultVo;
import com.home.developer.common.dto.BuildingDto;
import com.home.developer.common.dto.BuildingPositionDto;
import com.home.developer.common.dto.DeveloperDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(value = DEVELOPER_SERVER_PREFIX + "/{primaryKey}", method = RequestMethod.GET)
    ResultVo<DeveloperDto> findDeveloper(@PathVariable(name = "primaryKey") Long primaryKey);

    /**
     * 获取楼盘详情
     *
     * @param primaryKey 主键Id
     * @return ResultVo<BuildingDto>
     */
    @RequestMapping(value = DEVELOPER_SERVER_PREFIX + "/building/{primaryKey}", method = RequestMethod.GET)
    ResultVo<BuildingDto> findBuilding(@PathVariable(name = "primaryKey") Long primaryKey);

    /**
     * 获取楼盘岗位详情
     *
     * @param primaryKey 主键Id
     * @return ResultVo<BuildingPositionDto>
     */
    @RequestMapping(value = DEVELOPER_SERVER_PREFIX + "/building/position/{primaryKey}", method = RequestMethod.GET)
    ResultVo<BuildingPositionDto> findBuildingPosition(@PathVariable(name = "primaryKey") Long primaryKey);

    class DeveloperClientFallback implements DeveloperClient {
        @Override
        public ResultVo<DeveloperDto> findDeveloper(Long primaryKey) {
            return ResultVo.hystrix();
        }

        @Override
        public ResultVo<BuildingDto> findBuilding(Long primaryKey) {
            return ResultVo.hystrix();
        }

        @Override
        public ResultVo<BuildingPositionDto> findBuildingPosition(Long primaryKey) {
            return ResultVo.hystrix();
        }
    }
}
