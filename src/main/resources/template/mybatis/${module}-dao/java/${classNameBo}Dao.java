<#assign className = table.classNameBo>
/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ${module}
 * $Id:  ${className}Dao.java ${now?string('yyyy-MM-dd HH:mm:ss')} $
 */
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.${persistence};

import cn.thinkjoy.common.Dao.BaseDao;
import ${basepackage}.domain.${className};

public interface ${className}Dao extends BaseDao<${className}>{
	
<#list table.columns as column>
	<#if (column.unique && !column.pk)>
	${className} findBy${column.columnName}(${column.possibleShortJavaType} ${column.columnNameFirstLower});
	</#if>
</#list>

}
