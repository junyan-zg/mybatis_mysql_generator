<#assign className = table.classNameBo>
<#assign classNameLower = className?uncap_first>
<#include "/macro.include"/>
/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ${module}
 * $Id:  ${className}Service.java ${now?string('yyyy-MM-dd HH:mm:ss')} $
 */

package ${basepackage}.service;
import cn.thinkjoy.common.Dao.BaseDao;
import cn.thinkjoy.common.domain.BaseDomain;
import cn.thinkjoy.common.service.BaseService;
import cn.thinkjoy.common.service.PageService;

public interface ${className}Service<D extends BaseDao<T>, T extends BaseDomain> extends BaseService<D, T>,PageService<D, T>{

}
