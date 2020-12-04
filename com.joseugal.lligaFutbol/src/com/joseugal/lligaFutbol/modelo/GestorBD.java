package com.joseugal.lligaFutbol.modelo;

import java.sql.*;


public class GestorBD {

    private static final String URL = "jdbc:mysql://localhost:3306/lligafutbol?useUnicode=true&";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "e2l2u5jy";



    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection ( URL, USERNAME, PASSWORD );
        } catch (SQLException e) {
            printSQLException ( e );
        }

        return conn;
    }

    public static void printSQLException( SQLException e) {
        e.printStackTrace(System.err);
        System.err.println("SQLState: " + e.getSQLState());
        System.err.println("Error code: " + e.getErrorCode());
        System.err.println("Message: " + e.getMessage());
        Throwable t = e.getCause();
        while (t != null) {
            System.out.println("Cause: " + t);
            t = t.getCause();
        }
    }

    public static void eliminaTablas( Connection con) {
        try (Statement sentencia = con.createStatement()) {
            sentencia.executeUpdate("DROP TABLE IF EXISTS jugadores");
            sentencia.executeUpdate("DROP TABLE IF EXISTS equipos");
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void creaEquipos(Connection con) {
        String creaSQL = "CREATE TABLE IF NOT EXISTS equipos "
                + "(id INTEGER NOT NULL,"
                + "nombre VARCHAR(40) NOT NULL,"
                + "estadio VARCHAR(40) NOT NULL,"
                + "poblacion VARCHAR(40) NOT NULL,"
                + "provincia VARCHAR(40) NOT NULL,"
                + "cod_postal char(5) NOT NULL,"
                + "PRIMARY KEY (id))";
        try (Statement sentencia = con.createStatement()) {
            sentencia.executeUpdate(creaSQL);
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void creaJugadores(Connection con) {
        String creaSQL = "CREATE TABLE IF NOT EXISTS jugadores "
                + "(id INTEGER NOT NULL,"
                + "id_equipo INTEGER NOT NULL,"
                + "nombre VARCHAR(40) NOT NULL,"
                + "dorsal INTEGER NOT NULL,"
                + "edad INTEGER NOT NULL,"
                + "PRIMARY KEY(id),"
                + "FOREIGN KEY (id_equipo) REFERENCES equipos (id))";
        try (Statement sentencia = con.createStatement()) {
            sentencia.executeUpdate(creaSQL);
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void cargaEquipos(Connection con) {
        try (Statement sentencia = con.createStatement()) {
            sentencia.executeUpdate("INSERT INTO equipos VALUES ("
                    + "1,'ESTEPONA','MONSTERROSO','ESTEPONA','MÁLAGA','29680')");
            sentencia.executeUpdate("INSERT INTO equipos VALUES ("
                    + "2,'ALCORCÓN','SANTO DOMINGO','ALCORCÓN','MADRID','28924')");
            sentencia.executeUpdate("INSERT INTO equipos VALUES ("
                    + "3,'PORCUNA','SAN CRISTOBAL','PORCUNA','JAEN','23790')");
            // Si el ID fuese autoincremental:
            // INSERT INTO equipos ('nombre', 'estadio', ... ) VALUES('ESTEPONA', 'MONSTERROSO', ...)

        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void cargaJugadores(Connection con) {
        try (Statement sentencia = con.createStatement()) {
            // ESTEPONA
            sentencia.executeUpdate("INSERT INTO jugadores VALUES ("
                    + "1,1,'JOSE ANTONIO',1,42)");
            sentencia.executeUpdate("INSERT INTO jugadores VALUES ("
                    + "2,1,'IGNACIO',2,62)");
            sentencia.executeUpdate("INSERT INTO jugadores VALUES ("
                    + "3,1,'DIEGO',3,20)");
            //ALCORCON
            sentencia.executeUpdate("INSERT INTO jugadores VALUES ("
                    + "4,2,'TURRIÓN',1,37)");
            sentencia.executeUpdate("INSERT INTO jugadores VALUES ("
                    + "5,2,'LUIS ABEL',2,37)");
            sentencia.executeUpdate("INSERT INTO jugadores VALUES ("
                    + "6,2,'ISAAC',3,40)");
            //PORCUNA
            sentencia.executeUpdate("INSERT INTO jugadores VALUES ("
                    + "7,3,'JUAN FRANCISCO',1,33)");
            sentencia.executeUpdate("INSERT INTO jugadores VALUES ("
                    + "8,3,'PARRA',2,37)");
            sentencia.executeUpdate("INSERT INTO jugadores VALUES ("
                    + "9,3,'RAUL',3,19)");
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void verEquipos(Connection con) {
        try (Statement sentencia = con.createStatement()) {
            sentencia.executeQuery("SELECT * FROM equipos");
            ResultSet rs = sentencia.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i < rsmd.getColumnCount(); i++) {
                if (i > 1) {
                    System.out.print(" | ");
                }
                System.out.print(rsmd.getColumnLabel(i));
            }
            System.out.println("");

            while (rs.next()) {
                for (int i = 1; i < rsmd.getColumnCount(); i++) {
                    if (i > 1) {
                        System.out.print(" | ");
                    }
                    System.out.print(rs.getString(i));
                }
                System.out.println("");
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
    }



}
