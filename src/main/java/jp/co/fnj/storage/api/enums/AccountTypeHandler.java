package jp.co.fnj.storage.api.enums;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
//import jp.co.fnj.storage.entity.enums.AccountType;

//public class AccountTypeHandler extends BaseTypeHandler<AccountType> {
//
//    @Override
//    public void setNonNullParameter(PreparedStatement ps, int i, AccountType parameter, JdbcType jdbcType) throws SQLException {
//        ps.setString(i, parameter.getCode());
//    }
//
//    @Override
//    public AccountType getNullableResult(ResultSet rs, String columnName) throws SQLException {
//        return AccountType.findByCode(rs.getString(columnName));
//    }
//
//    @Override
//    public AccountType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
//        return AccountType.findByCode(rs.getString(columnIndex));
//    }
//
//    @Override
//    public AccountType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
//        return AccountType.findByCode(cs.getString(columnIndex));
//    }
//
//}
