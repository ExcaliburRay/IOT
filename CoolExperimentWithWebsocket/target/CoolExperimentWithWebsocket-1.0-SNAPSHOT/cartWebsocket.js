var lastCartUpdate = 0;
//websocket standard statement
var wsUri = "ws://" + document.location.host + document.location.pathname + "MyCartendpoint";
var websocket = new WebSocket(wsUri);

// send message to function updateCart
websocket.onmessage = updateCart;

function onMessage(evt) {
    console.log("received Message: "+evt.data);
}

//websocket error report function
websocket.onerror = function(evt) { onError(evt); };

function onError(evt) {
    console.log("error: "+evt.data);
}
//send info to server to control the addItem operation  
function addToCart(itemCode) {
    
    var order = '{"action":"addToCart","item":"'+itemCode+'"}';
    websocket.send(order);
}
//send info to server to control the removeItem operation 
function removeToCart(itemCode) {

    var order = '{"action":"removeToCart","item":"'+itemCode+'"}';
    websocket.send(order);
}

//update the cart info
function updateCart(cartJson) {
 //obtain the node cart and childnode generated
 //check the cart whether updated by comparing the diferences between the reference of generated
   var contents = document.getElementById("contents");
   contents.innerHTML = "";
   var cart = JSON.parse(cartJson.data);
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
