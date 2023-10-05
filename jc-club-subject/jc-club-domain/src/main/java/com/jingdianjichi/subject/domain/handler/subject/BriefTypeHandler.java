package com.jingdianjichi.subject.domain.handler.subject;

import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import org.springframework.stereotype.Component;

/**
 * 简答题目的策略类
 * 
 * @author: ChickenWing
 * @date: 2023/10/5
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler{
    
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
    }
}
