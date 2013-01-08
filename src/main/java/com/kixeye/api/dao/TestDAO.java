package com.kixeye.api.dao;


import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;

public interface TestDAO {
    @SqlQuery("select  name from test.sample_table")
    String findNameById(@Bind("id") int id);
}
