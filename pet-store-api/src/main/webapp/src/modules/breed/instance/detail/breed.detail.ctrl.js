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

  var mod = ng.module("breedModule");

  mod.controller("breedDetailCtrl", ['$scope', "$state", "breed", "model", "animalModel",
    function ($scope, $state, breed, model, animalModel) {
      $scope.model = model;
      $scope.currentRecord = breed;
      $scope.buttons = ['detail'];
      $scope.animalButtons = ['detail', 'edit'];
      $scope.animalModel = animalModel;
      $scope.animals = [];
      $scope.photos = [];
      
      breed.getList('animal').then(function(animals){
        $scope.animals = animals;
        this.loadPhotos();
      }.bind(this));
      
      this.loadPhotos = function () {
        for (var i = 0; i < $scope.animals.length; i++) {
          var photos = $scope.animals[i].photoAlbum;
          var image = photos[Math.floor((Math.random()*photos.length))];
          console.log(image);
          if(image){
            $scope.photos.push({image: image.image, id: $scope.animals[i].id});
          }
        }
      };
      
      $scope.actions = {
        create: {
          displayName: 'Create',
          icon: 'plus',
          fn: function () {
            $state.go('breedNew');
          }
        },
        edit: {
          displayName: 'Edit',
          icon: 'edit',
          fn: function () {
            $state.go('breedEdit');
          }
        },
        delete: {
          displayName: 'Delete',
          icon: 'minus',
          fn: function () {
            $state.go('breedDelete');
          }
        },
        refresh: {
          displayName: 'Refresh',
          icon: 'refresh',
          fn: function () {
            $state.reload();
          }
        },
        list: {
          displayName: 'List',
          icon: 'th-list',
          fn: function () {
            $state.go('breedList');
          }
        },
        animal: {
          displayName: 'Animal',
          icon: 'link',
          fn: function () {
            $state.go('breedAnimalList');
          }
        }
      };

      $scope.animalActions = {
        detail: {
          displayName: 'Detail',
          icon: 'eye-open',
          fn: function (rc) {
            $state.go('animalDetail', {animalId: rc.id});
          },
          show: function () {
            return true;
          }
        },
        edit: {
          displayName: 'Edit',
          icon: 'edit',
          fn: function (rc) {
            $state.go('animalEdit', {animalId: rc.id});
          },
          show: function () {
            return true;
          }
        },
        delete: {
          displayName: 'Delete',
          icon: 'minus',
          fn: function (rc) {
            $state.go('animalDelete', {animalId: rc.id});
          },
          show: function () {
            return true;
          }
        }
      };
    }]);
})(window.angular);
