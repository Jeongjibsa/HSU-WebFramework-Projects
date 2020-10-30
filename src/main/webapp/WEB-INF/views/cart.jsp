<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="<c:url value="/resources/js/controller.js" /> "></script>

<div class="container-wrapper">
	<div class="container-fluid">
		<div class="jumbotron">
			<div class="container-fluid">
				<h2>Cart</h2>

				<p>All the selected products in your shopping cart</p>
			</div>
		</div>


		<section class="container-fluid" ng-app="cartApp">
			<div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
				<a class="btn btn-warning pull-left" ng-click="clearCart()"> <i
					class="fas fa-trash"></i> Clear Cart
				</a> <br />

				<table class="table table-hover">
					<tr>
						<th>Product</th>
						<th>Unit Price</th>
						<th>Quantity</th>
						<th>Total Price</th>
						<th>Action</th>
					</tr>

					<tr ng-repeat="item in cart.cartItems">
						<td>{{item.product.name}}</td>
						<td>{{item.product.price}}</td>
						<td>{{item.quantity}}</td>
						<td>{{item.totalPrice}}</td>
						<td>
							<div class="d-flex flex-wrap justify-content-center">
								<div class="p-1">
									<a class="btn btn-danger"
										ng-click="removeFromCart(item.product.id)"> <i
										class="fas fa-times"></i>remove
									</a>
								</div>
								<div class="p-1">
									<a class="btn btn-danger"
										ng-click="plusFromCart(item.product.id)"> <i
										class="fas fa-plus"></i>plus
									</a>
								</div>
								<div class="p-1">
									<a class="btn btn-danger"
										ng-click="minusFromCart(item.product.id)"> <i
										class="fas fa-minus"></i>minus
									</a>
								</div>
							</div>
						</td>
					</tr>

					<tr>
						<td></td>
						<td></td>
						<td>Grand Total</td>
						<td>{{calGrandTotal()}}</td>
						<td></td>
					</tr>
				</table>

				<a class="btn btn-info" href="<c:url value="/products" />"
					class="btn btn-default">Continue Shopping</a>
			</div>
		</section>

	</div>
</div>