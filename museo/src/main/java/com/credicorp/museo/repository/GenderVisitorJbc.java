package com.credicorp.museo.repository;

import com.credicorp.museo.entities.VisitorTotalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class GenderVisitorJbc implements RowMapper<VisitorTotalEntity> {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public List<VisitorTotalEntity> getTotalVisitor(){
        String cmdSQL= "select concat(genderCount, gender) as gender" +
                "  from (select count(a.gender) genderCount" +
                "             , a.gender, a.storage_date" +
                "          from t_gender_visitor as a" +
                "         where a.gender = 'W'" +
                "         group by a.storage_date" +
                "        union" +
                "        select count(b.gender) genderCount" +
                "             , b.gender , b.storage_date" +
                "          from t_gender_visitor as b" +
                "         where b.gender = 'M'" +
                "         group by b.storage_date" +
                "        union" +
                "        select count(c.gender) genderCount" +
                "             , c.gender, c.storage_date" +
                "          from t_gender_visitor as c" +
                "         where c.gender = 'C' " +
                "         group by c.storage_date) as t" +
                "         where t.storage_date = '" + LocalDate.now() +
        "'" +
                " order by t.genderCount desc;";

        return jdbcTemplate.query(cmdSQL,this::mapRow);
    }

    public VisitorTotalEntity mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new VisitorTotalEntity(
                rs.getString("gender")
        );
    }

}
