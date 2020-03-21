package org.wirvscvirus.expertexchange.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wirvscvirus.expertexchange.service.model.KnowhowCategory;

import java.util.List;

public interface KnowHowCategoryRepository extends JpaRepository<KnowhowCategory, Long> {

    List<KnowhowCategory> findByKnowHow(String knowhow);
    List<KnowhowCategory> findByKnowHowSub(String knowhowSub);
    List<KnowhowCategory> findById(int knowhowId);


}
