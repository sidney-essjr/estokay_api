package com.estokay.api.repository;

import com.estokay.api.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    List<AuditLog> findAllByClassName(String className);

//    @Query("select l from  l where l.class_name = :className and l.class_id = :classId")
//    List<AuditLog> findAllByClassNameAndClassId(@Param("className") String className, @Param("classId") Long classId);
    List<AuditLog> findAllByClassNameAndClassId(String className, Long classId);
}
