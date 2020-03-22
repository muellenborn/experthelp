<template>
    <div class="thankYou d-flex align-center justify-center">
        <v-container class="py-8 d-flex align-center justify-center">
            <v-row>
                <v-col cols="12">
                    <v-row class="d-flex flex-column justify-center">
                        <h1 class="d-flex justify-center">Vielen Dank!</h1>
                        <p class="d-flex justify-center">
                            Dein Inserat wurde gespeichert und Dein Unternehmen ist jetzt Teil unserer Community!<br />
                            Fang doch jetzt schon an bei uns auf der Karte nach geeigneten Inseraten zu suchen.
                        </p>
                    </v-row>
                    <v-row class="d-flex flex-column justify-center py-12">
                        <thank-you-svg />
                    </v-row>
                    <v-row class="justify-center">
                        <v-btn color="secondary" depressed rounded x-large class="ma-2" :to="{ name: routeNames.LANDING_PAGE }">
                            <v-icon>mdi-map</v-icon>
                            Karte anzeigen
                        </v-btn>
                    </v-row>
                </v-col>
            </v-row>
        </v-container>
    </div>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import { routeNames } from '@/constants/routeNames';
import ThankYouSvg from '@/components/thankYouSvg.vue';

@Component({
    name: routeNames.THANK_YOU,
    components: { ThankYouSvg },
})
export default class extends Vue {
    private routeNames = routeNames;
}
</script>

<style scoped lang="scss">
.thankYou {
    min-height: 100%;
    background-color: #e5e5e5;
}
</style>
