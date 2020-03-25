<template>
    <div class="offerHelp d-flex align-center justify-center">
        <v-container class="py-8 d-flex align-center justify-center">
            <v-row>
                <v-col cols="12">
                    <v-container>
                        <h2>Biete Ressourcen</h2>
                        <p>
                            Danke, dass Du Deine Unterstützung anbietest.<br />
                            Im Folgenden hast Du die Möglichkeit die Art Deiner Hilfeleistung genauer zu beschreiben.
                        </p>
                    </v-container>
                    <v-card class="pa-sm-12 pa-3">
                        <transition name="slide-right">
                            <router-view />
                        </transition>
                    </v-card>
                </v-col>
            </v-row>
        </v-container>
    </div>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import ContactForm from '@/views/ContactForm.vue';
import { routeNames } from '@/constants/routeNames';

@Component({
    name: routeNames.OFFER_HELP.MAIN,
    components: { ContactForm },
})
export default class extends Vue {
    private routeNames = routeNames;
}
</script>

<style scoped lang="scss">
.offerHelp {
    min-height: 100%;
    background-color: #e5e5e5;
}
</style>
