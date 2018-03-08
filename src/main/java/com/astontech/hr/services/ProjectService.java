package com.astontech.hr.services;

import com.astontech.hr.domain.Project;

public interface ProjectService {

    Iterable<Project> listAllProjects();

    Project getProjectById(Integer id);

    Project saveProject(Project project);

    Iterable<Project> saveProjectIterable(Iterable<Project> projectIterable);

    void deleteProject(Integer id);

}
