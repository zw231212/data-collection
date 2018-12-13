const path = require('path');

let jsPath = "../src/main/webapp/static/js";

module.exports = {
    entry: {
        // index: path.resolve(__dirname, "src/index.js"),
        nstrdata: path.resolve(__dirname, jsPath+"/nstrdata.js")
    },
    output: {
        path    : path.resolve(__dirname, jsPath),
        filename: '[name].min.js'
    }
};