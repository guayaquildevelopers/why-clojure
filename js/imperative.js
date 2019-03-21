

function prepareForCheckout(lineItems) {
  var item = {}
  for (var i = 0; i < lineItems.length; i++) {
    item = lineItems[i]
    item.subtotal = (item.price * (1 - discount) * item.quantity)
    var stock = getStockInfo(item.productId)
    item.inStock = stock.quantity >= item.quantity
  }
  return lineItems
}
