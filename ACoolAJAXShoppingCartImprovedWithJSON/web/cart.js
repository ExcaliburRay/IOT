// Timestamp of cart that page was last updated with
var lastCartUpdate = 0;

/*
 * Adds the specified item to the shopping cart, via Ajax call
 * itemCode - product code of the item to add
 */

function addToCart(itemCode) {
 
 var req = newXMLHttpRequest();
 //revoke the update function when the state changed
 req.onreadystatechange = getReadyStateHandler(req, updateCart);
 
 req.open("POST", "cart.do", true);
 req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 req.send("action=add&item="+itemCode);
}


function removeToCart(itemCode) {
 var req = newXMLHttpRequest();

 req.onreadystatechange = getReadyStateHandler(req, updateCart);
 
 req.open("POST", "cart.do", true);
 req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 req.send("action=remove&item="+itemCode);   
}

/*
 * Update shopping-cart area of page to reflect contents of cart
 * described in XML document.
 */
function updateCart(cartJson) {
 //obtain the node cart and childnode generated
 //var generated = cart.getString("generated");
 //check the cart whether updated by comparing the diferences between the reference of generated

   //lastCartUpdate = generated;
   var contents = document.getElementById("contents");
   contents.innerHTML = "";
   var cart = JSON.parse(cartJson);
   var generated = cart.cart.generated;
   if (generated>lastCartUpdate) {
     var items = cart.cart.item;
     for (var key in items) {
        var itemInfo = items[key];
        console.log(itemInfo);
        var name = itemInfo.name;
        var quantity = itemInfo.quantity;
        //add the listItem info into viewer layer
        var listItem = document.createElement("li");
        listItem.appendChild(document.createTextNode(name+" x "+quantity));
        contents.appendChild(listItem);
      }
    }
 //obtain the info based on the childnode is total
 document.getElementById("total").innerHTML = cart.cart.total;
}
