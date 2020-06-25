$('#products').on('click', '.col-md-3', function () {
    var productID=$(this).attr('id');
    viewProduct(productID);
});
$('#products2').on('click', '.col-md-3', function () {
    var productID=$(this).attr('id');
    viewProduct(productID);
});
$('#products1').on('click', '.col-md-3', function () {
    var productID=$(this).attr('id');
    viewProduct(productID);
});

function viewProduct(id) {
    var priceId = "#" + id + " .productPrice";
    var productId = "#" + id + " .productName";
    var imgSourceId = "#" + id + " .img-src";
    var price = $(priceId).text();
    var productName = $(productId).text();
    var imgSource = $(imgSourceId).attr('src');
    $("#products").append("<button type='button' class='btn btn - primary btn - lg' data-toggle='modal' data-target='#"+id+"-modal' id='btn-modal-"+id+"' style='display:none;'>Launch</button>"
        + "<div class='modal fade' id='"+id+"-modal' tabindex='-1' role='dialog' aria-labelledby='modelTitleId' aria-hidden='true'>"
        + "<div class='modal-dialog modal-lg' role='document'>"
        + "<div class='modal-content'>"
        + "<div class='modal-header'>"
        + "<h5 class='modal-title'>Product Detail</h5>"
        + "<button type='button' class='close' data-dismiss='modal' aria-label='Close'>"
        + "<span aria-hidden='true'>&times;</span>"
        + "</button>"
        + "</div>"
        + "<div class='modal-body'>"
        + "<div class='row'>"
        + "<div class='col-md-6'>"
        + "<img class='card-img-top' src='" + imgSource + "' style='width:100%' />"
        + "</div>"
        + "<div class='col-md-6'>"
        + "<h5>" + productName + "</h5>"
        + "<h5>" + price + "</h5>"
        + "</div>"
        + "</div>"
        + "</div>"
        + "<div class='modal-footer'>"
        + "<button type='button' class='btn btn-secondary' data-dismiss='modal'>Close</button>"
        + "<button type='button' class='btn btn-primary'>Add Cart</button>"
        + "</div>"
        + "</div>"
        + "</div>"
        + "</div>");
        var modalID="#btn-modal-"+id;
    $(modalID).trigger("click");
}

function createProduct() {
    var name = $('#newProductName').val();
    var imgSource = $('#newProductImg').val();
    var price = $('#newProductPrice').val();
    var lastProductID=$('#products .col-md-3').last().attr('id');
    var newProductID=parseInt(lastProductID.charAt(lastProductID.length-1))+1;
    $('#products').append(
        "<div class='col-md-3' id='product"+newProductID+"'>"
        + "<div class='card'>"
        + "<img class='card-img-top img-src' src='" + imgSource + "' style='width:80%' />"
        + "<hr>"
        + "<div class='card-body'>"
        + "<div class='row'>"
        + "<div class='col-md-10'>"
        + "<h5 class='card-title productName'>" + name + "</h5>"
        + "</div>"
        + "<div class='col-md-2'>"
        + "<i class='far fa-heart'></i>"
        + "</div>"
        + "</div>"
        + "<p class='card-text productPrice'>" + price + "</p>"
        + "</div>"
        + "</div>"
        + "</div>");
}

$('#search').keyup(function () {
    searchProduct();
});

function searchProduct() {
    var txtSearch = $('#search').val().toUpperCase();
    $('#products .col-md-3').each(function () {
        var element = $(this).find("h5");
        var elementValue = element.text().toUpperCase();
        if (elementValue.indexOf(txtSearch) != -1) {
            $(this).show();
        } else $(this).hide();
    })
}