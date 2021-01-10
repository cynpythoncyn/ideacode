package mapper;

import pojo.TbUser;

import java.util.List;

/**
 * @author chenyanan
 * @Date 2021/1/9
 */
public interface TbUserMapper {
    TbUser queryById(int id);

    List<TbUser> selectAll();

    void insertUser(TbUser tbUser);

    int updateUser(TbUser tbUser);

}
