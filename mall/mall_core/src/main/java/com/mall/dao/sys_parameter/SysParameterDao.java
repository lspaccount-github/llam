package com.mall.dao.sys_parameter;

import com.mall.pojo.sys_parameter.SysParameter;
import com.mall.pojo.sys_parameter.SysParameterCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysParameterDao {
    int countByExample(SysParameterCriteria example);

    int deleteByExample(SysParameterCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(SysParameter record);

    int insertSelective(SysParameter record);

    List<SysParameter> selectByExample(SysParameterCriteria example);

    SysParameter selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysParameter record, @Param("example") SysParameterCriteria example);

    int updateByExample(@Param("record") SysParameter record, @Param("example") SysParameterCriteria example);

    int updateByPrimaryKeySelective(SysParameter record);

    int updateByPrimaryKey(SysParameter record);
}