package com.hcsummercamp.fdkdainaclient.Dao;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class BasicDao {
    @Resource
    DSLContext db;
}
