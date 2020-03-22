<template>
    <v-card class="mx-auto text-center px-5 py-8" outlined>
        <div class="d-flex align-center justify-center">
            <company-svg v-if="data.svg === 'company'" class="landingPageCard__svg" />
            <worker-svg v-else class="landingPageCard__svg" />
        </div>
        <h2 v-if="data.headline" class="pt-3">
            {{ data.headline }}
        </h2>
        <p v-for="(text, index) in data.texts" :key="index" class="pt-3">
            {{ text }}
        </p>
    </v-card>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';
import { Components } from '@/constants/components.enum';
import CompanySvg from '@/components/companySvg.vue';
import WorkerSvg from '@/components/workerSvg.vue';

@Component({
    name: Components.LandingPageCard,
    components: { WorkerSvg, CompanySvg },
})
export default class extends Vue {
    @Prop() private data!: object;
}
</script>
<style scoped lang="scss">
.landingPageCard {
    &__svg {
        padding: 0 35%;
    }
}
</style>
