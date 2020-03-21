module.exports = {
    transpileDependencies: ['vuetify'],
    css: {
        loaderOptions: {
            // pass options to sass-loader
            sass: {
                // @/ is an alias to src/
                // so this assumes you have a file named `src/variables.scss`
                prependData: `@import "src/scss/variable"`,
            },
            scss: {
                // @/ is an alias to src/
                // so this assumes you have a file named `src/variables.scss`
                prependData: `@import "src/scss/variable";`,
            },
        },
    },
};
