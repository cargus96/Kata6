/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6.Vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import kata6.Modelo.Person;

/**
 *
 * @author Gustavo
 */
public class PersonListReader {    
        public static List<Person> read() throws ClassNotFoundException, SQLException{
            List <Person> listPerson = new ArrayList<>();
            Class.forName("org.sqlite.JDBC");
            Connection conec = DriverManager.getConnection("jdbc:sqlite:KATA.sDB");
            Statement st = conec.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PEOPLE;");
            while (rs.next()){
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                Character genero = rs.getString(3).charAt(0);
                String fecha = rs.getString(4);
                Float weight = rs.getFloat(5);
                String mail = rs.getString(6);
                listPerson.add(new Person(id, nombre, genero, fecha, weight,mail));
            }
            return listPerson;
    }
}
