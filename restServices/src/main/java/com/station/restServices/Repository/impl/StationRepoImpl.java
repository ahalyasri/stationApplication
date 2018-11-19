package com.station.restServices.Repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.station.restServices.Repository.StationRepo;
import com.station.restServices.models.Station;

@Repository
public class StationRepoImpl implements StationRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveStation(Station station) {

		String sql = "insert into  Station (name, hdEnabled, callSign) values (?,?,?)";
		jdbcTemplate.update(sql, new Object[] { station.getName(), station.getHdEnabled(), station.getCallSign() });
	}

	@Override
	public void deleteStation(Station station) {

		String sql = "delete from Station where stationId = ?";
		jdbcTemplate.update(sql, new Object[] { station.getStationId() });
	}

	@Override
	public Station findByStationId(String stationId) {

		String sql = "select * from Station where stationId = ?";

		Station station = jdbcTemplate.queryForObject(sql, new Object[] { stationId }, new StationRowMapper());
		System.out.println("All Employees Details:");

		return station;
	}

	@Override
	public Station findByStationName(String stationName) {

		String sql = "select * from Station where name = ?";

		Station station = jdbcTemplate.queryForObject(sql, new Object[] { stationName }, new StationRowMapper());

		return station;
	}

	private static final class StationRowMapper implements org.springframework.jdbc.core.RowMapper<Station> {

		public Station mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Station station = new Station();
			station.setStationId(resultSet.getString("stationId"));
			station.setName(resultSet.getString("name"));
			station.setHdEnabled(resultSet.getString("hdEnabled"));
			station.setCallSign(resultSet.getString("callSign"));
			return station;
		}

	}

	@Override
	public List<Station> findByHdEnabled(String hdEnabled) {
		String sql = "select * from Station where hdEnabled = ?";

		List<Station> station = jdbcTemplate.query(sql, new Object[] { hdEnabled }, new StationRowMapper());

		return station;
	}

}
