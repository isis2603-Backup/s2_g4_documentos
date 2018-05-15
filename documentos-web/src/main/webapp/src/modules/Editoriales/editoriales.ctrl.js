(function (ng) {

    var mod = ng.module("editorialesModule");

    mod.controller("editorialesCtrl", ['$scope','$rootScope' , '$state', '$http', function ($scope,$rootScope ,$state, $http) {
            $rootScope.home=1;
            $scope.data = {};
            $scope.dataActuaBasico={};
            $scope.data.libros=[];
            
            
            $http.get("http://localhost:8080/documentos-web/api/editoriales").then(function (response) 
            {
                $scope.editoriales = response.data;
            });
            
            $scope.get = function(){
                $http.get("http://localhost:8080/documentos-web/api/editoriales").then(function (response) 
                {
                    $scope.editoriales = response.data;
                });
            };
            $scope.create= function()
            {
               
                $http.post("http://localhost:8080/documentos-web/api/editoriales",$scope.data).then(function () 
                {
                    $scope.get();
                });
            
            };
            $scope.update_editorial= function(id)
            {
                $http.put("http://localhost:8080/documentos-web/api/editoriales/"+$scope.dataActuaBasico.id ,$scope.dataActuaBasico).then(function () 
                {
                    $state.reload();
                });
            
            };
            $scope.delete= function(id)
            {
                $http.delete("http://localhost:8080/documentos-web/api/editoriales/"+id ).then(function () 
                {
                    $scope.get();
                });
            
            };
            $scope.darLibros = function()
            {
               
                $http.get("http://localhost:8080/documentos-web/api/libros").then(function (response) 
                {
                    $scope.libros = response.data;
                   
                });   

            };
            $scope.actualizarLibros=function(editorial)
            {
               
                $scope.data.id=editorial.id;
                $scope.data.nombre=editorial.nombre;
               
                $http.put("http://localhost:8080/documentos-web/api/editoriales/"+editorial.id ,$scope.data).then(function () 
                {
                    $state.reload();
                });
           
               
            };
          
            $scope.bibliografia= function (libro)
            {
                
                    $scope.data.libros.push({id:libro.id});
                    
                    
                    for (var i = 0; i < $scope.libros.length; i++) 
                    {
                        if($scope.libros[i].id===libro.id)
                         {
                           $scope.libros.splice(i,1);  
                         };
                    
                }
               
            };
            
        }]);
})(window.angular);
