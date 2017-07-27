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
    var mod = ng.module('animalModule', ['ngCrud', 'ui.router']);

    mod.constant('animalModel', {
        name: 'animal',
        displayName: 'Animal',
        url: 'animals',
        fields: {
            name: {   
                displayName: 'Animals',
                type:  'String',
                required:false
            },
            birthDate: {
                
                displayName: 'Birth Date',
                type:  'Date',
                required:false
            },
            color: {
                
                displayName: 'Color',
                type:  'String',
                required:false
            },
            gender: {
                
                displayName: 'Gender',
                type:  'String',
                required:false
            },
            mother: {
                displayName:  'Mother',
                type: 'Reference',
                model: 'animalModel',
                options: [],
                required: false
            },
            breed: {
                displayName:  'Breed',
                type: 'Reference',
                model: 'breedModel',
                options: [],
                required: false
            },
            father: {
                displayName:  'Father',
                type: 'Reference',
                model: 'animalModel',
                options: [],
                required: false
            }        }
    });

    mod.config(['$stateProvider',
        function($sp){
            var basePath = 'src/modules/animal/';
            var baseInstancePath = basePath + 'instance/';

            $sp.state('animal', {
                url: '/animals?page&limit',
                abstract: true,
                
                views: {
                     mainView: {
                        templateUrl: basePath + 'animal.tpl.html',
                        controller: 'animalCtrl'
                    }
                },
                resolve: {
                    references: ['$q', 'Restangular', function ($q, r) {
                            return $q.all({
                                mother: r.all('animals').getList()
,                                 breed: r.all('breeds').getList()
,                                 father: r.all('animals').getList()
                            });
                        }],
                    model: 'animalModel',
                    animals: ['Restangular', 'model', '$stateParams', function (r, model, $params) {
                            return r.all(model.url).getList($params);
                        }]
                }
            });
            $sp.state('animalList', {
                url: '/list',
                parent: 'animal',
                views: {
                     animalView: {
                        templateUrl: basePath + 'list/animal.list.tpl.html',
                        controller: 'animalListCtrl',
                        controllerAs: 'ctrl'
                    }
                },resolve:{
						model: 'animalModel'
					},
                     ncyBreadcrumb: {
                                label: 'animal'
                           }
            });
            $sp.state('animalNew', {
                url: '/new',
                parent: 'animal',
                views: {
                    animalView: {
                        templateUrl: basePath + 'new/animal.new.tpl.html',
                        controller: 'animalNewCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                  resolve:{
						model: 'animalModel'
					},
                     ncyBreadcrumb: {
                                parent :'animalList', 
                                label: 'new'
                           }
            });
            $sp.state('animalInstance', {
                url: '/{animalId:int}',
                abstract: true,
                parent: 'animal',
                views: {
                    animalView: {
                        template: '<div ui-view="animalInstanceView"></div>'
                    }
                },
                resolve: {
                    animal: ['animals', '$stateParams', function (animals, $params) {
                            return animals.get($params.animalId);
                        }]
                }
            });
            $sp.state('animalDetail', {
                url: '/details',
                parent: 'animalInstance',
                views: {
                    animalInstanceView: {
                        templateUrl: baseInstancePath + 'detail/animal.detail.tpl.html',
                        controller: 'animalDetailCtrl'
                    }
                },
                  resolve:{
						model: 'animalModel'
					},
                     ncyBreadcrumb: {
                                parent :'animalList', 
                                label: 'details'
                           }
            });
            $sp.state('animalEdit', {
                url: '/edit',
                sticky: true,
                parent: 'animalInstance',
                views: {
                    animalInstanceView: {
                        templateUrl: baseInstancePath + 'edit/animal.edit.tpl.html',
                        controller: 'animalEditCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                  resolve:{
						model: 'animalModel'
					},
                     ncyBreadcrumb: {
                                parent :'animalDetail', 
                                label: 'edit'
                           }
            });
            $sp.state('animalDelete', {
                url: '/delete',
                parent: 'animalInstance',
                views: {
                    animalInstanceView: {
                        templateUrl: baseInstancePath + 'delete/animal.delete.tpl.html',
                        controller: 'animalDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                  resolve:{
						model: 'animalModel'
					}
            });
	}]);
})(window.angular);
