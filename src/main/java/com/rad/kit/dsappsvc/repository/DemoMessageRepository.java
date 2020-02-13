package com.rad.kit.dsappsvc.repository;

import com.rad.kit.dsappsvc.entity.DemoMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoMessageRepository extends JpaRepository<DemoMessage, Integer> {
}
