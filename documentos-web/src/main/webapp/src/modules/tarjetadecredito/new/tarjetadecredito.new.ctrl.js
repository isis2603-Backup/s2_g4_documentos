(function (ng) {
    var mod = ng.module("tarjetadecreditoModule");
    mod.constant("tarjetadecreditoContext", "api/usuario/45/metodosdepago/tarjetadecredito");
    mod.controller('tarjetadecreditoNewCtrl', ['$scope', '$http', 'tarjetadecreditoContext', '$state', '$rootScope',

        function ($scope, $http, tarjetadecreditoContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};

            $scope.createTarjetadecredito = function () {            
                
               
                $http.post(tarjetadecreditoContext, $scope.data).then(function () {
                    $state.reload();
                });
            };
        }
    ]);
}
)(window.angular);