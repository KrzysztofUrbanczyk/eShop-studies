var template = [
    '<li>',
    '<span>_id_</span> ',
    '<span>_price_</span> ',
    '<button>Add</button> ',
    '</li>'

].join("");

var productList = $(".product-list")

axios.get('/products')
    .then(function (response) {
    response.data
        .map(function (productData) {
        var tmp = template.replace('_id_', productData.id);
        var tmp = tmp.replace('_price_', productData.price);
        return tmp;
        })
        .forEach(function (html) {

            productList.append(html)
        })
    })
    .catch(function (error) {
        console.log(error);
});
