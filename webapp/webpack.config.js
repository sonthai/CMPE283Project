var path = require('path');
var srcPath = path.join(__dirname, 'src');
var buildPath = path.join(__dirname, 'dst');
var bootstrap = path.join(__dirname, 'bower_components');
var autoprefixer = require('autoprefixer');
var precss =  require('precss')

var config = {
    context: srcPath,
    entry: path.join(srcPath, 'js', 'client.js'),

    output: {
	path: buildPath,
	filename: 'client.min.js',
    },

    devServer: {
        inline: true,
        port: 8090
    },

    module: {
        loaders: [
        {
            test: /\.jsx?$/,
            exclude: /node_modules/,
            loader: 'babel',
            query: {
                presets: ['es2015', 'react']
            }

        }, {
                test: /\.css$/,
                loaders: ['style-loader', 'css-loader', 'postcss-loader']
            }
        ]
    },
    postcss: function () {
	    return [autoprefixer, precss];
    }
}

module.exports = config;
	


