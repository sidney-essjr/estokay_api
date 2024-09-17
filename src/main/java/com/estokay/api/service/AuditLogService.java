package com.estokay.api.service;

import com.estokay.api.entity.AuditLog;
import com.estokay.api.entity.Donor;
import com.estokay.api.entity.Voluntary;
import com.estokay.api.interfaces.Identifiable;
import com.estokay.api.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditLogService<T extends Identifiable> {

    @Autowired
    AuditLogRepository auditLogRepository;

    @Transactional
        public AuditLog save(Voluntary voluntary, T entity, AuditLog.Operation operation) {

        AuditLog auditLog = new AuditLog();
        auditLog.setOperationType(operation);
        auditLog.setOldValue(entity.toString());
        auditLog.setChangedAt(LocalDateTime.now());
        auditLog.setClassId(entity.getId());
        auditLog.setRecordId(voluntary.getId());
        auditLog.setClassName(entity.getClass().getName());

        return auditLogRepository.save(auditLog);
    }

    @Transactional(readOnly = true)
        private List<AuditLog> findByClassName(String className) {
        return auditLogRepository.findAllByClassName(className);
    }

    @Transactional(readOnly = true)
        private List<AuditLog> findByClassNameAndClassId(String className, Long classId) {
        return auditLogRepository.findAllByClassNameAndClassId(className, classId);
    }

}
