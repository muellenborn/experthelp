package org.wirvsvirus.expertexchange.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpertOfferDTO {

    private Offerer offerer;
    private List<KnowHowValue> availableKnowHowList;
    private List<RessourceValue> availableRessourceList;

    public Offerer getOfferer() {
        return offerer;
    }

    public void setOfferer(Offerer offerer) {
        this.offerer = offerer;
    }

    public List<KnowHowValue> getAvailableKnowHowList() {
        return availableKnowHowList;
    }

    public void setAvailableKnowHowList(List<KnowHowValue> availableKnowHowList) {
        this.availableKnowHowList = availableKnowHowList;
    }

    public List<RessourceValue> getAvailableRessourceList() {
        return availableRessourceList;
    }

    public void setAvailableRessourceList(List<RessourceValue> availableRessourceList) {
        this.availableRessourceList = availableRessourceList;
    }
}
