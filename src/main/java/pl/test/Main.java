package pl.test;

import pl.test.zadanie2.PowerOfN;
import pl.test.zadanie3.dao.FileDaoImpl;
import pl.test.zadanie3.service.Exercise3Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test6?useSSL=false&serverTimezone=UTC",
                "root",
                "root"
        );

    PowerOfN pofn = new PowerOfN(conn);

        System.out.println(pofn.getPowerOfN(25));



        Exercise3Service e3s = new Exercise3Service( new FileDaoImpl());

        File file = new File("C:\\Users\\User\\IdeaProjects");
        System.out.println(file.getPath());
        e3s.searchFiles(file);
        LocalDateTime lastTime = LocalDateTime.of(2022, 9, 1, 12,34);
        System.out.println(e3s.getLastModifiedFile().getFileName());
        System.out.println(e3s.countLastModifiedFiles(lastTime.toInstant(ZoneOffset.UTC)));
    }







}