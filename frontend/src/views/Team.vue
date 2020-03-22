<template>
    <div class="team d-flex align-center justify-center">
        <v-container class="py-8 d-flex align-center justify-center">
            <v-row>
                <v-col cols="12">
                    <img src="/img/team.jpg" class="team__img" />
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
    name: routeNames.TEAM,
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
