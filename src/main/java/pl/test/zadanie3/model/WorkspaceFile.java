package pl.test.zadanie3.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class WorkspaceFile {

    private String fileName;
    @Id
    private String path;
    private long size;
    private Instant created;
    private Instant lastModified;

    public WorkspaceFile(String fileName, String path, long size, Instant created, Instant lastModified) {
        this.fileName = fileName;
        this.path = path;
        this.size = size;
        this.created = created;
        this.lastModified = lastModified;
    }

    public WorkspaceFile() {
    }

    public String getFileName() {
        return fileName;
    }

    public String getPath() {
        return path;
    }

    public long getSize() {
        return size;
    }

    public Instant getCreated() {
        return created;
    }

    public Instant getLastModified() {
        return lastModified;
    }

    @Override
    public String toString() {
        return "WorkspaceFile{" +
                "fileName='" + fileName + '\'' +
                ", path='" + path + '\'' +
                ", size=" + size +
                ", created=" + created +
                ", lastModified=" + lastModified +
                '}';
    }
}
