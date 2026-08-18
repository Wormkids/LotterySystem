package com.xzj.lotterysystem.dao.hander;


import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.xzj.lotterysystem.dao.dataobject.Encryppt;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Encryppt.class)        //被处理的类型
@MappedJdbcTypes(JdbcType.VARCHAR)  //转换后的jdbc类型
public class EncryptTypeHander implements TypeHandler<Encryppt> {

    //密钥
    private final byte[] key = "1234567890123456".getBytes();

    /**
     * 存入
     * @param ps    预编译对象
     * @param i 位置
     * @param parameter 在i位置的参数
     * @param jdbcType  数据库类型
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement ps, int i, Encryppt parameter, JdbcType jdbcType) throws SQLException {
        if(parameter == null || parameter.getValue() == null)
        {
            ps.setString(i,null);
            return;
        }
        AES aes = SecureUtil.aes(key);
        String s = aes.encryptHex(parameter.getValue());
        ps.setString(i,s);
    }

    /**
     * 取出值
     * @param rs  结果集
     * @param columnName   索引
     * @return
     * @throws SQLException
     */
    @Override
    public Encryppt getResult(ResultSet rs, String columnName) throws SQLException {
        return decrypt(rs.getString(columnName));
    }

    @Override
    public Encryppt getResult(ResultSet rs, int columnIndex) throws SQLException {
        return decrypt(rs.getString(columnIndex));
    }

    @Override
    public Encryppt getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return decrypt(cs.getString(columnIndex));
    }

    private Encryppt decrypt(String string)
    {
        AES aes = SecureUtil.aes(key);
        return new Encryppt(aes.decryptStr(string));
    }
}
