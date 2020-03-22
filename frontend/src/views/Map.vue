<template>
    <div class="map">
        <iframe
            class="map"
            frameborder="0"
            style="border:0"
            :src="`https://www.google.com/maps/embed/v1/search?q=${this.contactForm.street}+${this.contactForm.city}&key=AIzaSyCmc9RFdFJGMNh_COtjp941dxrdBQ0fcck`"
            allowfullscreen
        />
        <!-- Possibly in future -->
        <!--<GmapMap ref="mapRef" :center="{ lat: 10, lng: 10 }" :zoom="7" map-type-id="roadmap" class="map" />-->
    </div>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import { routeNames } from '@/constants/routeNames';
import { Getter } from 'vuex-class';

@Component({
    name: routeNames.MAP,
    components: {},
})
export default class extends Vue {
    // public $refs!: {
    //     mapRef: any;
    // };
    @Getter private contactForm!: object;
    private routeNames = routeNames;
}
</script>

<style scoped lang="scss">
.map {
    height: 100%;
    width: 100%;
}
</style>
