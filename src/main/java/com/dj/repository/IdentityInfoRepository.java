package com.dj.repository;

import com.dj.dto.IdentityInfo;
import com.dj.dto.IdentityInfoKey;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: dj
 * @Date: 2022/9/9 16:51
 * @Description: 身份信息存储
 */
public interface IdentityInfoRepository extends JpaRepository<IdentityInfo, IdentityInfoKey> {
}
