package pl.test.zadanie2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.*;

import static org.junit.Assert.*;

public class PowerOfNTest {

    private PowerOfN pofn;
    @Mock
    private Connection conn;

    @Mock
    private Statement statement;

    @Mock
    private ResultSet resultSet;

    @Before
    public void init() throws SQLException {
        MockitoAnnotations.openMocks(this);
        pofn = new PowerOfN(conn);
    }

    @Test
    public void shouldBeOK() throws SQLException {
        Mockito.when(resultSet.next()).thenReturn(false);
        Mockito.when(statement.executeQuery("SELECT name FROM tables")).thenReturn(resultSet);
        Mockito.when(conn.createStatement()).thenReturn(statement);

        assertEquals(pofn.getPowerOfN(2), 2);
    }
}

/*
ResultSet resultSet = Mockito.mock(ResultSet.class);
Mockito.when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
Mockito.when(resultSet.getString(1)).thenReturn("table_r3").thenReturn("table_r1").thenReturn("table_r2");

Statement statement = Mockito.mock(Statement.class);
Mockito.when(statement.executeQuery("SELECT name FROM tables")).thenReturn(resultSet);

Connection jdbcConnection = Mockito.mock(Connection.class);
Mockito.when(jdbcConnection.createStatement()).thenReturn(statement);
 */