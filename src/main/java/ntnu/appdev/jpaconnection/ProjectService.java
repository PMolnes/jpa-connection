package ntnu.appdev.jpaconnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public String createProject(Project project) {
        try {
            if (!projectRepository.existsById(project.getProjectID())) {
                projectRepository.save(project);
                return "Project inserted";
            } else {
                return "Project already exists in DB.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Project> readProjects() {
        return projectRepository.findAll();
    }
}
