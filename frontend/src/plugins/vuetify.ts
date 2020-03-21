import Vue from 'vue';
import Vuetify from 'vuetify/lib';

Vue.use(Vuetify);

export default new Vuetify({
    theme: {
        themes: {
            light: {
                primary: '#69F0AE',
                secondary: '#808080',
                tertiary: '#FFF',
            },
        },
    },
});
