<template>
    <v-form v-model="contactForm.valid" class="offerHelp__form">
        <h2>Deine Kontaktdaten</h2>
        <v-container>
            <v-row>
                <v-col cols="12" md="4">
                    <v-text-field v-model="contactForm.company" label="Firmenname" outlined hide-details="auto" />
                </v-col>
            </v-row>
            <v-row>
                <v-col cols="12" md="4">
                    <v-text-field v-model="contactForm.street" label="Straße" outlined hide-details="auto" required />
                </v-col>
                <v-col cols="12" md="4">
                    <v-text-field v-model="contactForm.plz" label="PLZ" outlined hide-details="auto" required />
                </v-col>
                <v-col cols="12" md="4">
                    <v-text-field v-model="contactForm.city" label="Ort" outlined hide-details="auto" required />
                </v-col>
            </v-row>
            <v-row class="py-3">
                <h3>Ansprechpartner</h3>
            </v-row>
            <v-row>
                <v-col cols="12" md="4">
                    <v-select v-model="contactForm.salutation" :items="salutation" label="Anrede" outlined hide-details="auto" />
                </v-col>
                <v-col cols="12" md="4">
                    <v-text-field v-model="contactForm.forename" :rules="nameRules" label="Vorname" outlined hide-details="auto" required />
                </v-col>
                <v-col cols="12" md="4">
                    <v-text-field v-model="contactForm.lastname" :rules="nameRules" label="Nachname" outlined hide-details="auto" required />
                </v-col>
            </v-row>
            <v-row>
                <v-col cols="12" md="4">
                    <v-text-field v-model="contactForm.phone" label="Telefonnummer" outlined hide-details="auto" />
                </v-col>
                <v-col cols="12" md="4">
                    <v-text-field v-model="contactForm.email" :rules="emailRules" label="E-mail" outlined hide-details="auto" required />
                </v-col>
            </v-row>
        </v-container>
        <v-row class="justify-end">
            <v-btn :disabled="!contactForm.valid" color="primary" depressed rounded x-large class="ma-2" :to="{ name: routeNames.OFFER_HELP.SKILL_FORM }">
                nächster Schritt<v-icon>mdi-chevron-right</v-icon>
            </v-btn>
        </v-row>
    </v-form>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import { Getter } from 'vuex-class';
import { routeNames } from '@/constants/routeNames';

@Component({
    name: routeNames.OFFER_HELP.CONTACT_FORM,
    components: {},
})
export default class extends Vue {
    @Getter private contactForm!: object;
    private routeNames = routeNames;
    private emailRules = [(v: string) => !!v || 'Eine E-mail wird benötigt', (v: string) => /.+@.+/.test(v) || 'Bitte geben sie eine gültige E-Mail ein'];
    private nameRules = [(v: string) => !!v || 'Ein Name wird benötigt', (v: string) => v.length >= 3 || 'Der Name muss mindestens 3 Zeichen beinhalten'];
    private salutation = ['Herr', 'Frau', 'Divers'];
}
</script>
