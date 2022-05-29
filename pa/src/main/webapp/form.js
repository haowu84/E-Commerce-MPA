function getCityState(zipcode)
{
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function()
    { 
        if (xhr.readyState == 4 && xhr.status == 200)
        { 
            var location = xhr.responseText.split(",");
            
            document.getElementById("state").value = location[0];
            document.getElementById("city").value = location[1];
        } 
    }

    xhr.open ("POST", "citystate", true);
    xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
    xhr.send ("zipcode="+zipcode);  
}

function getTaxRate()
{
    var xhr = new XMLHttpRequest();
    
    xhr.onreadystatechange = function()
    { 
        if (xhr.readyState == 4 && xhr.status == 200)
        { 
            var price = xhr.responseText.split(",");
            
            document.getElementById("subtotal").value = price[0];
            document.getElementById("taxrate").value = price[1];
            document.getElementById("total").value = price[2];
        } 
    }

    xhr.open ("POST", "taxrate", true);
    xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
    xhr.send ("zipcode="+document.getElementById("zipcode").value);  
}