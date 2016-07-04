<#assign className = table.classNameBo>
/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: ${module}
 * $Id:  ${className}.java ${now?string('yyyy-MM-dd HH:mm:ss')} $
 */
<#include "/macro.include"/>
<#assign classNameLower = className?uncap_first>

<#assign isCbd = false>

<#list table.columns as column>
    <#if column=='creator'>
        <#assign isCbd = true>
    </#if>
</#list>


package ${basepackage}.${module}.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;



import java.io.Serializable;
import java.util.*;

public class ${className} implements Serializable {
<#list table.columns as column>
<#if column='id'||column='creator'||column='createDate'||column='lastModifier'||column='lastModDate'||column='status'>
	private ${column.possibleShortJavaType} ${column.columnNameFirstLower};
<#else>
	/**
	 * ${column.remarks}
	 */
	private ${column.possibleShortJavaType} ${column.columnNameFirstLower};
</#if>
</#list>

<@generateJavaManyToOne_attribute/>
<@generateJavaOneToMany_attribute/>
<@generateConstructor className/>

<@generateJavaColumns/>
<@generateJavaManyToOne_method/>
<@generateJavaOneToMany_method/>

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
		<#list table.columns as column>
			.append("${column.columnName}",get${column.columnName}())
		</#list>
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
		<#list table.pkColumns as column>
			.append(get${column.columnName}())
		</#list>
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ${className} == false) return false;
		if(this == obj) return true;
		${className} other = (${className})obj;
		return new EqualsBuilder()
			<#list table.pkColumns as column>
			.append(get${column.columnName}(),other.get${column.columnName}())
			</#list>
			.isEquals();
	}
}

<#macro generateJavaColumns>
<#list table.columns as column>
    <#if column.isDateTimeColumn>

    </#if>
<#if column='id'||column='creator'||column='createDate'||column='lastModifier'||column='lastModDate'||column='status'>
	public void set${column.columnName}(${column.possibleShortJavaType} value) {
	    this.${column.columnNameFirstLower} = value;
	}
	
	public ${column.possibleShortJavaType} get${column.columnName}() {
	    return this.${column.columnNameFirstLower};
	}
<#else>
    public void set${column.columnName}(${column.possibleShortJavaType} value) {
        this.${column.columnNameFirstLower} = value;
    }

    public ${column.possibleShortJavaType} get${column.columnName}() {
        return this.${column.columnNameFirstLower};
    }
</#if>
</#list>
</#macro>

<#macro generateJavaOneToMany_attribute>
	<#list table.exportedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>

	private List<${fkPojoClass}> ${fkPojoClassVar}s = new ArrayList<${fkPojoClass}>(0);

	</#list>
</#macro>

<#macro generateJavaOneToMany_method>
	<#list table.exportedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>

	public void set${fkPojoClass}s(List<${fkPojoClass}> ${fkPojoClassVar}){
		this.${fkPojoClassVar}s = ${fkPojoClassVar};
	}
	
	public List<${fkPojoClass}> get${fkPojoClass}s() {
		return ${fkPojoClassVar}s;
	}
	</#list>
</#macro>

<#macro generateJavaManyToOne_attribute>
	<#list table.importedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	private ${fkPojoClass} ${fkPojoClassVar};

	</#list>
</#macro>

<#macro generateJavaManyToOne_method>
	<#list table.importedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>

	public void set${fkPojoClass}(${fkPojoClass} ${fkPojoClassVar}){
		this.${fkPojoClassVar} = ${fkPojoClassVar};
	}
	
	public ${fkPojoClass} get${fkPojoClass}() {
		return ${fkPojoClassVar};
	}
	</#list>
</#macro>

