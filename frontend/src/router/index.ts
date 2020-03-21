import Vue from 'vue';
import VueRouter from 'vue-router';
import Landingpage from '../views/Landingpage.vue';

Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        name: 'Landingpage',
        component: Landingpage,
    },
];

const router = new VueRouter({
    routes,
});

export default router;
