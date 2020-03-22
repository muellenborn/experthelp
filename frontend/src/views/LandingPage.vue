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
                            <v-btn class="mr-8" color="primary" depressed x-large>
                                Ich benötige Resourcen
                            </v-btn>
                            <v-btn color="primary" depressed x-large outlined :to="{ name: routeNames.OFFER_HELP.CONTACT_FORM }">
                                Ich biete Resourcen
                            </v-btn>
                        </div>
                    </v-col>
                    <v-col cols="12" md="4" class="d-flex align-center justify-center">
                        <svg xmlns="http://www.w3.org/2000/svg" width="400" height="400" viewBox="0 0 400 400">
                            <rect fill="#ddd" width="400" height="400" />
                            <text fill="rgba(0,0,0,0.5)" font-family="sans-serif" font-size="30" dy="10.5" font-weight="bold" x="50%" y="50%" text-anchor="middle">
                                300×400
                            </text>
                        </svg>
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
            <h1>tbd</h1>
        </div>
        <div class="landingPage__row -fourth">
            <v-container class="py-8">
                <v-row class="d-flex justify-center -primary">
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
            </v-container>
        </div>
    </div>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import LandingPageCard from '@/components/landingPageCard.vue';
import { routeNames } from '@/constants/routeNames';

@Component({
    name: routeNames.LANDING_PAGE,
    components: { LandingPageCard },
})
export default class extends Vue {
    private routeNames = routeNames;
    private card1 = {
        headline: 'Als Unternehmen',
        texts: [
            'Mitarbeiter werden für sinnvolle Arbeiten eingesetzt und ungenutzte Maschinenkapazität wird bereitgestellt. Als Unternehmen haben Sie die Möglichkeit Umsätze zu generieren und laufende Kosten zu decken.',
            'Zudem leisten Sie soziales Engagement, wo es am dringendsten benötigt wird.',
        ],
    };

    private card2 = {
        headline: 'Als Fachkraft',
        texts: [
            'In schweren Zeiten haben Sie mit unserem Produkt die Möglichkeit mit vielen suchenden Unternehmen in Kontakt zu treten.',
            'So können Sie von Ihrem know-how gebrauch machen um auch in Zeiten von Arbeitslosigkeit oder Kurzarbeit liquide zu bleiben',
        ],
    };

    private faqArr = [
        {
            headline: 'Sind die Gesuche und Angebote immer aktuell?',
            text:
                'Bei jedem Eintrag siehst du direkt wann es erstellt und wann es zuletzt geändert wurde. Die meisten unserer Nutzer reagieren untertags innerhalb von 2 Stunden. Gesuche, die 48 Stunden nicht aktualisiert wurden, werden entsprechend markiert und per Mail informiert.',
        },
        {
            headline: 'Wie schnell können die Fachkräfte bei mir sein?',
            text:
                'Die meisten Anbieter, egal ob Unternehmen oder Fachkraft, haben sofortige Verfügbarkeit, d.h. sobald ihr euch über die Vorraussetzungen, wie Maschine, Ort, Haftung und ggf. Vergütung einig seid, könnt ihr loslegen. Erfahrungsgemäß geht das innerhalb weniger Stunden nach der ersten Kontaktaufnahme.',
        },
        {
            headline: 'Was kostet mich das?',
            text:
                'Unsere Plattform wird als gemeinnützige Olattform betrieben und finanziert sich bisher aus Spenden. Die Vermittlung selbst ist komplett kostenfrei. Für die in Anspruch genommenen Facharbeiten liegt es an Anbieter und Suchenden eine für beide Seiten faire Lösung zu finden. Tipp von uns: das muss nicht immer Geld sein! Eine Selbstständiger, der aufgrund der Corona-Krise derzeit kein Einkommen hat, kann derzeit vielleicht genauso gut Lebensmittel transportieren.',
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
        }

        &.-third {
            background-color: #e5e5e5;
            height: 500px;
        }
    }
}
</style>
