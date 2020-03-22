import { OfferHelpRouteNames, RouteNames } from '@/interfaces/RouteNames';

/**
 * @object offerHelpRouteNames
 * Declares route names for offerHelp.
 */
export const offerHelpRouteNames: OfferHelpRouteNames = {
    MAIN: 'offerHelp',
    CONTACT_FORM: 'contactForm',
    SKILL_FORM: 'skillForm',
};

/**
 * @enum RouteNames
 * Declares available routes names.
 */
export const routeNames: RouteNames = {
    APP: 'App',
    LANDING_PAGE: 'LandingPage',
    THANK_YOU: 'thankYou',
    OFFER_HELP: offerHelpRouteNames,
};
