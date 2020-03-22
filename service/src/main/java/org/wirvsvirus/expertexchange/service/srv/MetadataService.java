package org.wirvsvirus.expertexchange.service.srv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wirvsvirus.expertexchange.service.model.KnowHow;
import org.wirvsvirus.expertexchange.service.model.KnowhowCategory;
import org.wirvsvirus.expertexchange.service.repositories.KnowHowCategoryRepository;

import java.util.List;

@Service
public class MetadataService implements IMetadataService {

    @Autowired
    private KnowHowCategoryRepository knowhowCategoryRepository;

    public List<KnowhowCategory> findAll() {
        return knowhowCategoryRepository.findAll();
    }

}