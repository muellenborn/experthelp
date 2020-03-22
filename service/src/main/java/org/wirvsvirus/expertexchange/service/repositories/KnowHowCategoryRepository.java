package org.wirvsvirus.expertexchange.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wirvsvirus.expertexchange.service.model.KnowhowCategory;

@Repository
public interface KnowHowCategoryRepository extends JpaRepository<KnowhowCategory, Integer> {

}
