var cartApp = angular.module('cartApp', []);

cartApp.controller("cartCtrl", function($scope, $http) {

	$scope.initCartId = function(cartId) {
		$scope.cartId = cartId;
		$scope.refreshCart();

	};

	$scope.refreshCart = function() {

		$http.get('/eStore/api/cart/' + $scope.cartId).then(
				function successCallback(response) {
					$scope.cart = response.data;
				});
	};

	$scope.clearCart = function() {

		$http({
			method : 'DELETE',
			url : '/eStore/api/cart/' + $scope.cartId
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			console.log(response.data);
		});

	};

	$scope.addToCart = function(productId) {

		$http.put('/eStore/api/cart/cartItem/' + productId).then(
				function successCallback() {
					alert("Product successfully added to the cart!");

				}, function errorCallback() {
					alert("Adding to the cart failed!")
				});
	};

	$scope.removeFromCart = function(productId) {

		$http({
			method : 'DELETE',
			url : '/eStore/api/cart/cartItem/' + productId,
			data: $.param()
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			console.log(response.data);
		});
	};

	$scope.plusFromCart = function(productId) {

		$http({
			method : 'PUT',
			url : '/eStore/api/cart/cartItem/plus-qty/' + productId
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			alert("재고가 부족합니다.")
			console.log(response.data);
		});
	};

	$scope.minusFromCart = function(productId) {

		$http({
			method : 'PUT',
			url : '/eStore/api/cart/cartItem/minus-qty/' + productId
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			alert("더 이상 수량을 줄일 수 없습니다.")
			console.log(response.data);
		});
	};

	$scope.calGrandTotal = function() {
		var grandTotal = 0;

		for (var i = 0; i < $scope.cart.cartItems.length; i++) {
			grandTotal += $scope.cart.cartItems[i].totalPrice;
		}

		return grandTotal;
	};

});