package pojo;

import java.text.MessageFormat;
import java.sql.Date;

/**
 * @author chenyanan
 * @Date 2021/1/9
 */
public class TbUser {

    private int id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Date created;
    private Date updated;

    public TbUser() {
    }

    public TbUser(int id, String username, String password, String phone, String email, Date created, Date updated) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.created = created;
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
    @Override
    public String toString(){

        String str = MessageFormat.format("user id={0} username={1} phone={2}",id,username,phone);

        return str;
    };


}
