package dataAccessObjects.accesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import dataAccessObjects.UserDao;
import dataAccessObjects.UserDaoCassandra;
import dataTransferObjects.Contract;
import dataTransferObjects.User;

public class DbAccessLayerCassandra implements DbAccessLayer {

	Connection con = null;
	UserDao userDao = null;

	public DbAccessLayerCassandra() throws ClassNotFoundException, SQLException {
		Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");
		this.con = DriverManager.getConnection("jdbc:cassandra://host1--host2--host3:9160/keyspace1?primarydc=DC1&backupdc=DC2&consistency=QUORUM");

		this.userDao = new UserDaoCassandra(this.con);

	}

	@Override
	public User authenticateUser(String username) throws ClassNotFoundException, SQLException {

		User user = null;
		user = this.userDao.getUserByName(username);

		return user;
	}

	@Override
	public List<Contract> getContractsByUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
