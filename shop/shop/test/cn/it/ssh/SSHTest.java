package cn.it.ssh;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.impl.CategoryServiceImpl;

/**
 * 
 * @author Administrator
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class SSHTest {
	@Resource
	private Date date;
	
	@Resource
	private CategoryService categoryService;
	
	@Test  //测试SpringIOC开发环境
	public void springIoc(){
		System.out.println(date);
	}
	
	@Test  //测试hibernate开发环境,因为没有整合，也可以直接new
	public void hibernate(){
		CategoryService categoryService=new CategoryServiceImpl();
		categoryService.save(new Category("男士休闲", true));
	}
	
	@Test  //测试hibernate和Spring开发环境
	public void hibernateAndSpring(){
		categoryService.update(new Category(2, "女士休闲22", false));
	}
}
