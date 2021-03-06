/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

module.exports = function (grunt) {
    "use strict";
    require('time-grunt')(grunt);
    // Project configuration.
    grunt.initConfig({
        jshint: {
            "server": {
                "src": ["routes/**/*.js", "app.js"],
                options: {
                    "strict": true,
                    "curly": true,
                    "eqnull": true,
                    "unused": true,
                    "eqeqeq": true,
                    "undef": true,
                    "camelcase": true,
                    "forin": true,
                    "immed": true,
                    "node": true,
                    "latedef": true,
                    "newcap": true,
                    "quotmark": "double",
                    "trailing": true,
                    "globals": {exports: true, require: true},
                    "reporter": require('jshint-stylish'),
                    '-W097': true // use strict in function form warning
                }
            },
            "client": {
                "src": ["public/javascripts/**/*.js"],
                options: {
                    "strict": true,
                    "curly": true,
                    "eqnull": true,
                    "unused": true,
                    "eqeqeq": true,
                    "undef": true,
                    "camelcase": true,
                    "forin": true,
                    "immed": true,
                    "latedef": true,
                    "newcap": true,
                    "quotmark": "double",
                    "trailing": true,
                    "globals": {ko: true, window: true, XMLHttpRequest: true},
                    "reporter": require('jshint-stylish'),
                    '-W097': true // use strict in function form warning
                }
            }



        }
    });
    grunt.registerTask('jshint-server', ['jshint:server']);
    grunt.registerTask('jshint-client', ['jshint:client']);
    grunt.loadNpmTasks('grunt-contrib-jshint');
};
