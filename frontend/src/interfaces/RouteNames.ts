/**
 * @object OfferHelpRouteNames
 * Declares route names for OfferHelp.
 */

export interface OfferHelpRouteNames {
    MAIN: string;
    CONTACT_FORM: string;
    SKILL_FORM: string;
    [key: string]: any;
}

/**
 * @object RouteNames
 * Declares route names.
 */
export interface RouteNames {
    APP: string;
    LANDING_PAGE: string,
    THANK_YOU: string;
    OFFER_HELP: OfferHelpRouteNames,
}
