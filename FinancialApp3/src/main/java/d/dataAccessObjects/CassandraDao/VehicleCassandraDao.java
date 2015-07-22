package d.dataAccessObjects.CassandraDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import b.dataTransferObjects.Vehicle;
import d.dataAccessObjects.Dao.VehicleDao;

public class VehicleCassandraDao implements VehicleDao {

	Connection con = null;
	private static final String QUERY = "SELECT * FROM financialserviceapp.vehicle WHERE vehicle_id = ";

	public VehicleCassandraDao(Connection con) {
		this.con = con;
	}

	@Override
	public Vehicle getVehicleById(int VehicleId) throws SQLException {

		ResultSet rs = this.executeQuery(VehicleId);
		return this.mapResultSetToVehicle(rs);

	}

	private ResultSet executeQuery(int VehicleId) throws SQLException {
		String detailedQuery = QUERY + VehicleId;
		System.out.println(detailedQuery);

		PreparedStatement statement = this.con.prepareStatement(detailedQuery);

		ResultSet rs = statement.executeQuery();
		return rs;

	}

	private Vehicle mapResultSetToVehicle(ResultSet rs) throws SQLException {

		Vehicle vehicle = new Vehicle();

		vehicle.setVehicleId(rs.getInt("vehicle_id"));
		vehicle.setDescription(rs.getString("description"));

		return vehicle;
	}

}
