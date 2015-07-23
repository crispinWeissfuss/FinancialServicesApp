package d.dataAccessObjects.CassandraDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import b.dataTransferObjects.Vehicle;
import d.dataAccessObjects.Dao.VehicleDao;

public class VehicleCassandraDao implements VehicleDao {

	Connection con = null;
	private static final String QUERY_BY_VEHICLE_ID = "SELECT * FROM financialserviceapp.vehicle WHERE vehicle_id = ? ";

	public VehicleCassandraDao(Connection con) {
		this.con = con;
	}

	@Override
	public Vehicle getVehicleById(int VehicleId) throws SQLException {

		ResultSet rs = this.executeQuery(VehicleId);
		return this.mapResultSetToVehicle(rs);

	}

	private ResultSet executeQuery(int VehicleId) throws SQLException {

		PreparedStatement statement = this.con.prepareStatement(QUERY_BY_VEHICLE_ID);
		statement.setInt(1, VehicleId);

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
