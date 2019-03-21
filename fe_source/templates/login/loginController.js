MY_APP.controller("LoginController", ["$scope", function($scope) {
    $scope.loginData = {
        showLogin: true
    };

    $scope.user = {};

    $scope.addOrRegister = function() {
        $scope.loginData.showLogin ^= true;
    };

    $scope.submitForm = function(valid) {
        if (valid) {
            $scope.user.isRegister = $scope.loginData.showLogin;
            $.ccPost(`${REQUEST_PATH}/yht/login`, JSON.stringify($scope.user), function(resp) {
                if (resp.success) {
                    window.location.href = "../user/user.html";
                }
            });
        }
    }
}]);