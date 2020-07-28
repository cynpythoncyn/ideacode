package com.sxt.finalServer.user;

import com.sxt.finalServer.core.*;

public class RegisterServlet implements ServletInterface {

    @Override
    public void service(RequestTest requestTest, ResponseTest responseTest) {
        System.out.println("RegisterServlet注册");
        responseTest.responseTestLn("注册成功");
    }
}
