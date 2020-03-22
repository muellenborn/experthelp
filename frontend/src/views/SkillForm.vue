<template>
    <v-form v-model="skillForm.valid" class="offerHelp__form">
        <h3>Wodurch kannst du unterstützen?</h3>
        <v-container>
            <v-row>
                <v-col cols="12" md="12">
                    <v-text-field v-model="skillForm.name" label="Name" outlined hide-details="auto" :rules="nameRules" required />
                </v-col>
            </v-row>
            <v-row>
                <v-col cols="12" md="12">
                    <v-combobox
                        v-model="skillForm.skillsArray"
                        :items="skillsArray"
                        :search-input.sync="search"
                        hide-selected
                        hint="Maximal 5 Fähigkeiten"
                        label="Bitte füge deine Fähigkeiten hier ein"
                        multiple
                        persistent-hint
                        small-chips
                        outlined
                    >
                        <template v-slot:no-data>
                            <v-list-item>
                                <v-list-item-content>
                                    <v-list-item-title>
                                        Keine Ergebnisse für "<strong>{{ search }}</strong
                                        >". Bitte <kbd>enter</kbd> drücken um diese Fähigkeit hinzuzufügen.
                                    </v-list-item-title>
                                </v-list-item-content>
                            </v-list-item>
                        </template>
                    </v-combobox>
                </v-col>
                <v-col cols="12" md="12" v-if="skillForm.skillsArray.length">
                    <v-row v-for="(skill, index) in skillForm.skills" :key="index">
                        <v-col cols="12" md="3">
                            <h4>{{ skill.name }}</h4>
                        </v-col>
                        <v-col cols="12" md="9">
                            <v-slider v-model="skill.level" :tick-labels="ticksLabels" :max="2" step="1" ticks="always" tick-size="4" />
                        </v-col>
                    </v-row>
                </v-col>
            </v-row>
            <v-row>
                <v-col cols="12" md="6">
                    <v-menu
                        ref="menu"
                        v-model="menu"
                        :close-on-content-click="false"
                        :return-value.sync="skillForm.dateFrom"
                        transition="scale-transition"
                        offset-y
                        min-width="290px"
                    >
                        <template v-slot:activator="{ on }">
                            <v-text-field v-model="skillForm.dateFrom" outlined hide-details="auto" label="Verfügbarkeit ab" readonly v-on="on" required />
                        </template>
                        <v-date-picker v-model="skillForm.dateFrom" no-title scrollable>
                            <v-btn text color="primary" @click="menu = false">Cancel</v-btn>
                            <v-btn text color="primary" @click="$refs.menu.save(skillForm.dateFrom)">OK</v-btn>
                        </v-date-picker>
                    </v-menu>
                </v-col>
                <v-col cols="12" md="6">
                    <v-menu
                        ref="menu"
                        v-model="menu2"
                        :close-on-content-click="false"
                        :return-value.sync="skillForm.dateTo"
                        transition="scale-transition"
                        offset-y
                        min-width="290px"
                    >
                        <template v-slot:activator="{ on }">
                            <v-text-field v-model="skillForm.dateTo" outlined hide-details="auto" label="Verfügbarkeit bis" readonly v-on="on" required />
                        </template>
                        <v-date-picker v-model="skillForm.dateTo" no-title scrollable>
                            <v-btn text color="primary" @click="menu2 = false">Cancel</v-btn>
                            <v-btn text color="primary" @click="$refs.menu.save(skillForm.dateTo)">OK</v-btn>
                        </v-date-picker>
                    </v-menu>
                </v-col>
            </v-row>
        </v-container>
        <v-row class="justify-end">
            <v-btn :disabled="!skillForm.valid" color="primary" depressed rounded x-large class="ma-2" :to="{ name: routeNames.THANK_YOU }">
                Unterstützung anbieten!<v-icon>mdi-check</v-icon>
            </v-btn>
        </v-row>
    </v-form>
</template>

<script lang="ts">
import Vue from 'vue';
import { Component, Watch } from 'vue-property-decorator';
import { Getter } from 'vuex-class';
import { routeNames } from '@/constants/routeNames';
import Skill from '@/interfaces/Skill';

@Component({
    name: routeNames.OFFER_HELP.SKILL_FORM,
    components: {},
})
export default class extends Vue {
    @Getter private skillForm!: any;
    @Getter private skills!: Skill[];
    @Getter private skillsArray!: string[];
    private routeNames = routeNames;
    private menu = false;
    private menu2 = false;
    private date = false;
    private date2 = false;
    private search = null;
    private nameRules = [(v: string) => !!v || 'Ein Name wird benötigt', (v: string) => v.length >= 3 || 'Der Name muss mindestens 3 Zeichen beinhalten'];
    private ticksLabels = ['Anfänger', 'Fortgeschritten', 'Experte'];

    @Watch('skillForm.skillsArray')
    private onSkillsArrayChanged(val: any) {
        this.skillForm.skills = val.map((name: string) => ({ name, level: null }));
    }
}
</script>
