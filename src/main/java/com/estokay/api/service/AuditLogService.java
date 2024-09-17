package com.estokay.api.service;

import com.estokay.api.entity.AuditLog;
import com.estokay.api.entity.Donor;
import com.estokay.api.entity.Voluntary;
import com.estokay.api.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuditLogService {

    @Autowired
    AuditLogRepository auditLogRepository;

    @Transactional
        public AuditLog save(Voluntary voluntary, Donor donor) {
        return null;
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
