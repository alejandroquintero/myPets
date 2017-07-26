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
    var mod = ng.module('breedModule', ['ngCrud', 'ui.router']);

    mod.constant('breedModel', {
        name: 'breed',
        displayName: 'Breed',
        url: 'breeds',
        fields: {
            description: {
                
                displayName: 'Description',
                type:  'String',
                required:false
            },
            mood: {
                
                displayName: 'Mood',
                type:  'String',
                required:false
            },
            size: {
                
                displayName: 'Size',
                type:  'String',
                required:false
            },
            lifeExpectancy: {
                
                displayName: 'Life Expectancy',
                type:  'Integer',
                required:false
            },
            specie: {
                displayName:  'Specie',
                type: 'Reference',
                model: 'specieModel',
                options: [],
                required: false
            }        }
    });

    mod.config(['$stateProvider',
        function($sp){
            var basePath = 'src/modules/breed/';
            var baseInstancePath = basePath + 'instance/';

            $sp.state('breed', {
                url: '/breeds?page&limit',
                abstract: true,
                
                views: {
                     mainView: {
                        templateUrl: basePath + 'breed.tpl.html',
                        controller: 'breedCtrl'
                    }
                },
                resolve: {
                    references: ['$q', 'Restangular', function ($q, r) {
                            return $q.all({
                                specie: r.all('species').getList()
                            });
                        }],
                    model: 'breedModel',
                    breeds: ['Restangular', 'model', '$stateParams', function (r, model, $params) {
                            return r.all(model.url).getList($params);
                        }]
                }
            });
            $sp.state('breedList', {
                url: '/list',
                parent: 'breed',
                views: {
                     breedView: {
                        templateUrl: basePath + 'list/breed.list.tpl.html',
                        controller: 'breedListCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                     ncyBreadcrumb: {
                                label: 'breed'
                           }
            });
            $sp.state('breedNew', {
                url: '/new',
                parent: 'breed',
                views: {
                    breedView: {
                        templateUrl: basePath + 'new/breed.new.tpl.html',
                        controller: 'breedNewCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                     ncyBreadcrumb: {
                                parent :'breedList', 
                                label: 'new'
                           }
            });
            $sp.state('breedInstance', {
                url: '/{breedId:int}',
                abstract: true,
                parent: 'breed',
                views: {
                    breedView: {
                        template: '<div ui-view="breedInstanceView"></div>'
                    }
                },
                resolve: {
                    breed: ['breeds', '$stateParams', function (breeds, $params) {
                            return breeds.get($params.breedId);
                        }]
                }
            });
            $sp.state('breedDetail', {
                url: '/details',
                parent: 'breedInstance',
                views: {
                    breedInstanceView: {
                        templateUrl: baseInstancePath + 'detail/breed.detail.tpl.html',
                        controller: 'breedDetailCtrl'
                    }
                },
                     ncyBreadcrumb: {
                                parent :'breedList', 
                                label: 'details'
                           }
            });
            $sp.state('breedEdit', {
                url: '/edit',
                sticky: true,
                parent: 'breedInstance',
                views: {
                    breedInstanceView: {
                        templateUrl: baseInstancePath + 'edit/breed.edit.tpl.html',
                        controller: 'breedEditCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                     ncyBreadcrumb: {
                                parent :'breedDetail', 
                                label: 'new'
                           }
            });
            $sp.state('breedDelete', {
                url: '/delete',
                parent: 'breedInstance',
                views: {
                    breedInstanceView: {
                        templateUrl: baseInstancePath + 'delete/breed.delete.tpl.html',
                        controller: 'breedDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('breedAnimal', {
                url: '/animal',
                parent: 'breedDetail',
                abstract: true,
                views: {
                    breedChieldView: {
                        template: '<div ui-view="breedAnimalView"></div>'
                    }
                },
                resolve: {
                    animal: ['breed', function (breed) {
                            return breed.getList('animal');
                        }],
                    model: 'animalModel'
                }
            });
            $sp.state('breedAnimalList', {
                url: '/list',
                parent: 'breedAnimal',
                views: {
                    breedAnimalView: {
                        templateUrl: baseInstancePath + 'animal/list/breed.animal.list.tpl.html',
                        controller: 'breedAnimalListCtrl'
                    }
                }
            });
            $sp.state('breedAnimalEdit', {
                url: '/edit',
                parent: 'breedAnimal',
                views: {
                    breedAnimalView: {
                        templateUrl: baseInstancePath + 'animal/edit/breed.animal.edit.tpl.html',
                        controller: 'breedAnimalEditCtrl',
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
