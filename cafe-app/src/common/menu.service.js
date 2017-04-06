(function () {
"use strict";

angular.module('common')
.service('MenuService', MenuService);


MenuService.$inject = ['$http', 'ApiPath'];
function MenuService($http, ApiPath) {
  var service = this;

  service.getCategories = function () {
    return $http.get(ApiPath + '/categories.json').then(function (response) {
      return response.data;
    });
  };


  service.getMenuItems = function (category) {
    var config = {};
    if (category) {
      config.params = {'category': category};
    }

    return $http.get(ApiPath + '/menu_items.json', config).then(function (response) {
      return response.data;
    });
  };


  service.getMenuItems = function (shortName) {
    var config = {};
    if (shortName) {
      config.params = {category: shortName};
    }

    return $http.get(ApiPath + '/menu_items.json', config).then(function (response) {
      return response.data;
    });
  }


  service.getCategory = function (shortName) {
    return $http.get(ApiPath + '/categories/' + shortName + '.json').then(function (response) {
      return response.data;
    });
  };


  service.getMenuItem = function(shortName) {
    return $http.get(ApiPath + '/menu_items/' + shortName + '.json')
    .then(function(response) {
      return response.data;
    });
  };


  service.saveMenuItem = function (menuItem) {
    return $http.put(ApiPath + '/menu_items/' + menuItem.short_name, menuItem)
    .then(function (response) {
      return response.data;
    });
  };

  service.getMenuItemsByCategory = function(shortName) {
    return $http.get(ApiPath + '/menu_items/' + shortName + '.json')
    .then(function(response) {
      return response.data;
    });
  };

}



})();

$(function () { // Same as document.addEventListener("DOMContentLoaded"...

  // Same as document.querySelector("#navbarToggle").addEventListener("blur",...
  $("#navbarToggle").blur(function (event) {
    var screenWidth = window.innerWidth;
    if (screenWidth < 768) {
      $("#collapsable-nav").collapse('hide');
    }
  });

  // In Firefox and Safari, the click event doesn't retain the focus
  // on the clicked button. Therefore, the blur event will not fire on
  // user clicking somewhere else in the page and the blur event handler
  // which is set up above will not be called.
  // Refer to issue #28 in the repo.
  // Solution: force focus on the element that the click event fired on
  $("#navbarToggle").click(function (event) {
    $(event.target).focus();
  });
});