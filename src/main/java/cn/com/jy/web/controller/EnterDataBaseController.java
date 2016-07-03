package cn.com.jy.web.controller;

import java.lang.reflect.Field;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.jy.web.domain.MyConfig;
import cn.org.rapid_framework.generator.GeneratorMain;
import cn.org.rapid_framework.generator.GeneratorProperties;
import cn.org.rapid_framework.generator.provider.db.DataSourceProvider;

@Controller
public class EnterDataBaseController {

	@RequestMapping("/enterDatabase")
	public String enterDatabase(MyConfig myConfig, HttpSession session)
			throws Exception {
		dealProperties(myConfig);

		session.setAttribute("databasename", GeneratorProperties.getProperty("jdbc.databasename"));
		session.setAttribute("outRoot", GeneratorProperties.getProperty("outRoot"));
		// GeneratorMain.main(null);
		return "redirect:/setting.jsp";
	}

	@ResponseBody
	@RequestMapping("/createFiles")
	public String createFiles(MyConfig myConfig)
			throws Exception {
		dealProperties(myConfig);
		
		GeneratorMain.main(null);
		return "success";
	}
	
	private static void dealProperties(MyConfig myConfig) throws Exception {
		Field[] fields = myConfig.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			Object object = field.get(myConfig);
			if (object == null || "".equals(((String) object).trim())) {
				continue;
			} else {
				if (field.getName().equals("databasename")
						|| field.getName().equals("ip")
						|| field.getName().equals("username")
						|| field.getName().equals("password")) {
					GeneratorProperties.setProperty("jdbc." + field.getName(),
							(String) object);
					if (DataSourceProvider.connection != null) {
						DataSourceProvider.connection.close();
					}
					if (DataSourceProvider.dataSource != null) {
						DataSourceProvider.dataSource = null;
					}
				} else {
					GeneratorProperties.setProperty(field.getName(),
							(String) object);
				}
			}
		}
	}
}
