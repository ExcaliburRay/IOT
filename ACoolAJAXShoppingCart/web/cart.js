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


/*
 * Update shopping-cart area of page to reflect contents of cart
 * described in XML document.
 */
function updateCart(cartXML) {
 //obtain the node cart and childnode generated
 var cart = cartXML.getElementsByTagName("cart")[0];
 var generated = cart.getAttribute("generated");
 //check the cart whether updated by comparing the diferences between the reference of generated
 if (generated > lastCartUpdate) {
   lastCartUpdate = generated;
   var contents = document.getElementById("contents");
   contents.innerHTML = "";

   var items = cart.getElementsByTagName("item");
   //obtain the content of childnode respectively
   for (var I = 0 ; I < items.length ; I++) {

     var item = items[I];
     var name = item.getElementsByTagName("name")[0].firstChild.nodeValue;
     var quantity = item.getElementsByTagName("quantity")[0].firstChild.nodeValue;

     //add the listItem info into viewer layer
     var listItem = document.createElement("li");
     listItem.appendChild(document.createTextNode(name+" x "+quantity));
     contents.appendChild(listItem);
   }

 }
 //obtain the info based on the childnode is total
 document.getElementById("total").innerHTML = cart.getAttribute("total");
}
