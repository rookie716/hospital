package com.oracle.mapper;

import com.oracle.pojo.Admins;
import com.oracle.pojo.Doctors;

public interface AdminsMapper {
    Admins selectAdminsByUsername(String username);
}
