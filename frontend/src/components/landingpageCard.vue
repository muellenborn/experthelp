<template>
    <v-card class="mx-auto text-center px-5 py-8" outlined>
        <div class="d-flex align-center justify-center">
            <svg xmlns="http://www.w3.org/2000/svg" width="200" height="200" viewBox="0 0 200 200">
                <rect fill="#ddd" width="200" height="200" />
                <text fill="rgba(0,0,0,0.5)" font-family="sans-serif" font-size="30" dy="10.5" font-weight="bold" x="50%" y="50%" text-anchor="middle">200×200</text>
            </svg>
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
import Vue from 'vue';
import { Component, Prop } from 'vue-property-decorator';
import { Components } from '@/constants/components.enum';

@Component({
    name: Components.LandingpageCard,
    components: {},
})
export default class extends Vue {
    @Prop() private data!: object;
}
</script>
