package com.taskflow.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.taskflow.dao.TaskDAO;
import com.taskflow.model.Priority;
import com.taskflow.model.Status;
import com.taskflow.model.Task;
import com.taskflow.util.DBConnection;

public class TaskDAOImpl implements TaskDAO{

	@Override
	public boolean createTask(Task task) {

		Connection con = DBConnection.getConnection();
		if(con==null) {
			return false;
		}
		String sql ="INSERT INTO tasks(title, description, status, priority, due_date, assigned_to, project_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, task.getTitle());
			ps.setString(2, task.getDescription());
			ps.setString(3, task.getStatus().name());
			ps.setString(4, task.getPriority().name());
			ps.setDate(5, Date.valueOf(task.getDueDate()));
			ps.setInt(6, task.getAssignedTo());
			ps.setInt(7, task.getProjectId());
			
			return ps.executeUpdate()>0;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Task> getTasksByProject(int projectId, int ownerId) {
		List<Task> tasks = new ArrayList<>();

	    Connection con = DBConnection.getConnection();

	    if (con == null) {
	        return tasks;
	    }

	    String sql = """
	            SELECT t.*
	    		FROM tasks t
	    		JOIN projects p
	    			ON t.project_id = p.project_id
	    		WHERE t.project_id = ?
	    		AND p.owner_id = ?;
	            """;

	    try {

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setInt(1, projectId);
	        ps.setInt(2, ownerId);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	            tasks.add(new Task(
	                    rs.getInt("task_id"),
	                    rs.getString("title"),
	                    rs.getString("description"),
	                    Status.valueOf(rs.getString("status")),
	                    Priority.valueOf(rs.getString("priority")),
	                    rs.getDate("due_date").toLocalDate(),
	                    rs.getInt("assigned_to"),
	                    rs.getInt("project_id")
	            ));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return tasks;
	}

	@Override
	public boolean updateTaskStatus(int taskId, Status status) {

	    Connection con = DBConnection.getConnection();

	    if (con == null) {
	        return false;
	    }

	    String sql = """
	    		UPDATE tasks t
	    		JOIN projects p
	    		    ON t.project_id = p.project_id
	    		SET t.status = ?
	    		WHERE t.task_id = ?
	    		AND p.owner_id = ?
	    		""";

	    try {
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, status.name());
	        ps.setInt(2, taskId);
	        return ps.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	@Override
	public int getTotalTasksByUser(int userId) {

	    Connection con = DBConnection.getConnection();

	    if (con == null) {
	        return 0;
	    }

	    String sql = """
	            SELECT COUNT(*)
	            FROM tasks
	            WHERE assigned_to = ?
	            """;

	    try {

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setInt(1, userId);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            return rs.getInt(1);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return 0;
	}
	
	@Override
	public int countTasksByStatus(int userId,
	                              Status status) {

	    Connection con = DBConnection.getConnection();

	    if (con == null) {
	        return 0;
	    }

	    String sql = """
	            SELECT COUNT(*)
	            FROM tasks
	            WHERE assigned_to = ?
	            AND status = ?
	            """;

	    try {

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setInt(1, userId);

	        ps.setString(2, status.name());

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
