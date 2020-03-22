import Vue from 'vue';
import { routeNames } from '@/constants/routeNames';
import VueRouter from 'vue-router';
import LandingPage from '../views/LandingPage.vue';
import OfferHelp from '../views/OfferHelp.vue';
import ContactForm from '../views/ContactForm.vue';
import SkillForm from '../views/SkillForm.vue';
import ThankYou from '@/views/ThankYou.vue';

Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        name: routeNames.LANDING_PAGE,
        component: LandingPage,
    },
    {
        path: '/dankesehr',
        name: routeNames.THANK_YOU,
        component: ThankYou,
    },
    {
        path: '/hilfe-anbieten',
        name: routeNames.OFFER_HELP.MAIN,
        component: OfferHelp,
        children: [
            {
                path: 'kontakt',
                name: routeNames.OFFER_HELP.CONTACT_FORM,
                component: ContactForm,
            },
            {
                path: 'skills',
                name: routeNames.OFFER_HELP.SKILL_FORM,
                component: SkillForm,
            },
        ],
    },
];

const router = new VueRouter({
    routes,
});

export default router;
