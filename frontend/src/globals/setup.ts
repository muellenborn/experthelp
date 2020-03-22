import { getSkills } from '@/controller/metadata';

export const init = new Promise((resolve: any, reject: any) => {
    const promises = [getSkills()];

    Promise.all(promises)
        .then(resolve)
        .catch((reason) => {
            reject(reason);
        });
});
