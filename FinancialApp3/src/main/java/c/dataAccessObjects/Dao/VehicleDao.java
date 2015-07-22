package c.dataAccessObjects.Dao;

import java.sql.SQLException;

import a.dataTransferObjects.Vehicle;

public interface VehicleDao  {

	Vehicle getVehicleById(int VehicleId)  throws SQLException;

}
