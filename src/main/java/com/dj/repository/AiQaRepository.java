package com.dj.repository;

import com.dj.dto.AiQa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: dj
 * @Date: 2023-02-10 00:02
 * @Description: AI问答持久层
 */
public interface AiQaRepository extends JpaRepository<AiQa, Integer> {
}
