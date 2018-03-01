package cn.it.shop.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Category;
import cn.it.shop.model.FileImage;
import cn.it.shop.service.AccountService;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ForderService;
import cn.it.shop.service.PayService;
import cn.it.shop.service.ProductService;
import cn.it.shop.service.SorderService;
import cn.it.shop.service.UserService;
import cn.it.shop.util.FileUpload;
import cn.it.shop.util.EamilUtil;
import cn.it.shop.util.MessageUtil;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * Struts执行流程：先创建Action，再调用拦截器，拦截器访问成功过条用Action的方法
 * 
 * (在项目启动时Struts的过滤器，已经把相应的内置对象对应的Map存储到了ActionContext和值栈中)
 * 如果实现了相应的****Aware接口，就会从ActionContext中取得相应的Map进行传入，实现的拦截器为servletConfig
 * @author Administrator
 *
 */

@Controller //不写名字默认是类名中的第一个字母小写 即：baseAction
@Scope("prototype")
public class BaseAction<T> extends ActionSupport  implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T> {

	protected T model;
	
	//获取要删除的id
	protected String ids;
	
	protected Integer page;
	
	protected Integer rows;
	
	protected FileImage fileImage;
	
	protected InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	
	public List<T> getJsonList() {
		return jsonList;
	}

	protected List<T> jsonList=null;
	
	protected Map<String, Object> pageMap=null;
	
	public Map<String, Object> getPageMap() {
		return pageMap;
	}
	@Resource
    protected CategoryService categoryService;
	@Resource
    protected AccountService accountService;
	@Resource
	protected ProductService productService;
	@Resource
	protected ForderService forderService;
	@Resource
	protected SorderService sorderService;
	@Resource
	protected UserService userService;
	@Resource
	protected PayService payService;
	@Resource
	protected FileUpload fileUpload;
	@Resource
	protected EamilUtil emailUtil;
	@Resource
	protected MessageUtil messageUtil;
    
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	
	public T getModel() {
		ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
		Class clazz=(Class)type.getActualTypeArguments()[0];
		try {
			model=(T)clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return model;
	}
	
	
	@Override
	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application=application;
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public FileImage getFileImage() {
		return fileImage;
	}
	public void setFileImage(FileImage fileImage) {
		this.fileImage = fileImage;
	}
	
}
