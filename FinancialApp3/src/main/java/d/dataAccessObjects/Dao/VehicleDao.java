package d.dataAccessObjects.Dao;

import java.sql.SQLException;

import b.dataTransferObjects.Vehicle;

public interface VehicleDao  {

	Vehicle getVehicleById(int VehicleId)  throws SQLException;

}
