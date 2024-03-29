
(function (ng) {
    var mod = ng.module("libroModule");
    mod.constant("libroContext", "api/libros");
    
 


    mod.controller('libroDetailCtrl', ['$scope', '$http', 'libroContext', '$state','$rootScope','$sce',
        /**
         * @ngdoc controller
         * @name libros.controller:libroDetailCtrl
         * @description 
         * Definición de un controlador auxiliar del módulo Libro.
         * Se crea el controlador con el cual se manejan las vistas de detalle del módulo.
         * @param {Object} $scope Referencia inyectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o funciones que se definen 
         * en este controlador y que son utilizadas desde el HTML.
         * @param {Object} $http Objeto inyectado para manejar las consultas HTTP
         * @param {Object} libroContext Constante inyectada que contiene la ruta donde se encuentra
         * el API de Libros en el  back-end.
         * @param {Object} $state  Dependencia inyectada en la que se recibe el
         * estado actual de la navecación definida en el módulo.   
         */

        function ($scope, $http, libroContext, $state,$rootScope, $sce) {
               $scope.comentario={};
            $scope.comentario.comentario="";
            
               $scope.trustSrc = function(src) {
            return $sce.trustAsResourceUrl(src);
        }
            
            $scope.comentario.fecha=new Date().toJSON()+"";
            $scope.comentario.id=9000;
            if (($state.params.libroId !== undefined) && ($state.params.libroId !== null)) {
                /**
                 * @ngdoc function
                 * @name getLibroID
                 * @methodOf libros.controller:libroDetailCtrl
                 * @description 
                 * Esta función utiliza el protocolo Http para obtener el recurso
                 * donde se encuentra el libro por ID en formato JSON.
                 * de los libros o API donde se puede consultar. 
                 * @param {json} response 
                 */
                $http.get(libroContext + '/' + $state.params.libroId).then(function (response) {
                    $scope.currentLibro = response.data;
                });

                $scope.agregar = function (libro)
                {
                    $rootScope.carrito.push(libro);
                    
                    
};


  $scope.agregarC=function (libro) 
                {
                   
                    libro.comentarios.push($scope.comentario);
                    
                    $http.put("http://localhost:8080/documentos-web/api/libros/"+libro.id ,libro).then(function (response) 
                    {
                         $http.get(libroContext + '/' + $state.params.libroId).then(function (response) {
                    $scope.currentLibro = response.data;
                });

                    });
                    $scope.comentario={};
                    
                };
                $scope.borrar=function (comentario,libro) 
                {

                     for (var i = 0; i < libro.comentarios.length; i++) 
                    {
                        if(libro.comentarios[i].id===comentario.id)
                         {
                           
                            libro.comentarios.splice(i,1);  
                         };
                    
                    }
                    $http.put("http://localhost:8080/documentos-web/api/libros/"+libro.id ,libro);
                    
               
                    
                };

            }

        }
    ]);
})(window.angular);