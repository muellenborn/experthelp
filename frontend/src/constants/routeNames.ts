import { OfferHelpRouteNames, RouteNames } from '@/interfaces/RouteNames';

/**
 * @object offerHelpRouteNames
 * Declares route names for offerHelp.
 */
export const offerHelpRouteNames: OfferHelpRouteNames = {
    CONTACT_FORM: 'contactForm',
    MAIN: 'offerHelp',
    SKILL_FORM: 'skillForm',
};

/**
 * @enum RouteNames
 * Declares available routes names.
 */
export const routeNames: RouteNames = {
    APP: 'App',
    IMPRESS: 'impress',
    LANDING_PAGE: 'LandingPage',
    MAP: 'map',
    OFFER_HELP: offerHelpRouteNames,
    TEAM: 'team',
    THANK_YOU: 'thankYou',
};
