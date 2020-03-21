package org.wirvscvirus.expertexchange.service.srv;

import org.springframework.stereotype.Service;
import org.wirvscvirus.expertexchange.service.model.KnowhowCategory;
import org.wirvscvirus.expertexchange.service.repositories.KnowHowCategoryRepository;

import java.util.List;

@Service
public class MetadataService {

    private final KnowHowCategoryRepository knowhowCategoryRepository;

    public MetadataService(KnowHowCategoryRepository knowhowCategoryRepository) {
        this.knowhowCategoryRepository = knowhowCategoryRepository;
    }

    public List<KnowhowCategory> getKnowHowCategories() {
        return knowhowCategoryRepository.findAll();
    }

}
