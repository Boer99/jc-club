package com.jingdianjichi.subject.domain.service;

import com.jingdianjichi.subject.common.entity.PageResult;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.domain.entity.SubjectLabelBO;

import java.util.List;

/**
 * 题目领域服务
 * 
 * @author: ChickenWing
 * @date: 2023/10/3
 */
public interface SubjectInfoDomainService {

    /**
     * 新增题目
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 分页查询
     */
    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    /**
     * 查询题目信息
     */
    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);

}

