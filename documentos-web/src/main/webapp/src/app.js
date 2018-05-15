
(function (ng) {
    var app = angular.module('mainApp', [
      
        'ui.router',
       
        // Internal modules dependencies       

        'citiesModule',
        'editorialesModule',
        'cursosModule',
       'libroModule',
       'fotocopiaModule',
       'usuarioModule',
       'reservaModule',
       'deseadoModule',
       'autorModule',
       'areaModule',
       'paypalModule',
       'tarjetadecreditoModule',
       'comprasModule',
       'inicioModule', 
       'carritoModule'

        


    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
            
        }]);

     app.run( function ($rootScope) 
     {$rootScope.carrito=[];
 
        });
  

   
    
 
})(window.angular);

