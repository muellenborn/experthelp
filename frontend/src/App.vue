<template>
    <v-app class="hackathon">
        <v-app-bar app color="tertiary" prominent elevate-on-scroll>
            <v-container fill-height>
                <v-row fill-height class="d-flex align-center justify-space-between">
                    <v-col cols="12" md="2">
                        <logo-svg class="headerLogo" />
                    </v-col>
                    <v-col cols="0" md="2" class="d-none d-sm-flex" />
                    <v-col cols="0" md="2" class="align-center justify-center d-none d-sm-flex">
                        <v-btn text x-large class="-primary">
                            Wie funktionierts?
                        </v-btn>
                    </v-col>
                    <v-col cols="0" md="2" class="align-center justify-center d-none d-sm-flex">
                        <v-btn text x-large class="mr-2 -primary">
                            Anmelden
                        </v-btn>
                    </v-col>
                    <v-col cols="0" md="2" class="align-center justify-center d-none d-sm-flex">
                        <v-btn color="secondary" depressed x-large>
                            Registrieren
                        </v-btn>
                    </v-col>
                </v-row>
            </v-container>
        </v-app-bar>
        <v-content>
            <router-view />
        </v-content>
        <v-footer>
            <v-container>
                <v-row>
                    <v-col cols="12" md="3" class="footer__col -rightBorder d-flex align-center row">
                        <logo-svg class="footer__logo" />
                    </v-col>
                    <v-col cols="12" md="2">
                        <p class="mb-3"><b>Projektname</b></p>
                        <p class="mb-2"><router-link class="footer__link" :to="{ name: routeNames.TEAM }">Über</router-link></p>
                        <p class="mb-2"><router-link class="footer__link" :to="{ name: routeNames.TEAM }">Team</router-link></p>
                        <p class="mb-2"><a href="mailto:admin@cy-borg.net" class="footer__link">Kontakt</a></p>
                    </v-col>
                    <v-col cols="12" md="2">
                        <p class="mb-3"><b>Unterstützer</b></p>
                        <p class="mb-2">Als Unternehmen</p>
                        <p class="mb-2">Als Fachkraft</p>
                        <p class="mb-2">Erfolgsgeschichte</p>
                    </v-col>
                    <v-col cols="12" md="2">
                        <p class="mb-3"><b>Weitere Informationen</b></p>
                        <p class="mb-2">FAQ</p>
                        <p class="mb-2"><router-link class="footer__link" :to="{ name: routeNames.IMPRESS }">Impressum</router-link></p>
                        <p class="mb-2"><router-link class="footer__link" :to="{ name: routeNames.LANDING_PAGE }">Datenschutz</router-link></p>
                    </v-col>
                    <v-col cols="12" md="3" class="text-center">
                        <p class="mb-3"><b>Folge uns auf:</b></p>
                        <v-btn icon>
                            <v-icon>mdi-facebook</v-icon>
                        </v-btn>
                        <v-btn icon>
                            <v-icon>mdi-instagram</v-icon>
                        </v-btn>
                        <v-btn icon>
                            <v-icon>mdi-twitter</v-icon>
                        </v-btn>
                    </v-col>
                </v-row>
            </v-container>
        </v-footer>
        <v-snackbar v-model="snackbar" :multi-line="true" color="info" :timeout="0" bottom>
            <div class="d-flex flex-column justify-center align-center pt-3">
                <h3>Dies ist ein Prototyp!</h3>
                <br />
                <p>Er dient nur zur Veranschaulichung und speichert noch keine Daten!</p>
            </div>
            <v-btn color="white" icon @click="snackbar = false">
                <v-icon>mdi-close</v-icon>
            </v-btn>
        </v-snackbar>
    </v-app>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import { routeNames } from '@/constants/routeNames';
import LogoSvg from '@/components/logoSvg.vue';

@Component({
    name: routeNames.APP,
    components: { LogoSvg },
})
export default class extends Vue {
    private routeNames = routeNames;
    private snackbar = false;

    private mounted() {
        setTimeout(() => {
            this.snackbar = true;
        }, 3000);
    }
}
</script>

<style lang="scss">
@import '../src/scss/variable';
@import '../src/scss/globals';
.headerLogo {
    height: 100px;
    width: auto;
}
.footer {
    &__logo {
        height: 100%;
        width: 100%;
        margin-right: 20px;
    }
    &__link {
        text-decoration: none;
        color: rgba(0, 0, 0, 0.87) !important;
    }
    &__col {
        position: relative;
        &.-rightBorder {
            &::after {
                position: absolute;
                content: '';
                width: 1px;
                height: 115px;
                top: 15px;
                right: 30px;
                background-color: $secondary;
            }
        }
    }
}
</style>
