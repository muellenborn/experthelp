import store from '@/store/index';
import * as data from '@/mockData/skills.json';

/**
 * Fetch skills and storing it into store
 * @export { getSkills: Promise } to initialize skills
 */
export const getSkills = () => {
    return new Promise<string[]>((resolve, reject) => {
        if ((data as any).default.skills) {
            store.dispatch('setSkills', (data as any).default.skills).then(resolve);
        } else {
            reject('Keine Skills gefunden');
        }
    });
};
