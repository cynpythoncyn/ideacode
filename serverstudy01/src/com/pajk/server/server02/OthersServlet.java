package com.pajk.server.server02;

public class OthersServlet implements ServletInterface{

    @Override
    public void service(RequestTest requestTest, ResponseTest responseTest) {
        responseTest.responseTestLn("其它页面");
    }
}
