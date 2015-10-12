$ ->
    $.get "/hotels", (hotels) ->
        $.each hotels,(index, hotel) ->
            $('#hotels').append $("<li>").text hotel.hotelName
