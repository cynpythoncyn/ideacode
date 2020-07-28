package com.sxt.finalServer.user;

import com.sxt.finalServer.core.*;

public class OthersServlet implements ServletInterface {

    @Override
    public void service(RequestTest requestTest, ResponseTest responseTest) {

        responseTest.responseTestLn("<html>");
        responseTest.responseTestLn("<head>");
        responseTest.responseTestLn("<meta charset=\"UTF-8\">");
        responseTest.responseTestLn("<title>");
        responseTest.responseTestLn("服务器响应成功");
        responseTest.responseTestLn("</title>");
        responseTest.responseTestLn("</head>");
        responseTest.responseTestLn("<body>");
        responseTest.responseTestLn("其它页面");
        responseTest.responseTestLn("</body>");
        responseTest.responseTestLn("<html>");
    }
}
