<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/public/head.jspf" %>
  	<style type="text/css">
  		form div{
  			margin:10px;
  		}
  	</style>
  	<script type="text/javascript">
  		$(function(){
  			//窗体弹出默认时禁用验证
  			$("input[name=type]").validatebox({
  				required:true,
  				missingMessage:'请输入类别名称'
  			});
  			$("#ff").form("disableValidation");
  			//注册button事件
  			$("#btn").click(function(){
  				//开启验证
  				$("#ff").form("enableValidation");
  				if($("#ff").form("validate")){
  					//提交数据
  					$('#ff').form('submit', {
						url:'category_save.action',
						success: function(){
							//关闭当前窗体
							parent.$("#win").window("close");
							//刷新页面 获取aindex--->iframe--->dg    dom--->jquery---easyui
							//不兼容  parent.$("iframe[title='类别管理']").contents().find("#dg").datagrid("getSelections");
							parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg").datagrid("reload");
						}
					});
  					
  				}
  			});
  		});
  	</script>
  </head>
  
  <body>
  	<form id="ff" method="post">   
	    <div>   
	        <label for="type">类别名称:</label>   
	        <input type="text" name="type"/>   
	    </div>   
	    <div>   
	        <label for="hot">热点:</label>   
	                热点：<input type="radio" name="hot" value="true"/>
	                非热点：<input type="radio" name="hot" value="false" checked="checked"/>
	    </div>
	    <div>
	    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
	    </div>    
	</form>  
  </body>
</html>
