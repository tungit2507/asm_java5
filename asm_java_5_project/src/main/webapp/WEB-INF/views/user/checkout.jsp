<%@ page  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ include file="common/_css.jsp" %>
<title>Insert title here</title>
</head>
<body>

<%@ include file="common/_header.jsp" %>
<div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-lg-12">
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Billing Address</span></h5>
                <div class="bg-light p-30 mb-5">
                    <div class="row">
                        <div class="col-md-6 form-group">
                            <label>Name</label>
                            <input class="form-control" type="text" value="${user.username }" disabled>
                        </div>
                        
                        <div class="col-md-6 form-group">
                            <label>Mobile No</label>
                            <input class="form-control" type="text" value="${user.phone_number }" disabled>
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Address</label>
                            <input class="form-control" type="text" value="${user.adress }" disabled>
                        </div>
          
                    </div>
                </div>
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Order Total</span></h5>
                <div class="bg-light p-30 mb-5">
                    <div class="border-bottom">
						<table class="table table-borderless">
							<thead>
								<tr style="border-bottom: none">
									<th>Products</th>
									<th>Quantity</th>
									<th>Price</th>
									<th>Subtotal</th>
								</tr>
							</thead>
							<tbody>
							 <c:forEach var="item" items="${list }">
								<tr style="border-bottom: none">
									<td>${item.product.names }</td>
									<td>${item.quantity }</td>
									<td>${item.product.price }</td>
									<td class="subtotal">${item.product.price * item.quantity} $</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>                           
                    </div>                
                    <div class="pt-2">
                        <div class="d-flex justify-content-between mt-2">
                            <h5>Total</h5>
                            <h5>${sum } $</h5>
                        </div>
                    </div>
                </div>
               <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Payment</span></h5>
                    <div class="bg-light p-30">
                        <a href="cart/checkout" class="btn btn-block btn-primary font-weight-bold py-3">Place Order</a>
                    </div>
            </div>
            <div class="col-lg-4">
                
                <div class="mb-5">
                    
                </div>
            </div>
        </div>
    </div>
    <!-- Checkout End -->
<%@ include file="common/_footer.jsp" %>
</body>
</html>
<%@ include file="common/_js.jsp" %>