package com.zosh.service;

import com.zosh.modal.Chat;
import com.zosh.modal.Project;
import com.zosh.modal.User;

import java.util.List;

public interface ProjectService {
    Project createProject(Project project, User user) throws Exception;

    Project createProject(Project project, Long userId)throws Exception;

    List<Project> getProjectByTeam(User user, String category, String tag)throws Exception;

    Project getProjectById(Long projectId)throws Exception;

    void deleteProject(Long projectId, Long userId)throws Exception;

    Project updateProject(Project updateProjectId, Long id )throws Exception;

    void addUserToProject(Long projectId, Long userId)throws Exception;

    void removeUserFromProject(Long projectId, Long userId)throws Exception;

    Chat getChatByProjectId(Long projectId)throws Exception;


}
