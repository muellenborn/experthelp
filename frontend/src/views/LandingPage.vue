<template>
    <div class="landingPage">
        <div class="landingPage__row -first -tertiary secondary">
            <v-container class="py-8">
                <v-row>
                    <v-col cols="12" md="8">
                        <h1 class="py-3">
                            Unternehmen helfen Unternehmen
                        </h1>
                        <p class="py-3">
                            Wir vernetzen Firmen, die jetzt kurzfristig freie Kapazitäten an Mitarbeitern oder Maschinen haben mit Institutionen, die diese dringend benötigen.
                        </p>
                        <b class="py-3">
                            Für Dich. Für Uns. Für Deutschland.
                        </b>
                        <div class="py-8">
                            <v-btn class="mr-8 -primary" color="secondary" depressed x-large>
                                Ich benötige Ressourcen
                            </v-btn>
                            <v-btn color="secondary" depressed x-large outlined :to="{ name: routeNames.OFFER_HELP.CONTACT_FORM }">
                                Ich biete Ressourcen
                            </v-btn>
                        </div>
                    </v-col>
                    <v-col cols="12" md="4" class="d-flex align-center justify-center">
                        <apply-svg />
                    </v-col>
                </v-row>
            </v-container>
        </div>
        <div class="landingPage__row -second">
            <v-container class="py-8">
                <v-row class="justify-center">
                    <v-col cols="12" md="5">
                        <landingPage-card :data="card1" />
                    </v-col>
                    <v-col cols="12" md="5">
                        <landingPage-card :data="card2" />
                    </v-col>
                </v-row>
            </v-container>
        </div>
        <div class="landingPage__row -third d-flex justify-center align-center">
            <v-container class="py-8">
                <v-img src="/img/slider1.png" contain />
            </v-container>
        </div>
        <div class="landingPage__row -fourth">
            <v-container class="py-8">
                <v-row class="d-flex justify-center -primary py-6">
                    <h2>Oft gestellte Fragen</h2>
                </v-row>
                <v-row class="justify-center">
                    <v-col v-for="(faqEntry, index) in faqArr" :key="index" cols="12" md="12">
                        <v-card class="mx-auto px-6 py-3" outlined>
                            <h3 v-if="faqEntry.headline" class="pt-3 -primary">
                                {{ faqEntry.headline }}
                            </h3>
                            <p class="pt-3">
                                {{ faqEntry.text }}
                            </p>
                        </v-card>
                    </v-col>
                </v-row>
                <v-row class="d-flex justify-center -secondary pt-12">
                    <h3>Noch Fragen?</h3>
                </v-row>
                <v-row class="d-flex justify-center -secondary  py-6">
                    <v-btn class="mr-8 -primary" color="secondary" depressed x-large>
                        FAQ lesen
                    </v-btn>
                    <v-btn color="secondary" depressed x-large outlined>
                        Kontaktier uns
                    </v-btn>
                </v-row>
            </v-container>
        </div>
    </div>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import LandingPageCard from '@/components/landingPageCard.vue';
import { routeNames } from '@/constants/routeNames';
import ApplySvg from '@/components/applySvg.vue';

@Component({
    name: routeNames.LANDING_PAGE,
    components: { ApplySvg, LandingPageCard },
})
export default class extends Vue {
    private routeNames = routeNames;
    private card1 = {
        svg: 'company',
        headline: 'Als Unternehmen',
        texts: [
            'Mitarbeiter werden für sinnvolle Arbeiten eingesetzt und ungenutzte Maschinenkapazität wird bereitgestellt. Als Unternehmen hast Du die Möglichkeit Umsätze zu generieren und laufende Kosten zu decken.',
            'Zudem leistest Du soziales Engagement, wo es am dringendsten benötigt wird.\n',
        ],
    };

    private card2 = {
        svg: 'worker',
        headline: 'Als Fachkraft',
        texts: [
            'In schweren Zeiten hast Du mit unserem Produkt die Möglichkeit mit vielen suchenden Unternehmen in Kontakt zu treten.',
            'So kannst Du von Deinem Know-how Gebrauch machen um auch in Zeiten von Arbeitslosigkeit oder Kurzarbeit liquide zu bleiben',
        ],
    };

    private faqArr = [
        {
            headline: 'Sind die Gesuche und Angebote immer aktuell?',
            text:
                'Bei jedem Eintrag siehst Du direkt wann es erstellt und wann es zuletzt geändert wurde. Die meisten unserer Nutzer reagieren untertags innerhalb von zwei Stunden. Gesuche, die 48 Stunden nicht aktualisiert wurden, werden entsprechend markiert und der Ersteller per Mail informiert.',
        },
        {
            headline: 'Wie schnell können die Fachkräfte bei mir sein?',
            text:
                'Die meisten Anbieter, egal ob Unternehmen oder Fachkraft, haben sofortige Verfügbarkeit, das heißt sobald ihr euch über die Voraussetzungen, wie Maschine, Ort, Haftung und gegebenenfalls Vergütung einig seid, könnt ihr loslegen. Erfahrungsgemäß geht das innerhalb weniger Stunden nach der ersten Kontaktaufnahme.',
        },
        {
            headline: 'Was kostet mich das?',
            text:
                'Unsere Plattform wird als gemeinnützige Plattform betrieben und finanziert sich bisher aus Spenden. Die Vermittlung selbst ist komplett kostenfrei. Für die in Anspruch genommenen Facharbeiten liegt es an Anbieter und Suchendem eine für beide Seiten faire Lösung zu finden. Tipp von uns: Das muss nicht immer Geld sein! ',
        },
    ];
}
</script>

<style scoped lang="scss">
.landingPage {
    &__row {
        &.-first {
            align-items: center;
            display: flex;
            justify-content: space-between;
            width: 100%;
            font-size: $textBig;
            background: transparent linear-gradient(160deg, #4ecdc4 0%, #69f0ae 100%) 0% 0% no-repeat padding-box;
        }

        &.-third {
            background-color: #e5e5e5;
            height: 500px;
        }
    }
}
</style>
