package com.taskflow.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.taskflow.dao.ProjectDAO;
import com.taskflow.model.Project;
import com.taskflow.util.DBConnection;

public class ProjectDAOImpl implements ProjectDAO{

	@Override
	public boolean createProject(Project project) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();

	    if (con == null) {
	        return false;
	    }

	    String sql = """
	            INSERT INTO projects(name, description, owner_id)
	            VALUES (?, ?, ?)
	            """;

	    try {
	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, project.getName());
	        ps.setString(2, project.getDescription());
	        ps.setInt(3, project.getOwnerId());

	        return ps.executeUpdate() > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public List<Project> getProjectsByOwner(int ownerId) {
		// TODO Auto-generated method stub
		List<Project> projects = new ArrayList<>();

	    Connection con = DBConnection.getConnection();

	    if (con == null) {
	        return projects;
	    }

	    String sql = """
	            SELECT * FROM projects
	            WHERE owner_id = ?
	            """;

	    try {
	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setInt(1, ownerId);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	            projects.add(new Project(
	                    rs.getInt("project_id"),
	                    rs.getString("name"),
	                    rs.getString("description"),
	                    rs.getInt("owner_id")
	            ));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return projects;
	}
	@Override
	public int getProjectCountByOwner(int ownerId) {

	    Connection con = DBConnection.getConnection();

	    if (con == null) {
	        return 0;
	    }

	    String sql = """
	            SELECT COUNT(*)
	            FROM projects
	            WHERE owner_id = ?
	            """;

	    try {

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setInt(1, ownerId);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            return rs.getInt(1);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return 0;
	}

}
