import Vue from 'vue';
import Vuex from 'vuex';
import offerHelp from './modules/offerHelp';
import metadata from './modules/metadata';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {},
    mutations: {},
    actions: {},
    modules: {
        offerHelp,
        metadata,
    },
});
