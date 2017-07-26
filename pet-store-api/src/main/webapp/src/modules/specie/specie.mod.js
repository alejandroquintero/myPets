/*
 The MIT License (MIT)
 
 Copyright (c) 2015 Los Andes University
 
 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
 
 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.
 
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */
(function (ng) {
  var mod = ng.module('specieModule', ['ngCrud', 'ui.router']);

  mod.constant('specieModel', {
    name: 'specie',
    displayName: 'Specie',
    url: 'species',
    fields: {
    }
  });

  mod.config(['$stateProvider',
    function ($sp) {
      var basePath = 'src/modules/specie/';
      var baseInstancePath = basePath + 'instance/';

      $sp.state('specie', {
        url: '/species?page&limit',
        abstract: true,

        views: {
          mainView: {
            templateUrl: basePath + 'specie.tpl.html',
            controller: 'specieCtrl'
          }
        },
        resolve: {
          model: 'specieModel',
          species: ['Restangular', 'model', '$stateParams', function (r, model, $params) {
              return r.all(model.url).getList($params);
            }]
        }
      });
      $sp.state('specieList', {
        url: '/list',
        parent: 'specie',
        views: {
          specieView: {
            templateUrl: basePath + 'list/specie.list.tpl.html',
            controller: 'specieListCtrl',
            controllerAs: 'ctrl'
          }
        },
        ncyBreadcrumb: {
          label: 'specie'
        }
      });
      $sp.state('specieNew', {
        url: '/new',
        parent: 'specie',
        views: {
          specieView: {
            templateUrl: basePath + 'new/specie.new.tpl.html',
            controller: 'specieNewCtrl',
            controllerAs: 'ctrl'
          }
        },
        ncyBreadcrumb: {
          parent: 'specieList',
          label: 'new'
        }
      });
      $sp.state('specieInstance', {
        url: '/{specieId:int}',
        abstract: true,
        parent: 'specie',
        views: {
          specieView: {
            template: '<div ui-view="specieInstanceView"></div>'
          }
        },
        resolve: {
          specie: ['species', '$stateParams', function (species, $params) {
              return species.get($params.specieId);
            }]
        }
      });
      $sp.state('specieDetail', {
        url: '/details',
        parent: 'specieInstance',
        views: {
          specieInstanceView: {
            templateUrl: baseInstancePath + 'detail/specie.detail.tpl.html',
            controller: 'specieDetailCtrl'
          }
        },
        ncyBreadcrumb: {
          parent: 'specieList',
          label: 'details'
        }
      });
      $sp.state('specieEdit', {
        url: '/edit',
        sticky: true,
        parent: 'specieInstance',
        views: {
          specieInstanceView: {
            templateUrl: baseInstancePath + 'edit/specie.edit.tpl.html',
            controller: 'specieEditCtrl',
            controllerAs: 'ctrl'
          }
        },
        ncyBreadcrumb: {
          parent: 'specieDetail',
          label: 'new'
        }
      });
      $sp.state('specieDelete', {
        url: '/delete',
        parent: 'specieInstance',
        views: {
          specieInstanceView: {
            templateUrl: baseInstancePath + 'delete/specie.delete.tpl.html',
            controller: 'specieDeleteCtrl',
            controllerAs: 'ctrl'
          }
        }
      });
      $sp.state('specieBreeds', {
        url: '/breeds',
        parent: 'specieDetail',
        abstract: true,
        views: {
          specieChieldView: {
            template: '<div ui-view="specieBreedsView"></div>'
          }
        },
        resolve: {
          breeds: ['specie', function (specie) {
              return specie.getList('breeds');
            }],
          model: 'breedModel'
        }
      });
      $sp.state('specieBreedsList', {
        url: '/list',
        parent: 'specieBreeds',
        views: {
          specieBreedsView: {
            templateUrl: baseInstancePath + 'breeds/list/specie.breeds.list.tpl.html',
            controller: 'specieBreedsListCtrl'
          }
        }
      });
      $sp.state('specieBreedsEdit', {
        url: '/edit',
        parent: 'specieBreeds',
        views: {
          specieBreedsView: {
            templateUrl: baseInstancePath + 'breeds/edit/specie.breeds.edit.tpl.html',
            controller: 'specieBreedsEditCtrl',
            controllerAs: 'ctrl'
          }
        },
        resolve: {
          pool: ['Restangular', 'model', function (r, model) {
              return r.all(model.url).getList();
            }]
        }
      });
    }]);
})(window.angular);
