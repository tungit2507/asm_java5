<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="common/_css.jsp" %>
<title>Insert title here</title>
</head>
<body>
<%@ include file="common/_header.jsp" %>
<div class="container-fluid pb-5">
        <div class="row px-xl-5">
            <div class="col-lg-5 mb-30">
               
                    <div class="carousel-inner bg-light">
                        <div class="carousel-item active">
                            <img class="w-100 h-100 " src="templates/img/${product.images}" alt="Image">
                        </div>
                        
                    </div>
                    
                
            </div>

            <div class="col-lg-7 h-auto mb-30">
                <div class="h-100 bg-light p-30">
                    <h3>${product.names}</h3>
                    <div class="d-flex mb-3">
                        <div class="text-primary mr-2">
                        <c:forEach begin="1" end="${avg }">
                            <small class="fas fa-star"></small>
                         </c:forEach>
                          <c:forEach begin="${avg }" end="4">
                            <small class="far fa-star"></small>
                         </c:forEach>
                        </div>
                        <small class="pt-1">(${count } reviews)</small>
                    </div>
                    <h3 class="font-weight-semi-bold mb-4" id="price"> ${product.price}$</h3>
                    
                   	 <input hidden id="priceProduct" value="${product.price}">
                    <div class="d-flex align-items-center mb-4 pt-2">
                        <div class="input-group quantity mr-3" style="width: 130px;">
                            <div class="input-group-btn">
                                <button class="btn btn-primary btn-minus" >
                                    <i class="fa fa-minus"></i>
                                </button>
                            </div>
                            <input id="quantity" type="text" value="1"  class="form-control bg-secondary border-0 text-center">
                            <div class="input-group-btn">
                                <button class="btn btn-primary btn-plus"  >
                                    <i class="fa fa-plus"></i>
                                </button>
                            </div>
                        </div>
                        <button class="btn btn-primary px-3" onclick="addToCart('${product.id}',1)" ><i class="fa fa-shopping-cart mr-1"></i>Add To Cart</button>
                    </div>
                    <div class="d-flex pt-2">
                        <strong class="text-dark mr-2">Share on:</strong>
                        <div class="d-inline-flex">
                            <a class="text-dark px-2" href="">
                                <i class="fab fa-facebook-f"></i>
                            </a>
                            <a class="text-dark px-2" href="">
                                <i class="fab fa-twitter"></i>
                            </a>
                            <a class="text-dark px-2" href="">
                                <i class="fab fa-linkedin-in"></i>
                            </a>
                            <a class="text-dark px-2" href="">
                                <i class="fab fa-pinterest"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row px-xl-5">
            <div class="col">
                <div class="bg-light p-30">
                    <div class="nav nav-tabs mb-4">
                        <a class="nav-item nav-link text-dark active" data-toggle="tab" href="#tab-pane-1">Description</a>
               
                        <a class="nav-item nav-link text-dark" data-toggle="tab" href="#tab-pane-3">Reviews (${count })</a>
                    </div>
                    <div class="tab-content">
                        <div class="tab-pane fade show active" id="tab-pane-1">
                            <h4 class="mb-3">Product Description</h4>
                            <p>${product.descriptions}</p>
                              </div>
                        
                        <div class="tab-pane fade" id="tab-pane-3">
                            <div class="row">
                                <div class="col-md-6">
                                	<c:forEach var="item" items="${product_access }">
                                	<div class="col-md-12">
                                    <h4 class="mb-4">${item.product.names }</h4>
                                    <div class="media mb-4">
                                        <div class="media-body">
                                            <h6>${item.users.username }<small> - <i>01 Jan 2045</i></small></h6>
                                            <div class="text-primary mb-2">
                                            <c:forEach begin="1" end="${item.start_rate }">
                                            	 <i class="fas fa-star"></i>
                                            </c:forEach>
                                               <c:forEach begin="${item.start_rate }" end="4">
                                               <i class="far fa-star"></i>
                                               </c:forEach>
                                                
                                            </div>
                                            <p>${item.content }</p>
                                        </div>
                                    </div>
                                </div>
                                </c:forEach>
                                </div>
								<input type="submit" value="${product.id }" hidden id="productid"/>
								    <div class="col-md-6" ${hidden }>
                                    <h4 class="mb-4">Leave a review</h4>
                                    <small>Your email address will not be published. Required fields are marked *</small>          
                                    <form action="productdetail/add" method="POST" >
                                    	<div class="d-flex my-3">
                                        <p class="mb-0 mr-2">Your Rating * :</p>
                                        <div class="form-check form-check-inline">
  											<input class="form-check-input" type="radio" name="radio" value="1" />
  											<label class="form-check-label" for="inlineRadio1">1 sao</label>
										</div>
										<div class="form-check form-check-inline">
 											<input class="form-check-input" type="radio" name="radio" value="2" />
  											<label class="form-check-label" for="inlineRadio2">2 sao</label>
										</div>
										<div class="form-check form-check-inline">
  											<input class="form-check-input" type="radio" name="radio" value="3"  />
  											<label class="form-check-label" for="inlineRadio3">3 sao</label>
										</div>
										<div class="form-check form-check-inline">
  											<input class="form-check-input" type="radio" name="radio"value="4"  />
  											<label class="form-check-label" for="inlineRadio3">4 sao</label>
										</div>
										<div class="form-check form-check-inline">
 											<input class="form-check-input" type="radio" name="radio"  value="5" checked  />
  											<label class="form-check-label" for="inlineRadio3">5 sao</label>
										</div>
                                    </div>
										<input  hidden value="${product.id }" name="productid"/>
                                        <div class="form-group">
                                            <label for="message">Your Review *</label>
                                            <textarea name="content" id="message" cols="30" rows="5" class="form-control"></textarea>
                                        </div>
                                       	<p>${message }</p>
                                        <div class="form-group mb-0">
                                            <input type="submit" value="Leave Your Review" class="btn btn-primary px-3">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Shop Detail End -->
<%@ include file="common/_footer.jsp" %>
</body>
</html>
<%@ include file="common/_js.jsp" %>
<script type="text/javascript">


	function addToCart(productId) {
		var quantity = $('#quantity').val();
		$.ajax({
		  url: '/cart/add?productId='+productId+"&quantity="+quantity,
		  type: 'POST',
		  success: function(response) {
		    	alert(response);
		  },
		  error: function(xhr, status, error) {
			  alert("That Bai");	
		  }
		});
	}
	
	
</script>