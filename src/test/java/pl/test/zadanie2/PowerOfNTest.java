package pl.test.zadanie2;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class PowerOfNTest {
    private PowerOfN powerOfN;
    private Statement statement;


    @Before
    public void init() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test6?useSSL=false&serverTimezone=UTC",
                "root",
                "root"
        );
        statement = conn.createStatement();
        powerOfN = new PowerOfN(statement);
    }

    @Test
    public void shouldBeEqualsWhenPowerNIsCalculated() throws SQLException {
        assertEquals(powerOfN.getPowerOfN(6), BigInteger.valueOf(720));
        statement.execute("delete from power_n where n = 6");
    }

    @Test
    public void shouldBeEqualsWhenPowerNIsTakenFromTable() throws SQLException {
        powerOfN.getPowerOfN(6);
        assertEquals(powerOfN.getPowerOfN(6), BigInteger.valueOf(720));
        statement.execute("delete from power_n where n = 6");
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