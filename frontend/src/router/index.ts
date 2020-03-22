import Vue from 'vue';
import VueRouter from 'vue-router';
import Landingpage from '../views/Landingpage.vue';
import OfferHelp from '../views/OfferHelp.vue';
import { RouteNames } from '@/constants/routeNames.enum';

Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        name: RouteNames.Landingpage,
        component: Landingpage,
    },
    {
        path: '/offerHelp',
        name: RouteNames.OfferHelp,
        component: OfferHelp,
    },
];

const router = new VueRouter({
    routes,
});

export default router;
