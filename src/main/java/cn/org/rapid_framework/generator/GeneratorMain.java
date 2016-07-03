package cn.org.rapid_framework.generator;

import java.util.Properties;

import cn.org.rapid_framework.generator.provider.db.table.TableFactory;

public class GeneratorMain {
	/**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(String[] args) throws Exception {

		GeneratorFacade g = new GeneratorFacade();
		// g.printAllTableNames(); //打印数据库中的表名称
		g.deleteOutRootDir(); // 删除生成器的输出目录
		// g.generateByTable("*","template/mybatis");
		// 通过数据库表生成文件,template为模板的根目录
		String file = GeneratorMain.class.getClassLoader()
				.getResource("template/mybatis").getFile();
		g.generateByAllTable(file);
//		g.generateByTable("g_vip", file);
//		g.generateByTable("sys_variable", file);
	//	g.generateByTable("sys_role",file);
//		g.generateByTable("sys_privilege",file);
		// //自动搜索数据库中的所有表并生成文件,template为模板的根目录

		// 打开文件夹
		Runtime.getRuntime().exec(
				"cmd.exe /c start "
						+ GeneratorProperties.getRequiredProperty("outRoot"));

	}
}
