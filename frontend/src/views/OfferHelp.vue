<template>
    <div class="offerHelp d-flex align-center justify-center">
        <v-container class="py-8 d-flex align-center justify-center">
            <v-row>
                <v-col cols="12">
                    <h2>Ich biete</h2>
                    <p>
                        Danke, dass Sie Ihre Unterstützung anbieten.<br />
                        Im folgenden haben Sie die Möglichkeit die Art Ihrer Hilfeleistung genauer zu beschreiben.
                    </p>
                    <v-card class="pa-12">
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
