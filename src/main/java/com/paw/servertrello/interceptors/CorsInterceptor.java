package com.paw.servertrello.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Jakub on 2016-11-12.
 */
public class CorsInterceptor implements Interceptor{

	private static final long serialVersionUID = 1L;

	@Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        final ActionContext ac = actionInvocation.getInvocationContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(StrutsStatics.HTTP_RESPONSE);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia");

        return  actionInvocation.invoke();
    }
}
