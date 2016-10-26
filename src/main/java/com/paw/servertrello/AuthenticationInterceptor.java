package com.paw.servertrello;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

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

        for (Map.Entry<String, Object> stringObjectEntry : session.entrySet()) {
            System.out.println(stringObjectEntry.getKey());
            System.out.println(stringObjectEntry.getValue().toString());
        }
        return actionInvocation.invoke();
    }
}
