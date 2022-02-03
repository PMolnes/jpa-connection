package ntnu.appdev.jdbcconnection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    public ProjectController() {

    }

    @GetMapping("")
    public List<Project> getProjects() {
        JDBCLogic db = new JDBCLogic();
        return createProjectsFromResultSet(db.showAllProjects());
    }

    private List<Project> createProjectsFromResultSet(ResultSet resultSet) {
        ArrayList<Project> projects = new ArrayList<>();
        try {
            while (resultSet.next()) {
                projects.add(new Project(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }
}