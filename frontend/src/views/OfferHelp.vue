<template>
    <div class="offerHelp d-flex align-center justify-center">
        <v-container class="py-8 d-flex align-center justify-center">
            <v-row>
                <v-col cols="12">
                    <v-card class="pa-12">
                        <h2>Ihre Kontaktdaten</h2>
                        <v-form v-model="valid" class="offerHelp__form">
                            <v-container>
                                <v-row>
                                    <v-col cols="12" md="4">
                                        <v-text-field v-model="formData.company" label="Firmenname" outlined hide-details="auto" />
                                    </v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="12" md="4">
                                        <v-text-field v-model="formData.street" label="Straße" outlined hide-details="auto" required />
                                    </v-col>
                                    <v-col cols="12" md="4">
                                        <v-text-field v-model="formData.plz" label="PLZ" outlined hide-details="auto" required />
                                    </v-col>
                                    <v-col cols="12" md="4">
                                        <v-text-field v-model="formData.city" label="Ort" outlined hide-details="auto" required />
                                    </v-col>
                                </v-row>
                                <v-row>
                                    <h3>Ansprechpartner</h3>
                                </v-row>
                                <v-row>
                                    <v-col cols="12" md="4">
                                        <v-select v-model="formData.salutation" :items="salutation" label="Anrede" outlined hide-details="auto" />
                                    </v-col>
                                    <v-col cols="12" md="4">
                                        <v-text-field v-model="formData.forename" :rules="nameRules" label="Vorname" outlined hide-details="auto" required />
                                    </v-col>
                                    <v-col cols="12" md="4">
                                        <v-text-field v-model="formData.lastname" :rules="nameRules" label="Nachname" outlined hide-details="auto" required />
                                    </v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="12" md="4">
                                        <v-text-field v-model="formData.phone" label="Telefonnummer" outlined hide-details="auto" />
                                    </v-col>
                                    <v-col cols="12" md="4">
                                        <v-text-field v-model="formData.email" :rules="emailRules" label="E-mail" outlined hide-details="auto" required />
                                    </v-col>
                                </v-row>
                            </v-container>
                        </v-form>
                        <v-row class="justify-end">
                            <v-btn color="primary" depressed rounded x-large class="ma-2"> Nächster Schritt<v-icon>mdi-chevron-right</v-icon> </v-btn>
                        </v-row>
                    </v-card>
                </v-col>
            </v-row>
        </v-container>
    </div>
</template>

<script lang="ts">
import Vue from 'vue';
import { Component } from 'vue-property-decorator';
import { RouteNames } from '@/constants/routeNames.enum';

@Component({
    name: RouteNames.OfferHelp,
    components: {},
})
export default class extends Vue {
    private valid = false;
    private formData: object = {
        forename: '',
        lastname: '',
        email: '',
        salutation: '',
        phone: '',
    };
    private emailRules = [(v: string) => !!v || 'E-mail wird benötigt', (v: string) => /.+@.+/.test(v) || 'Bitte geben sie eine gültige E-Mail ein'];
    private nameRules = [(v: string) => !!v || 'Name wird benötigt', (v: string) => v.length <= 10 || 'Der Name muss mindestens 10 Zeichen beinhalten'];
    private salutation = ['Herr', 'Frau', 'Divers'];
}
</script>

<style scoped lang="scss">
.offerHelp {
    min-height: 100%;
    background-color: #e5e5e5;
}
</style>
