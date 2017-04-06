(function() {
"use strict";

angular.module('common', [])
.constant('ApiPath', 'src/common/data')
.config(config);

config.$inject = ['$httpProvider'];
function config($httpProvider) {
  $httpProvider.interceptors.push('loadingHttpInterceptor');
}

})();
