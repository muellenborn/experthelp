import { Module, VuexModule, Mutation, Action } from 'vuex-module-decorators';

@Module
export default class UserStore extends VuexModule {
    private offerHelpFormData: any = {
        contactForm: {
            forename: '',
            lastname: '',
            email: '',
            salutation: '',
            phone: '',
            valid: false,
        },
        skillForm: {
            name: '',
            skillsArray: [],
            skills: [],
            dateTo: new Date().toISOString().substr(0, 10),
            dateFrom: new Date().toISOString().substr(0, 10),
            valid: false,
        },
    };

    public get contactForm() {
        return this.offerHelpFormData.contactForm;
    }

    public get skillForm() {
        return this.offerHelpFormData.skillForm;
    }

    @Mutation
    public saveOfferHelp(offerHelpFormData: object) {
        if (offerHelpFormData) {
            this.offerHelpFormData = offerHelpFormData;
        }
    }

    @Action({ commit: 'saveOfferHelp' })
    public setOfferHelp(payload: object) {
        return payload;
    }
}
