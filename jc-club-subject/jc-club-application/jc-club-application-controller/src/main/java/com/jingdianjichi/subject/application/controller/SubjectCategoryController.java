package com.jingdianjichi.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.subject.application.convert.SubjectCategoryDTOConverter;
import com.jingdianjichi.subject.application.dto.SubjectCategoryDTO;
import com.jingdianjichi.subject.common.entity.Result;
import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import com.jingdianjichi.subject.domain.service.SubjectCategoryDomainServie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 刷题分类controller
 *
 * @author: ChickenWing
 * @date: 2023/10/1
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {

    @Resource
    private SubjectCategoryDomainServie subjectCategoryDomainServie;

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try {
            if(log.isInfoEnabled()){
                log.info("SubjectCategoryController.add.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(),"分类类型不能为空");
            Preconditions.checkArgument(StringUtils.isEmpty(subjectCategoryDTO.getCategoryName()),"分类名称不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(),"分类父级id不能为空");
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertBoToCategory(subjectCategoryDTO);
            subjectCategoryDomainServie.add(subjectCategoryBO);
            return Result.ok(true);
        }catch (Exception e){
            log.error("SubjectCategoryController.add.error:{}",e.getMessage(),e);
            return Result.fail(e.getMessage());
        }
    }

}
