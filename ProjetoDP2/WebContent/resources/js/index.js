$(document).ready(function() {
    
    carregaSelectDestino();

    $(".datepicker").datepicker({
        dateFormat: 'dd/mm/yy',
        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
    });

    $("#buscarVoo").on("click", function(){
        console.log("clicou")
        buscarVoos();
    });
});

function carregaSelectDestino(){
    
    $.ajax({
        method: "GET",
        dataType: "JSON",
        contentType: "charset=utf-8", 
        url: "ComprarPassagem.do"
    })
    .done(function(response){

        for (const i in response) {

            $("#selectOrigem").append("<option value="+response[i].origem+">"+response[i].origem+"</option>")
            $("#selectDestino").append("<option value="+response[i].destino+">"+response[i].destino+"</option>")
        }
    });
}

function buscarVoos(){

    $("#dataTableComprarPassagem").DataTable({
        "processing": true,
        "serverSide": true,
        "searching": false,
        scrollX: true,
        autoWidth: true,
        language: {
            thousands: ".",
            info: "Mostrando START a END ( Total de TOTAL registros )",
            lengthMenu: '<span>Mostrar:</span> _MENU_',
            zeroRecords:"Nenhum registro encontrado",
            emptyTable: "Nenhum registro encontrado",
            paginate: { 'primeiro': 'Primeiro', 'último': 'Último', 'próximo': '&rarr;', 'anterior': '&larr;' },
            paginate: {
                first: "Primeira",
                previous: "Anterior",
                next: "Próxima",
                last: "Última"
            },
            aria: {
                sortAscending: "Classificar na ordem crescente",
                sortDescending: "Classificar na ordem decrescente"
            },
        },

        ajax: {
            url: "ComprarPassagem.do"
        },
        initComplete: function() {
            console.log("carregou datatable")
        }        
    });
}