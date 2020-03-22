package org.wirvsvirus.expertexchange.service.srv;

import org.wirvsvirus.expertexchange.service.model.KnowhowCategory;

import java.util.List;

public interface IMetadataService {

    List<KnowhowCategory> findAll();
}
