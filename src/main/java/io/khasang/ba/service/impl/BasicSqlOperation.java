package io.khasang.ba.service.impl;

import io.khasang.ba.service.MySqlOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BasicSqlOperation implements MySqlOperation {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getTableCreationStatus() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS cats");

            jdbcTemplate.execute("CREATE TABLE public.cats\n" +
                    "(\n" +
                    "   id integer NOT NULL,\n" +
                    "   name character varying(255) COLLATE pg_catalog.\"default\",\n" +
                    "   description character varying(255) COLLATE pg_catalog.\"default\",\n" +
                    "   color_id integer,\n" +
                    "   CONSTRAINT cats_pkey PRIMARY KEY (id)\n" +
                    ");");

            return "table created";
        } catch (Exception e) {
            return "Table creation failed" + e;
        }
    }

    @Override
    public String getTableInsertStatus() {
        try {
            jdbcTemplate.execute("INSERT INTO cats(id, name, description, color_id) VALUES(1, 'Vasya', 'Hungary', 1);");
            jdbcTemplate.execute("INSERT INTO cats(id, name, description, color_id) VALUES(2, 'Kisa', 'Happy', 1);");
            jdbcTemplate.execute("INSERT INTO cats(id, name, description, color_id) VALUES(3, 'Brodyaga', 'Sweet', 2);");
            jdbcTemplate.execute("INSERT INTO cats(id, name, description, color_id) VALUES(4, 'Lucker', 'Lucker', 3);");

            return "insert into table cats";
        } catch (Exception e) {
            return "insert into table cats failed\n" + e;
        }
    }
}
