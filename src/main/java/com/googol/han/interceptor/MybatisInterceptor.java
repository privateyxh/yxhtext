package com.googol.han.interceptor;

import java.sql.Connection;
import java.util.Properties;


import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import com.googol.han.util.ReflectHelper;



@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
public class MybatisInterceptor implements Interceptor {
	String dialect;
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("intercept---intercept---intercept");
		RoutingStatementHandler rsh=(RoutingStatementHandler)invocation.getTarget();
		System.out.println("执行的SQL:"+rsh.getBoundSql().getSql());
		BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(rsh, "delegate");
		MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate, "mappedStatement");	
		String id=mappedStatement.getId().toString();
		System.out.println("Mapper.xml执行的id:"+id);
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object arg0) {
		return Plugin.wrap(arg0,this);
	}

	@Override
	public void setProperties(Properties arg0) {
		dialect=arg0.get("dialect").toString();
		System.out.println("dialect:"+dialect);
	}
	
}