package com.pajk.testchen;

import com.pajk.Annotation.TbField;
import com.pajk.Annotation.TbTable;

/**
 * @author chenyanan
 * @Date 2021/1/10
 */
@TbTable(value = "tb_user")
public class TbUser {
    @TbField(columnName = "username",type = "varchar",length = 20)
    private String username ;
    @TbField(columnName = "password",type = "varchar",length = 20)
    private String  password;
    @TbField(columnName = "phone",type = "varchar",length = 20)
    private String phone;
    @TbField(columnName = "email",type = "varchar",length = 20)
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
