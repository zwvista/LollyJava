$ ->
    $lang = $('#selectedLangID')
    $dict = $('#selectedDictName')
    $lang.change ->
         $.get "dictList", $('form').serialize(), (response) ->
            $dict.empty()
            $.each response, (index, dict) ->
                $dict.append $('<option/>', {text: dict})
    $lang.change()
    $('form').submit ->
        event.preventDefault()
        $.ajax {
            type: "GET",
            url: "dictall",
            data: $('form').serialize(),
            error: (response) ->
                //alert(JSON.stringify(response))
                $('#wordError').html "word: " + response.responseJSON.word
                $('#dictframe').attr 'src', 'about:blank'
            ,
            success: (response) ->
                word = $('#word').val()
                url = response.url.replace '{0}', encodeURIComponent(word)
                $('#dictframe').attr 'src', url
        }
