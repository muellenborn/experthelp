package org.wirvscvirus.expertexchange.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.wirvscvirus.expertexchange.service.srv.MetadataService;

@Configuration
public class ExpertExchangeServiceConfiguration {
    @Autowired
    public MetadataService metadataService;

}
