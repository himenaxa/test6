package pl.test.zadanie3.dao;

import pl.test.zadanie3.model.WorkspaceFile;

import java.util.List;

public interface FileDao {

    void save(WorkspaceFile file);

    WorkspaceFile load (String path);

    List<WorkspaceFile> loadAll();

    public List<WorkspaceFile> loadQuery(String query);
    void cleanUp();
}
