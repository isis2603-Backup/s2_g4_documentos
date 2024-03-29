(function(ng){
    var mod = ng.module("paypalModule",['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider,$urlRouterProvider){
            var basePath = 'src/modules/paypal/';
            $urlRouterProvider.otherwise('/paypal');
            
           $stateProvider.state('paypal',{
               url:'paypal',
               abstract: true,
               parent:'usuarios',
               views:{
                   'paypal':{
                       templateUrl: basePath + 'paypal.html',
                       controller: 'paypalCtrl',
                       controllerAs: 'ctrl'
                   },
                   'menuView':{
                      templateUrl: 'src/modules/usuarios/menu.html',
                      controller: 'usuarioCtrl',
                      controllerAs: 'ctrl'

                    }
               }
           }).state('paypalList',{
               url: '/list',
               parent: 'paypal',
               views:{
                   'listView':{
                       templateUrl: basePath + 'paypal.list.html'
                   }
               }
           }).state('paypalDetail', {
                url: '/{paypalId: int}/detail',
                parent: 'paypal',
                param: {paypalId: null},
                views: {
                    'detailView': {
                        templateUrl: basePath + 'paypal.detail.html',
                        controller: 'paypalDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }

            }).state('paypalCreate', {
                url: '/create',
               // parent: 'paypal',
                views: {
                    'mainView': {
                        templateUrl: basePath + '/new/paypal.new.html',
                        controller: 'paypalNewCtrl'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
            }).state('paypalUpdate', {
                url: '/update/{paypalId:int}',
                parent: 'paypal',
                param: {
                    editorialId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/paypal.new.html',
                        controller: 'paypalUpdateCtrl'
                    }
                }
                ,
                data: {
                    requireLogin: true,
                    roles: ['admin']
                }
            });
    }]);
})(window.angular);