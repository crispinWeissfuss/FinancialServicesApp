package d.dataAccessObjects.CassandraDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import b.dataTransferObjects.User;
import d.dataAccessObjects.Dao.UserDao;

public class UserDaoCassandra implements UserDao {

	Connection con = null;
	private static final String QUERY_BY_USERNAME = "SELECT * FROM financialserviceapp.user WHERE username = ? ";

	public UserDaoCassandra(Connection con) {
		this.con = con;
	}

	@Override
	public User getUserByName(String username) throws SQLException {
		ResultSet rs = this.executeQuery(username);
		User user = this.mapResultSetToUser(rs);

		return user;
	}

	private ResultSet executeQuery(String username) throws SQLException {

		PreparedStatement statement = this.con.prepareStatement(QUERY_BY_USERNAME);
		statement.setString(1, username);

		ResultSet rs = statement.executeQuery();
		return rs;

	}

	private User mapResultSetToUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setUsername(rs.getString("username"));
		user.setFirstName(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setPassword(rs.getString("password"));

		return user;
	}

}
