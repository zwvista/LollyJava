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
        $.get "dictall", $('form').serialize(), (response) ->
            word = $('#word').val()
            url = response.url.replace '{0}', encodeURIComponent(word)
            $('#dictframe').attr 'src', url
