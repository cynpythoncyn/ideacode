package com.sxt.finalServer.user;

import com.sxt.finalServer.core.*;

public class LoginServlet implements ServletInterface {

    @Override
    public void service(RequestTest requestTest, ResponseTest responseTest) {
        System.out.println("Login登陆");
        responseTest.responseTestLn("<html>");
        responseTest.responseTestLn("<head>");
        responseTest.responseTestLn("<meta charset=\"UTF-8\">");
        responseTest.responseTestLn("<title>");
        responseTest.responseTestLn("服务器响应成功");
        responseTest.responseTestLn("</title>");
        responseTest.responseTestLn("</head>");
        responseTest.responseTestLn("<body>");
        responseTest.responseTestLn("数据响应了"+requestTest.getParameter("age"));
        responseTest.responseTestLn("</body>");
        responseTest.responseTestLn("<html>");

    }
}
