var data;
$(document).ready(function () {

    $.ajax({
        url: "/api/rebels",

        success: function (json){
            data = json;
            enterRegister("fullRegister");
            printRebels(json);
            filter();

        },
        error: function () {
            alert("Something wrong happened. We can not get the info required.");
        }

    });

    function enterRegister(urlPost) {
        $("#register").click(function (){
            $.post("/api/"+urlPost, {
                name: $("input[name='nameRebel']")[0].value,
                planet: $("input[name='planet']")[0].value})
                .done(function(a){
                    printAlert(a.success);
                    setInterval(function(){ window.location.reload(); }, 7000);

                })
                .fail(function(e){
                    printAlert(e.responseJSON.error);
                });

        });
    }

    function printAlert(text) {
        $("#alert").text(text);
        $("#alert").fadeIn(3000);
        $("#alert").fadeOut(4000);

    }

    function printRebels(data){
        for(var i=0; i < data.rebels.length; i++){
            var tr = document.createElement("tr");
            var tdName = document.createElement("td");
            var tdPlanet = document.createElement("td");
            var tdDate = document.createElement("td");

            tdName.setAttribute("class", "tdName");
            tdPlanet.setAttribute("class", "tdPlanet");
            tdDate.setAttribute("class", "tdDate");

            tdName.innerText= data.rebels[i].name;
            tdPlanet.innerText=data.rebels[i].planet;
            var fullDate = data.rebels[i].date_register;
            fullDate = fullDate.slice(0,10);
            tdDate.innerText= fullDate;

            tr.appendChild(tdName);
            tr.appendChild(tdPlanet);
            tr.appendChild(tdDate);
            $("#table").append(tr);

        }
    }

    function filterBy(elementId, num){
        var input = document.getElementById(elementId);
        var inputFilter = input.value;
        var table = document.getElementById("fullTable");
        var tr = table.getElementsByTagName("tr");

        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[num];
            if (td) {
                if (td.innerHTML.indexOf(inputFilter) > -1) {
                    tr[i].style.display = "";

                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }

    function filter(){
        $("#searchName").keyup(function(){filterBy("searchName",0)});
        $("#searchPlanet").keyup(function(){filterBy("searchPlanet",1)});
    }

});