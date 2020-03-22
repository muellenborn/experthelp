<template>
    <div class="team d-flex align-center justify-center">
        <v-container class="py-8 d-flex align-center justify-center flex-column">
            <v-row class="py-6">
                <h1 class="-primary">Impressum</h1>
            </v-row>
            <v-row class="py-2">
                <h3>Vorbemerkung</h3>
            </v-row>
            <v-row class="py-2">
                <p>
                    Diese Seite wurde von einem Team veröffentlicht, das sich in einem sogenannten "Hackathon" gebildet hat. Wikipedia erklärt einen Hackathon wie folgt:<br />
                    "Ein Hackathon (Wortschöpfung aus „Hack“ und „Marathon“) ist eine kollaborative Soft- und Hardwareentwicklungs­veranstaltung. Alternative Bezeichnungen sind
                    „Hack Day“, „Hackfest“ und „codefest“. Ziel eines Hackathons ist es, innerhalb der Dauer dieser Veranstaltung gemeinsam nützliche, kreative oder unterhaltsame
                    Softwareprodukte herzustellen oder, allgemeiner, Lösungen für gegebene Probleme zu finden."<br />
                    <a href="https://de.wikipedia.org/wiki/Hackathon">https://de.wikipedia.org/wiki/Hackathon</a>
                </p>
            </v-row>
            <v-row class="py-2">
                <p>
                    Der Hackathon, aus dem diese Seite hervorgegangen ist, ist der von der Bundesregierung veranstaltete Hackathon #WirVsVirus, über den Sie sich unter
                    <a href="https://wirvsvirushackathon.org">https://wirvsvirushackathon.org</a> informieren können.
                </p>
            </v-row>
            <v-row class="py-2">
                <p>
                    <strong>Disclaimer:</strong> Zu einem Hackathon gehört, dass man sich als Team sehr kurzfristig zusammenfindet und dann, mit hohem Energieeinsatz und unter
                    Zeitdruck Lösungen schafft, für die Softwareenwicklungs- und Projektteams sonst ein vielfaches der Zeit benötigen würden. In einer solchen Situation ist
                    Perfektionismus weder gewünscht noch möglich. Daher ist diese Seite auch nur ein Einblick für ein Service, der diese Dienstleistung anbieten könnte. Es werden
                    keine Daten gespeichert!
                </p>
            </v-row>
            <v-row class="py-2">
                <p>
                    <strong>Dieser Projektentwurf ist im Rahmen des Hackathon WirvsVirus entstanden.</strong>
                </p>
            </v-row>
            <v-row class="py-2">
                <p><strong>Kontakt: </strong><a href="mailto:admin@cy-borg.net">admin@cy-borg.net</a></p>
            </v-row>
        </v-container>
    </div>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import { routeNames } from '@/constants/routeNames';
import ThankYouSvg from '@/components/thankYouSvg.vue';

@Component({
    name: routeNames.IMPRESS,
    components: { ThankYouSvg },
})
export default class extends Vue {
    private routeNames = routeNames;
}
</script>

<style scoped lang="scss">
.team {
    min-height: 100%;
    background-color: #e5e5e5;

    &__img {
        max-width: 100%;
    }
}
</style>
