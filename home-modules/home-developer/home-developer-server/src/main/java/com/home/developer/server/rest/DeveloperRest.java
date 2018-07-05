package com.home.developer.server.rest;

import com.home.common.core.dto.DeleteDto;
import com.home.common.core.vo.ResultVo;
import com.home.developer.common.dto.*;
import com.home.developer.server.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 开发商相关接口
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-02 10:14
 **/
@Api(tags = {"开发商相关操作"})
@RestController
@RequestMapping("/developer")
public class DeveloperRest {

    @Autowired
    private DeveloperService developerService;
    @Autowired
    private DeveloperOperationAreaService developerOperationAreaService;
    @Autowired
    private DeveloperOperationAccountService developerOperationAccountService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private BuildingPositionService buildingPositionService;

    @PostMapping
    @ApiOperation(value = "添加、修改开发商信息", notes = "根据主键Id来判断为修改、添加")
    public ResultVo developer(@RequestBody DeveloperDto param) {
        developerService.saveOrUpdate(param);
        return ResultVo.ok();
    }

    @GetMapping("/{primaryKey}")
    @ApiOperation(value = "获取开发商详情")
    public ResultVo<DeveloperDto> findDeveloper(@PathVariable Long primaryKey) {
        return developerService.findDeveloperByPrimaryKey(primaryKey);
    }

    @GetMapping
    @ApiOperation(value = "获取开发商详情")
    public ResultVo<DeveloperDto> getDeveloper(@RequestParam(name = "primaryKey") Long primaryKey) {
        return developerService.findDeveloperByPrimaryKey(primaryKey);
    }

    @PostMapping("/operation/area")
    @ApiOperation(value = "添加、修改运营区域", notes = "根据主键Id来判断为修改、添加")
    public ResultVo operationArea(@RequestBody DeveloperOperationAreaDto param) {
        developerOperationAreaService.saveOrUpdateDeveloperOperationArea(param.getId(), param.getDeveloperId(), param.getParentId(), param.getOperationAreaName());
        return ResultVo.ok();
    }

    @PostMapping("/operation/account")
    @ApiOperation(value = "添加、修改运营区域管理账号", notes = "根据主键Id来判断为修改、添加")
    public ResultVo operationAreaAccount(@RequestBody DeveloperOperationAccountDto param) {
        developerOperationAccountService.saveOrUpdateDeveloperOperationAccount(param.getId(), param.getDeveloperId(), param.getOperationAreaId(), param.getAccount(), param.getPassword());
        return ResultVo.ok();
    }

    @PostMapping("/building")
    @ApiOperation(value = "添加、修改楼盘信息", notes = "根据主键Id来判断为修改、添加")
    public ResultVo saveBuilding(@RequestBody BuildingDto param) {
        buildingService.saveOrUpdateBuilding(param);
        return ResultVo.ok();
    }

    @DeleteMapping("/building")
    @ApiOperation(value = "删除楼盘", notes = "根据主键Id来删除")
    public ResultVo deleteBuilding(@RequestBody DeleteDto param) {
        buildingService.deleteBuilding(param.getIds());
        return ResultVo.ok();
    }

    @GetMapping("/building/{primaryKey}")
    @ApiOperation(value = "获取楼盘详情")
    public ResultVo<BuildingDto> findBuilding(@PathVariable Long primaryKey) {
        return buildingService.findBuildingByPrimaryKey(primaryKey);
    }

    @PostMapping("/building/position")
    @ApiOperation(value = "添加、修改楼盘岗位信息", notes = "根据主键Id来判断为修改、添加")
    public ResultVo saveBuildingPosition(@RequestBody BuildingPositionDto param) {
        buildingPositionService.saveOrUpdateBuildingPosition(param);
        return ResultVo.ok();
    }

    @GetMapping("/building/position/{primaryKey}")
    @ApiOperation(value = "获取楼盘岗位详情")
    public ResultVo<BuildingPositionDto> findBuildingPosition(@PathVariable Long primaryKey) {
        return buildingPositionService.findBuildingPositionByPrimaryKey(primaryKey);
    }
}
