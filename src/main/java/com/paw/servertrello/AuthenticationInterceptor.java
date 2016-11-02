package com.paw.servertrello;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.paw.servertrello.lib.User;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Jakub on 2016-10-26.
 */
public class AuthenticationInterceptor implements Interceptor{
    @Override
    public void destroy() {

    }

    @Override
    public void init() {
        System.out.println("init auth");
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("invocation");
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();

        User user = (User) session.get("user");
        if(user!=null){
            System.out.println(user.getName());
        }else{
            final ActionContext ac = actionInvocation.getInvocationContext();
            HttpServletResponse response = (HttpServletResponse) ac.get(StrutsStatics.HTTP_RESPONSE);
            response.sendError(401);
        }
        return actionInvocation.invoke();
    }
}
