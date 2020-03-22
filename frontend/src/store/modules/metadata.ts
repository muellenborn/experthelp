import { Module, VuexModule, Mutation, Action } from 'vuex-module-decorators';
import Skill from '@/interfaces/Skill';

@Module
export default class MetadataStore extends VuexModule {
    private skillsData: Skill[] = [];

    public get skills(): Skill[] {
        return this.skillsData;
    }

    public get skillsArray(): string[] {
        return this.skillsData.map(function(skill) {
            return skill['name'];
        });
    }

    @Mutation
    public saveSkills(skills: string[]) {
        if (skills) {
            this.skillsData = skills.map((name) => ({ name, level: null }));
        }
    }

    @Action({ commit: 'saveSkills' })
    public setSkills(payload: string[]) {
        return payload;
    }
}
