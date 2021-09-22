package com.finki.emt.adcatalog.domain.repository;

import com.finki.emt.adcatalog.domain.models.Ad;
import com.finki.emt.adcatalog.domain.models.AdId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, AdId> {
}
