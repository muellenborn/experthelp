import Vue from 'vue';
import App from './App.vue';
import './registerServiceWorker';
import router from './router';
import store from './store';
import vuetify from './plugins/vuetify';
import * as VueGoogleMaps from 'vue2-google-maps';
import { init } from '@/globals/setup';

init.then(() => {
    Vue.config.productionTip = false;

    Vue.use(VueGoogleMaps, {
        load: {
            key: 'AIzaSyCmc9RFdFJGMNh_COtjp941dxrdBQ0fcck',
            libraries: 'places', // This is required if you use the Autocomplete plugin
            // OR: libraries: 'places,drawing'
            // OR: libraries: 'places,drawing,visualization'
            // (as you require)

            //// If you want to set the version, you can do so:
            // v: '3.26',
        },

        //// If you intend to programmatically custom event listener code
        //// (e.g. `this.$refs.gmap.$on('zoom_changed', someFunc)`)
        //// instead of going through Vue templates (e.g. `<GmapMap @zoom_changed="someFunc">`)
        //// you might need to turn this on.
        // autobindAllEvents: false,

        //// If you want to manually install components, e.g.
        //// import {GmapMarker} from 'vue2-google-maps/src/components/marker'
        //// Vue.component('GmapMarker', GmapMarker)
        //// then set installComponents to 'false'.
        //// If you want to automatically install all the components this property must be set to 'true':
        installComponents: true,
    });

    new Vue({
        router,
        store,
        vuetify,
        render: (h) => h(App),
    }).$mount('#app');
});
