package pl.test.zadanie3.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pl.test.zadanie3.dao.FileDaoImpl;
import pl.test.zadanie3.exceptions.SearchedFileIsNotExistException;
import pl.test.zadanie3.model.WorkspaceFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Exercise3ServiceTest {

    private Exercise3Service exercise3Service;

    @Mock
    private FileDaoImpl fileDaoImplMock;

    @Mock
    private File fileMock;

    private final LocalDateTime lastTime1 = LocalDateTime.of(2022, 1, 1, 12, 34);
    private final LocalDateTime lastTime2 = LocalDateTime.of(2022, 2, 1, 12, 34);
    private final LocalDateTime lastTime3 = LocalDateTime.of(2022, 3, 1, 12, 34);
    private final WorkspaceFile w1 = new WorkspaceFile("Dupa.java", "..\\Dupa\\src\\main\\java\\pl\\kurs\\Dupa.java", 122, lastTime1.toInstant(ZoneOffset.UTC), lastTime2.toInstant(ZoneOffset.UTC));
    private final WorkspaceFile w2 = new WorkspaceFile("Dupa.java", "..\\Dupa\\src\\main\\java\\pl\\kurs\\Dupa.java", 122, lastTime2.toInstant(ZoneOffset.UTC), lastTime3.toInstant(ZoneOffset.UTC));


    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        exercise3Service = new Exercise3Service(fileDaoImplMock);

    }

    @Test
    public void shouldSaveNewObjectToDataBase() throws IOException {
        File file = new File(".");
        exercise3Service.searchFiles(file);
        verify(fileDaoImplMock, Mockito.atLeastOnce()).save(any(WorkspaceFile.class));
    }

    @Test(expected = SearchedFileIsNotExistException.class)
    public void shouldThrowSearchedFileIsNotExistException() throws IOException {
        when(fileMock.exists()).thenReturn(false);
        exercise3Service.searchFiles(fileMock);
    }

    @Test
    public void shouldReturnLastModifiedFile() {
        assertEquals(w2, exercise3Service.getLastModifiedFile(Arrays.asList(w1, w2)));
    }

    @Test
    public void shouldReturnCountLastModifiedFiles() {
        assertEquals(1, exercise3Service.countLastModifiedFiles(Arrays.asList(w1, w2), lastTime2.toInstant(ZoneOffset.UTC)));
    }

}