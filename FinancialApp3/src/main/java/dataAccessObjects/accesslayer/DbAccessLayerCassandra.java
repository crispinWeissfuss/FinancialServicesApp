package dataAccessObjects.accesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import dataAccessObjects.ContractCassandraDao;
import dataAccessObjects.ContractDao;
import dataAccessObjects.UserDao;
import dataAccessObjects.UserDaoCassandra;
import dataTransferObjects.Contract;
import dataTransferObjects.User;

public class DbAccessLayerCassandra implements DbAccessLayer {

	private Connection con = null;
	private UserDao userDao = null;
	private ContractDao contractDao = null;

	public DbAccessLayerCassandra() throws ClassNotFoundException, SQLException {
		Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");
		this.con = DriverManager.getConnection("jdbc:cassandra:http://10.255.1.105:32769");

		this.userDao = new UserDaoCassandra(this.con);
		this.contractDao = new ContractCassandraDao(con);
	}

	@Override
	public User authenticateUser(String username) throws SQLException {

		User user = null;
		user = this.userDao.getUserByName(username);

		return user;
	}

	@Override
	public List<Contract> getContractsByUser(String username) throws SQLException {
		return contractDao.getContractByUsername(username);

	}

}
